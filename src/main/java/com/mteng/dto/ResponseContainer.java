package com.mteng.dto;

/**
 * Created by mingogo on 2/26/2015.
 */
public class ResponseContainer {
    private String name;
    private String url;
    private Integer width;
    private Integer height;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPeopleTalkAbout() {
        return peopleTalkAbout;
    }

    public void setPeopleTalkAbout(String peopleTalkAbout) {
        this.peopleTalkAbout = peopleTalkAbout;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

    private String text;
    private String peopleTalkAbout;
    private String ratings;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String address;

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
