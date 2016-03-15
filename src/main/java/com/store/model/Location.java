
package com.store.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class Location {

    @JsonProperty("name")
    private String name;
    @JsonProperty("address")
    private List<String> address = new ArrayList<String>();
  

    /**
     *
     * @return
     *     The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     *     The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     *     The address
     */
    @JsonProperty("address")
    public List<String> getAddress() {
        return address;
    }

    /**
     *
     * @param address
     *     The address
     */
    @JsonProperty("address")
    public void setAddress(List<String> address) {
        this.address = address;
    }


}
