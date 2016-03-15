package com.store.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Store{

private String name;
private String storeType;

    public String getName() {
        return name;
    }

    public String getStoreType() {
        return storeType;
    }

    public Store(@JsonProperty("name") String name, @JsonProperty("storeType") String storeType) {
    this.name = name;
    this.storeType=storeType;

}

}
