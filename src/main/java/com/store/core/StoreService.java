package com.store.core;

import org.springframework.stereotype.Service;
import com.store.model.Store;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.Future;

@Service
public class StoreService {

    private final WebTarget target = ClientBuilder.newClient().target("http://localhost:9090");

    public Future<Store> storeAsync(String user) {
        return target
                .path("v1/stores/2804")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .async()
                .get(Store.class);
    }


}
