package com.mteng.service.yelp;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.mteng.dto.ResponseContainer;
import com.mteng.dto.Yelp;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

import java.awt.*;
import java.util.List;
import java.util.Random;

/**
 * Code sample for accessing the Yelp API V2.
 * <p/>
 * This program demonstrates the capability of the Yelp API version 2.0 by using the Search API to
 * query for businesses by a search term and location, and the Business API to query additional
 * information about the top result from the search query.
 * <p/>
 * <p/>
 * See <a href="http://www.yelp.com/developers/documentation">Yelp Documentation</a> for more info.
 */
public class YelpAPI {

    private static final String API_HOST = "api.yelp.com";
    private static final String DEFAULT_TERM = "dinner";
    // private static final String DEFAULT_LOCATION = "San Francisco, CA";
    private static final String DEFAULT_LOCATION = "Reading, PA";
    private static final int SEARCH_LIMIT = 3;
    private static final String SEARCH_PATH = "/v2/search";
    private static final String BUSINESS_PATH = "/v2/business";

    /*
     * Update OAuth credentials below from the Yelp Developers API site:
     * http://www.yelp.com/developers/getting_started/api_access
     */
    private static final String CONSUMER_KEY = "lU0rpCBvv-zC1YAb27A8oA";
    private static final String CONSUMER_SECRET = "CaQa-iJgqdA8DPCwmLuG_tDFFq0";
    private static final String TOKEN = "tTMj0fWBm318eiBzA139AbwlEeSGO_7L";
    private static final String TOKEN_SECRET = "LdFo6jCQKQztNCAKPAeSSU8vZtk";

    OAuthService service;
    Token accessToken;

    /**
     * Setup the Yelp API OAuth credentials.
     *
     * @param consumerKey    Consumer key
     * @param consumerSecret Consumer secret
     * @param token          Token
     * @param tokenSecret    Token secret
     */
    public YelpAPI(String consumerKey, String consumerSecret, String token, String tokenSecret) {
        this.service =
                new ServiceBuilder().provider(TwoStepOAuth.class).apiKey(consumerKey)
                        .apiSecret(consumerSecret).build();
        this.accessToken = new Token(token, tokenSecret);
    }

    /**
     * Returns a pseudo-random number between min and max, inclusive.
     * The difference between min and max can be at most
     * <code>Integer.MAX_VALUE - 1</code>.
     *
     * @param min Minimum value
     * @param max Maximum value.  Must be greater than min.
     * @return Integer between min and max, inclusive.
     * @see java.util.Random#nextInt(int)
     */
    public static int randInt(int min, int max) {

        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    /**
     * Creates and sends a request to the Search API by term and location.
     * <p/>
     * See <a href="http://www.yelp.com/developers/documentation/v2/search_api">Yelp Search API V2</a>
     * for more info.
     *
     * @param term     <tt>String</tt> of the search term to be queried
     * @param location <tt>String</tt> of the location
     * @return <tt>String</tt> JSON Response
     */
    public String searchForBusinessesByLocation(String term, String location) {
        OAuthRequest request = createOAuthRequest(SEARCH_PATH);
        request.addQuerystringParameter("term", term);
        request.addQuerystringParameter("location", location);
        request.addQuerystringParameter("limit", String.valueOf(SEARCH_LIMIT));
        return sendRequestAndGetResponse(request);
    }

    public String searchForBusinessesByLocation(String term, String location,Integer searchLimit) {
        OAuthRequest request = createOAuthRequest(SEARCH_PATH);
        request.addQuerystringParameter("term", term);
        request.addQuerystringParameter("location", location);
        request.addQuerystringParameter("limit", String.valueOf(searchLimit));
        return sendRequestAndGetResponse(request);
    }

    /**
     * Creates and sends a request to the Business API by business ID.
     * <p/>
     * See <a href="http://www.yelp.com/developers/documentation/v2/business">Yelp Business API V2</a>
     * for more info.
     *
     * @param businessID <tt>String</tt> business ID of the requested business
     * @return <tt>String</tt> JSON Response
     */
    public String searchByBusinessId(String businessID) {
        OAuthRequest request = createOAuthRequest(BUSINESS_PATH + "/" + businessID);
        return sendRequestAndGetResponse(request);
    }

    /**
     * Creates and returns an {@link org.scribe.model.OAuthRequest} based on the API endpoint specified.
     *
     * @param path API endpoint to be queried
     * @return <tt>OAuthRequest</tt>
     */
    private OAuthRequest createOAuthRequest(String path) {
        OAuthRequest request = new OAuthRequest(Verb.GET, "http://" + API_HOST + path);
        return request;
    }

    /**
     * Sends an {@link org.scribe.model.OAuthRequest} and returns the {@link org.scribe.model.Response} body.
     *
     * @param request {@link org.scribe.model.OAuthRequest} corresponding to the API request
     * @return <tt>String</tt> body of API response
     */
    private String sendRequestAndGetResponse(OAuthRequest request) {
        System.out.println("Querying " + request.getCompleteUrl() + " ...");
        this.service.signRequest(this.accessToken, request);
        Response response = request.send();
        return response.getBody();
    }

    /**
     * Queries the Search API based on the command line arguments and takes the first result to query
     * the Business API.
     *
     * @param yelpApi    <tt>YelpAPI</tt> service instance
     * @param yelpApiCli <tt>YelpAPICLI</tt> command line arguments
     * @should return result JSON
     */
    private static void queryAPI(YelpAPI yelpApi, YelpAPICLI yelpApiCli) {
        String searchResponseJSON =
                yelpApi.searchForBusinessesByLocation(yelpApiCli.term, yelpApiCli.location);

        JSONParser parser = new JSONParser();
        JSONObject response = null;
        try {
            response = (JSONObject) parser.parse(searchResponseJSON);
        } catch (ParseException pe) {
            System.out.println("Error: could not parse JSON response:");
            System.out.println(searchResponseJSON);
            System.exit(1);
        }

        JSONArray businesses = (JSONArray) response.get("businesses");
        JSONObject firstBusiness = (JSONObject) businesses.get(0);
        String firstBusinessID = firstBusiness.get("id").toString();
        System.out.println(String.format(
                "%s businesses found, querying business info for the top result \"%s\" ...",
                businesses.size(), firstBusinessID));

        // Select the first business and display business details
        String businessResponseJSON = yelpApi.searchByBusinessId(firstBusinessID.toString());
        System.out.println(String.format("Result for business \"%s\" found:", firstBusinessID));
        System.out.println(businessResponseJSON);
    }

    /**
     * mteng modified.
     *
     * @param yelpApi
     * @param location
     */
    public ResponseContainer queryAPIv2(YelpAPI yelpApi, String location, String term) {
        ResponseContainer responseContainer = new ResponseContainer();
        String searchResponseJSON =
                yelpApi.searchForBusinessesByLocation(term, location);

        JSONParser parser = new JSONParser();
        JSONObject response = null;
        try {
            response = (JSONObject) parser.parse(searchResponseJSON);
        } catch (ParseException pe) {
            System.out.println("Error: could not parse JSON response:");
            System.out.println(searchResponseJSON);
            System.exit(1);
        }

        JSONArray businesses = (JSONArray) response.get("businesses");
        JSONObject firstBusiness = (JSONObject) businesses.get(0);
        String firstBusinessID = firstBusiness.get("id").toString();
        System.out.println(String.format(
                "%s businesses found, querying business info for the top result \"%s\" ...",
                businesses.size(), firstBusinessID));

        // Select the first business and display business details
        String businessResponseJSON = yelpApi.searchByBusinessId(firstBusinessID.toString());
        String businessName = firstBusiness.get("name").toString();
        responseContainer.setName(businessName);
        responseContainer.setUrl(firstBusiness.get("url").toString());
        responseContainer.setAddress(firstBusiness.get("location").toString());
        return responseContainer;
    }

    public ResponseContainer queryAPIRandomly(YelpAPI yelpApi, String location, String term) {
        ResponseContainer responseContainer = new ResponseContainer();

        String searchResponseJSON =
                yelpApi.searchForBusinessesByLocation(term, location, 20);

        JSONParser parser = new JSONParser();
        JSONObject response = null;

        try {
            response = (JSONObject) parser.parse(searchResponseJSON);
        } catch (ParseException pe) {
            System.out.println("Error: could not parse JSON response:");
            System.out.println(searchResponseJSON);
            System.exit(1);
        }

        JSONArray businesses = (JSONArray) response.get("businesses");
        /**
         * Select random business in range of 20
         */
        JSONObject firstBusiness = (JSONObject) businesses.get(randInt(0,19));
        String firstBusinessID = firstBusiness.get("id").toString();
        System.out.println(String.format(
                "%s businesses found, querying business info for the top result \"%s\" ...",
                businesses.size(), firstBusinessID));

        String businessResponseJSON = yelpApi.searchByBusinessId(firstBusinessID.toString());
        String businessName = firstBusiness.get("name").toString();
        /**
         * Parse the business JSON to get the location
         */
        JSONObject locationObject = (JSONObject) firstBusiness.get("location");
        JSONArray display_addressArray = (JSONArray) locationObject.get("display_address");
        StringBuilder sb = new StringBuilder();
        for(Object iter : display_addressArray){
            sb.append(iter.toString().replace(" ","+")).append(",");
        }
        /**
         * Parse the business JSON to fetch the intro text
         */
        String text = (String) firstBusiness.get("snippet_text");
        /**
         * Parse the business JSON to fetch the ratings
         */
        Double ratings = (Double) firstBusiness.get("rating");

        /**
         * Set the responseContainer
         */
        responseContainer.setName(businessName);
        responseContainer.setUrl(firstBusiness.get("url").toString());
        responseContainer.setAddress(sb.toString());
        responseContainer.setText(text);
        responseContainer.setRatings(ratings.toString());
        return responseContainer;
    }

    /**
     * Command-line interface for the sample Yelp API runner.
     */
    private static class YelpAPICLI {
        @Parameter(names = {"-q", "--term"}, description = "Search Query Term")
        public String term = DEFAULT_TERM;

        @Parameter(names = {"-l", "--location"}, description = "Location to be Queried")
        public String location = DEFAULT_LOCATION;
    }

    /**
     * Main entry for sample Yelp API requests.
     * <p/>
     * After entering your OAuth credentials, execute <tt><b>run.sh</b></tt> to run this example.
     */
    public static void main(String[] args) {
        YelpAPICLI yelpApiCli = new YelpAPICLI();
        new JCommander(yelpApiCli, args);

        YelpAPI yelpApi = new YelpAPI(CONSUMER_KEY, CONSUMER_SECRET, TOKEN, TOKEN_SECRET);
        queryAPI(yelpApi, yelpApiCli);
    }
}
