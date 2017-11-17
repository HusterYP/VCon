package com.example.yuanping.weconnected.login.bean;

import android.graphics.Bitmap;

/**
 * Created by yuanping on 11/1/17.
 */

public class FriendsListBean {
    private Bitmap bitmap;
    private String name;
    private String description;

    public FriendsListBean(Bitmap bitmap, String name, String description) {
        this.bitmap = bitmap;
        this.name = name;
        this.description = description;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setBitmap(Bitmap bitmap) {

        this.bitmap = bitmap;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
