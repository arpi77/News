package com.happypath.news.model;

/**
 * Created by kucserak on 18. 6. 2017.
 */

public class NewsArticle {
    private String title;
    private String details;
    private String time;
    private String imageUrl;
    private String urlToArticle;

    public NewsArticle(String title, String details, String time, String imageUrl, String urlToArticle) {
        this.title = title;
        this.details = details;
        this.time = time;
        this.imageUrl = imageUrl;
        this.urlToArticle = urlToArticle;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUrlToArticle() {
        return urlToArticle;
    }

    public void setUrlToArticle(String urlToArticle) {
        this.urlToArticle = urlToArticle;
    }
}
