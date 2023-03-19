package com.example.demoprojecttast1.models;

import android.net.Uri;

public class ApiModel {
    private long albumID;
    private float id;
    private String title;
    private String url;
    private String thumbnailURL;

    // Getter Methods
    public float getId() {

        return id;
    }

    public void setId(float id) {

        this.id = id;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {

        this.url = url;
    }

    public long getAlbumID() {
        return albumID;
    }

    public void setAlbumID(long albumID) {
        this.albumID = albumID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }
}
