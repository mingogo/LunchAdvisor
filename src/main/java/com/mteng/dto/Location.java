
package com.mteng.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class Location {

    private String city;
    private List<String> displayAddress = new ArrayList<String>();
    private Double geoAccuracy;
    private String postalCode;
    private String countryCode;
    private List<String> address = new ArrayList<String>();

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<String> getDisplayAddress() {
        return displayAddress;
    }

    public void setDisplayAddress(List<String> displayAddress) {
        this.displayAddress = displayAddress;
    }

    public Double getGeoAccuracy() {
        return geoAccuracy;
    }

    public void setGeoAccuracy(Double geoAccuracy) {
        this.geoAccuracy = geoAccuracy;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    private Coordinate coordinate;
    private String stateCode;
}
