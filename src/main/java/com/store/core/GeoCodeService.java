package com.store.core;

import org.springframework.stereotype.Service;

import com.store.model.GeoCode;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.Future;

@Service
public class GeoCodeService {

    private final WebTarget target = ClientBuilder.newClient().target("http://localhost:9090/geocoder/v1/fuzzy?q=weybridge");

    public Future<GeoCode> locationAsync(String storeName) {
        return target
            //  .path("geocoder/v1/fuzzy?q=weybridge")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .async()
                .get(GeoCode.class);
    }


}
