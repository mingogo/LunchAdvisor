
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
import com.mteng.dto.Location;
import com.mteng.dto.Review;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "is_claimed",
    "rating",
    "mobile_url",
    "rating_img_url",
    "review_count",
    "name",
    "snippet_image_url",
    "rating_img_url_small",
    "url",
    "menu_date_updated",
    "reviews",
    "phone",
    "snippet_text",
    "image_url",
    "categories",
    "display_phone",
    "rating_img_url_large",
    "menu_provider",
    "id",
    "is_closed",
    "location"
})
public class Yelp {

    @JsonProperty("is_claimed")
    private Boolean isClaimed;
    @JsonProperty("rating")
    private Integer rating;
    @JsonProperty("mobile_url")
    private String mobileUrl;
    @JsonProperty("rating_img_url")
    private String ratingImgUrl;
    @JsonProperty("review_count")
    private Integer reviewCount;
    @JsonProperty("name")
    private String name;
    @JsonProperty("snippet_image_url")
    private String snippetImageUrl;
    @JsonProperty("rating_img_url_small")
    private String ratingImgUrlSmall;
    @JsonProperty("url")
    private String url;
    @JsonProperty("menu_date_updated")
    private Integer menuDateUpdated;
    @JsonProperty("reviews")
    private List<Review> reviews = new ArrayList<Review>();
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("snippet_text")
    private String snippetText;
    @JsonProperty("image_url")
    private String imageUrl;
    @JsonProperty("categories")
    private List<List<String>> categories = new ArrayList<List<String>>();
    @JsonProperty("display_phone")
    private String displayPhone;
    @JsonProperty("rating_img_url_large")
    private String ratingImgUrlLarge;
    @JsonProperty("menu_provider")
    private String menuProvider;
    @JsonProperty("id")
    private String id;
    @JsonProperty("is_closed")
    private Boolean isClosed;
    @JsonProperty("location")
    private Location location;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The isClaimed
     */
    @JsonProperty("is_claimed")
    public Boolean getIsClaimed() {
        return isClaimed;
    }

    /**
     * 
     * @param isClaimed
     *     The is_claimed
     */
    @JsonProperty("is_claimed")
    public void setIsClaimed(Boolean isClaimed) {
        this.isClaimed = isClaimed;
    }

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
     *     The mobileUrl
     */
    @JsonProperty("mobile_url")
    public String getMobileUrl() {
        return mobileUrl;
    }

    /**
     * 
     * @param mobileUrl
     *     The mobile_url
     */
    @JsonProperty("mobile_url")
    public void setMobileUrl(String mobileUrl) {
        this.mobileUrl = mobileUrl;
    }

    /**
     * 
     * @return
     *     The ratingImgUrl
     */
    @JsonProperty("rating_img_url")
    public String getRatingImgUrl() {
        return ratingImgUrl;
    }

    /**
     * 
     * @param ratingImgUrl
     *     The rating_img_url
     */
    @JsonProperty("rating_img_url")
    public void setRatingImgUrl(String ratingImgUrl) {
        this.ratingImgUrl = ratingImgUrl;
    }

    /**
     * 
     * @return
     *     The reviewCount
     */
    @JsonProperty("review_count")
    public Integer getReviewCount() {
        return reviewCount;
    }

    /**
     * 
     * @param reviewCount
     *     The review_count
     */
    @JsonProperty("review_count")
    public void setReviewCount(Integer reviewCount) {
        this.reviewCount = reviewCount;
    }

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
     *     The snippetImageUrl
     */
    @JsonProperty("snippet_image_url")
    public String getSnippetImageUrl() {
        return snippetImageUrl;
    }

    /**
     * 
     * @param snippetImageUrl
     *     The snippet_image_url
     */
    @JsonProperty("snippet_image_url")
    public void setSnippetImageUrl(String snippetImageUrl) {
        this.snippetImageUrl = snippetImageUrl;
    }

    /**
     * 
     * @return
     *     The ratingImgUrlSmall
     */
    @JsonProperty("rating_img_url_small")
    public String getRatingImgUrlSmall() {
        return ratingImgUrlSmall;
    }

    /**
     * 
     * @param ratingImgUrlSmall
     *     The rating_img_url_small
     */
    @JsonProperty("rating_img_url_small")
    public void setRatingImgUrlSmall(String ratingImgUrlSmall) {
        this.ratingImgUrlSmall = ratingImgUrlSmall;
    }

    /**
     * 
     * @return
     *     The url
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 
     * @return
     *     The menuDateUpdated
     */
    @JsonProperty("menu_date_updated")
    public Integer getMenuDateUpdated() {
        return menuDateUpdated;
    }

    /**
     * 
     * @param menuDateUpdated
     *     The menu_date_updated
     */
    @JsonProperty("menu_date_updated")
    public void setMenuDateUpdated(Integer menuDateUpdated) {
        this.menuDateUpdated = menuDateUpdated;
    }

    /**
     * 
     * @return
     *     The reviews
     */
    @JsonProperty("reviews")
    public List<Review> getReviews() {
        return reviews;
    }

    /**
     * 
     * @param reviews
     *     The reviews
     */
    @JsonProperty("reviews")
    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    /**
     * 
     * @return
     *     The phone
     */
    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    /**
     * 
     * @param phone
     *     The phone
     */
    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 
     * @return
     *     The snippetText
     */
    @JsonProperty("snippet_text")
    public String getSnippetText() {
        return snippetText;
    }

    /**
     * 
     * @param snippetText
     *     The snippet_text
     */
    @JsonProperty("snippet_text")
    public void setSnippetText(String snippetText) {
        this.snippetText = snippetText;
    }

    /**
     * 
     * @return
     *     The imageUrl
     */
    @JsonProperty("image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * 
     * @param imageUrl
     *     The image_url
     */
    @JsonProperty("image_url")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * 
     * @return
     *     The categories
     */
    @JsonProperty("categories")
    public List<List<String>> getCategories() {
        return categories;
    }

    /**
     * 
     * @param categories
     *     The categories
     */
    @JsonProperty("categories")
    public void setCategories(List<List<String>> categories) {
        this.categories = categories;
    }

    /**
     * 
     * @return
     *     The displayPhone
     */
    @JsonProperty("display_phone")
    public String getDisplayPhone() {
        return displayPhone;
    }

    /**
     * 
     * @param displayPhone
     *     The display_phone
     */
    @JsonProperty("display_phone")
    public void setDisplayPhone(String displayPhone) {
        this.displayPhone = displayPhone;
    }

    /**
     * 
     * @return
     *     The ratingImgUrlLarge
     */
    @JsonProperty("rating_img_url_large")
    public String getRatingImgUrlLarge() {
        return ratingImgUrlLarge;
    }

    /**
     * 
     * @param ratingImgUrlLarge
     *     The rating_img_url_large
     */
    @JsonProperty("rating_img_url_large")
    public void setRatingImgUrlLarge(String ratingImgUrlLarge) {
        this.ratingImgUrlLarge = ratingImgUrlLarge;
    }

    /**
     * 
     * @return
     *     The menuProvider
     */
    @JsonProperty("menu_provider")
    public String getMenuProvider() {
        return menuProvider;
    }

    /**
     * 
     * @param menuProvider
     *     The menu_provider
     */
    @JsonProperty("menu_provider")
    public void setMenuProvider(String menuProvider) {
        this.menuProvider = menuProvider;
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

    /**
     * 
     * @return
     *     The isClosed
     */
    @JsonProperty("is_closed")
    public Boolean getIsClosed() {
        return isClosed;
    }

    /**
     * 
     * @param isClosed
     *     The is_closed
     */
    @JsonProperty("is_closed")
    public void setIsClosed(Boolean isClosed) {
        this.isClosed = isClosed;
    }

    /**
     * 
     * @return
     *     The location
     */
    @JsonProperty("location")
    public Location getLocation() {
        return location;
    }

    /**
     * 
     * @param location
     *     The location
     */
    @JsonProperty("location")
    public void setLocation(Location location) {
        this.location = location;
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
