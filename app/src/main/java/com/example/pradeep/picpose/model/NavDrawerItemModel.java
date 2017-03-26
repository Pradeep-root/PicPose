package com.example.pradeep.picpose.model;

/**
 * Created by pradeep on 25/3/17.
 */

public class NavDrawerItemModel {

    private boolean showNotify;
    private String title;
    private int image;
    private boolean isSelected;

    public NavDrawerItemModel() {
        this.showNotify = false;
        this.title = "";
        this.isSelected = false;

    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public boolean isShowNotify() {
        return showNotify;
    }

    public void setShowNotify(boolean showNotify) {
        this.showNotify = showNotify;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
