package com.ricogao.monu.Main.model;

/**
 * Created by ricogao on 2017/4/17.
 */

public class SearchItem {
    private long id;
    private String imgSrc;
    private float distance;
    private int likes;
    private int seats;
    private String name;
    private String keywords;
    private float avgCost;
    private long restaurantId;

    public SearchItem() {
    }

    public long getId() {
        return id;
    }

    public long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public float getAvgCost() {
        return avgCost;
    }

    public void setAvgCost(float avgCost) {
        this.avgCost = avgCost;
    }
}
