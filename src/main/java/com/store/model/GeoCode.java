
package com.store.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeoCode {

    @JsonProperty("locations")
    private List<Location> locations = new ArrayList<Location>();
    /**
     *
     * @return
     *     The locations
     */
    @JsonProperty("locations")
    public List<Location> getLocations() {
        return locations;
    }

    /**
     *
     * @param locations
     *     The locations
     */
    @JsonProperty("locations")
    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

}
