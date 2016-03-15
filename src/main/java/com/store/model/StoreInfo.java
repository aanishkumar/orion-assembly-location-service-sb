package com.store.model;


public class StoreInfo {
    private final GeoCode location;
    private final Store store;

    public StoreInfo(Store store, GeoCode location) {
        this.location = location;
        this.store = store;
    }

    public GeoCode getLocation() {
        return location;
    }

    public Store getStore() {
        return store;
    }
}
