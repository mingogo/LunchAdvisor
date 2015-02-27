package com.mteng.resource;

import com.mteng.service.yelp.YelpAPI;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("/wheretoeat")
public class YelpService {

	private static final String CONSUMER_KEY = "lU0rpCBvv-zC1YAb27A8oA";
	private static final String CONSUMER_SECRET = "CaQa-iJgqdA8DPCwmLuG_tDFFq0";
	private static final String TOKEN = "tTMj0fWBm318eiBzA139AbwlEeSGO_7L";
	private static final String TOKEN_SECRET = "LdFo6jCQKQztNCAKPAeSSU8vZtk";

	@GET
	public Response responseMsg(@QueryParam("location") String location, @QueryParam("term") String term) {
		YelpAPI yelpApi = new YelpAPI(CONSUMER_KEY, CONSUMER_SECRET, TOKEN, TOKEN_SECRET);
		Object output = null;
		// output = yelpApi.queryAPIv2(yelpApi,location,term);
		output = yelpApi.queryAPIRandomly(yelpApi,location,term);
		return Response.status(200).entity(output).build();
	}
}
