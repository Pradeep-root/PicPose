package com.example.pradeep.picpose.model;

/**
 * Created by pradeep on 2/4/17.
 */

public class PoseModel {

    private String imageUrl;
    private String imageTitle;
    private String imageDescription;

    public PoseModel() {
        this.imageUrl = "";
        this.imageTitle = "";
        this.imageDescription = "";
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageTitle() {
        return imageTitle;
    }

    public void setImageTitle(String imageTitle) {
        this.imageTitle = imageTitle;
    }

    public String getImageDescription() {
        return imageDescription;
    }

    public void setImageDescription(String imageDescription) {
        this.imageDescription = imageDescription;
    }

    @Override
    public String toString() {
        return "PoseModel{" +
                "imageUrl='" + imageUrl + '\'' +
                ", imageTitle='" + imageTitle + '\'' +
                ", imageDescription='" + imageDescription + '\'' +
                '}';
    }
}
