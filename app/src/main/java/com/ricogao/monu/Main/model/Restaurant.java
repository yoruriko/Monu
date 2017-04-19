package com.ricogao.monu.Main.model;

/**
 * Created by ricogao on 2017/4/18.
 */

public class Restaurant {
    long id;
    int likes;
    boolean isLiked;
    String imgSrc;
    String name;
    String info;
    String address;
    String phone1;
    String phone2;
    String workHour1;
    String workHour2;
    String distance;
    int seatsState;

    public Restaurant() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getWorkHour1() {
        return workHour1;
    }

    public void setWorkHour1(String workHour1) {
        this.workHour1 = workHour1;
    }

    public String getWorkHour2() {
        return workHour2;
    }

    public void setWorkHour2(String workHour2) {
        this.workHour2 = workHour2;
    }

    public int getSeatsState() {
        return seatsState;
    }

    public void setSeatsState(int seatsState) {
        this.seatsState = seatsState;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
}
