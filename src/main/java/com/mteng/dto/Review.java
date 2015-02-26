
package com.mteng.dto;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "rating",
    "excerpt",
    "time_created",
    "rating_image_url",
    "rating_image_small_url",
    "user",
    "rating_image_large_url",
    "id"
})
public class Review {

    @JsonProperty("rating")
    private Integer rating;
    @JsonProperty("excerpt")
    private String excerpt;
    @JsonProperty("time_created")
    private Integer timeCreated;
    @JsonProperty("rating_image_url")
    private String ratingImageUrl;
    @JsonProperty("rating_image_small_url")
    private String ratingImageSmallUrl;
    @JsonProperty("user")
    private User user;
    @JsonProperty("rating_image_large_url")
    private String ratingImageLargeUrl;
    @JsonProperty("id")
    private String id;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The rating
     */
    @JsonProperty("rating")
    public Integer getRating() {
        return rating;
    }

    /**
     * 
     * @param rating
     *     The rating
     */
    @JsonProperty("rating")
    public void setRating(Integer rating) {
        this.rating = rating;
    }

    /**
     * 
     * @return
     *     The excerpt
     */
    @JsonProperty("excerpt")
    public String getExcerpt() {
        return excerpt;
    }

    /**
     * 
     * @param excerpt
     *     The excerpt
     */
    @JsonProperty("excerpt")
    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    /**
     * 
     * @return
     *     The timeCreated
     */
    @JsonProperty("time_created")
    public Integer getTimeCreated() {
        return timeCreated;
    }

    /**
     * 
     * @param timeCreated
     *     The time_created
     */
    @JsonProperty("time_created")
    public void setTimeCreated(Integer timeCreated) {
        this.timeCreated = timeCreated;
    }

    /**
     * 
     * @return
     *     The ratingImageUrl
     */
    @JsonProperty("rating_image_url")
    public String getRatingImageUrl() {
        return ratingImageUrl;
    }

    /**
     * 
     * @param ratingImageUrl
     *     The rating_image_url
     */
    @JsonProperty("rating_image_url")
    public void setRatingImageUrl(String ratingImageUrl) {
        this.ratingImageUrl = ratingImageUrl;
    }

    /**
     * 
     * @return
     *     The ratingImageSmallUrl
     */
    @JsonProperty("rating_image_small_url")
    public String getRatingImageSmallUrl() {
        return ratingImageSmallUrl;
    }

    /**
     * 
     * @param ratingImageSmallUrl
     *     The rating_image_small_url
     */
    @JsonProperty("rating_image_small_url")
    public void setRatingImageSmallUrl(String ratingImageSmallUrl) {
        this.ratingImageSmallUrl = ratingImageSmallUrl;
    }

    /**
     * 
     * @return
     *     The user
     */
    @JsonProperty("user")
    public User getUser() {
        return user;
    }

    /**
     * 
     * @param user
     *     The user
     */
    @JsonProperty("user")
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * 
     * @return
     *     The ratingImageLargeUrl
     */
    @JsonProperty("rating_image_large_url")
    public String getRatingImageLargeUrl() {
        return ratingImageLargeUrl;
    }

    /**
     * 
     * @param ratingImageLargeUrl
     *     The rating_image_large_url
     */
    @JsonProperty("rating_image_large_url")
    public void setRatingImageLargeUrl(String ratingImageLargeUrl) {
        this.ratingImageLargeUrl = ratingImageLargeUrl;
    }

    /**
     * 
     * @return
     *     The id
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
