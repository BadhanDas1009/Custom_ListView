package com.example.custom_listview;

public class ItemModel {
    private int imageResId;
    private String text;

    public ItemModel(int imageResId, String text) {
        this.imageResId = imageResId;
        this.text = text;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getText() {
        return text;
    }
}
