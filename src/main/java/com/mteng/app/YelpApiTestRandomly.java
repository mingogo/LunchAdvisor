package com.mteng.app;

import com.mteng.dto.ResponseContainer;
import com.mteng.service.yelp.YelpAPI;

/**
 * Created by mingogo on 2/26/15.
 */
public class YelpApiTestRandomly {

    private static final String CONSUMER_KEY = "lU0rpCBvv-zC1YAb27A8oA";
    private static final String CONSUMER_SECRET = "CaQa-iJgqdA8DPCwmLuG_tDFFq0";
    private static final String TOKEN = "tTMj0fWBm318eiBzA139AbwlEeSGO_7L";
    private static final String TOKEN_SECRET = "LdFo6jCQKQztNCAKPAeSSU8vZtk";

    public static void main (String argv[]) {
        YelpAPI yelpApi = new YelpAPI(CONSUMER_KEY, CONSUMER_SECRET, TOKEN, TOKEN_SECRET);
        String location = "Reading, PA";
        String term = "lunch";
        ResponseContainer responseContainer = yelpApi.queryAPIRandomly(yelpApi,location,term);
        System.out.println(responseContainer.getName());
    }
}
