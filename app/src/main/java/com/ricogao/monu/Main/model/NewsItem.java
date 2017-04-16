package com.ricogao.monu.Main.model;

/**
 * Created by ricogao on 2017/4/16.
 */

public class NewsItem {

    private String imgSrc;
    private String title;
    private String subTitle;
    private long id;

    public NewsItem() {
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
