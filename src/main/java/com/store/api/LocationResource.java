package com.store.api;

import com.store.core.GeoCodeService;
import com.store.core.StoreService;
import com.store.model.Store;
import com.store.model.StoreInfo;
import com.store.utils.Futures;
import org.springframework.core.task.TaskExecutor;
import com.store.model.GeoCode;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;
import static javax.ws.rs.core.Response.Status.SERVICE_UNAVAILABLE;

@Path("/")
public class LocationResource {

    @Inject
    private StoreService storeService;

    @Inject
    private GeoCodeService geoCodeService;

    @Inject
    private TaskExecutor executor;

    @GET
    @Path("/location/{storename}")
    @Produces(MediaType.APPLICATION_JSON)
    public void userInfoAsync(@Suspended AsyncResponse asyncResponse, @PathParam("storename") String storename) {


        CompletableFuture<GeoCode> locationFuture = Futures.toCompletable(geoCodeService.locationAsync(storename), executor);
        CompletableFuture<Store> storeFuture = Futures.toCompletable(storeService.storeAsync(storename), executor);

        locationFuture
                .thenCombine(
                        storeFuture, (g, f) -> new StoreInfo(f, g))
                .thenApply(
                        info -> asyncResponse.resume(info))
                .exceptionally(
                        e -> asyncResponse.resume(Response.status(INTERNAL_SERVER_ERROR).entity(e).build()));

        asyncResponse.setTimeout(100000, TimeUnit.MILLISECONDS);
        asyncResponse.setTimeoutHandler(
                ar -> ar.resume(Response.status(SERVICE_UNAVAILABLE).entity("Operation timed out").build()));

    }

}
