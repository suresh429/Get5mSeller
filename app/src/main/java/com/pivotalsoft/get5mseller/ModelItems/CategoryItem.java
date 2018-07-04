package com.pivotalsoft.get5mseller.ModelItems;

/**
 * Created by Gangadhar on 9/16/2017.
 */

public class CategoryItem {

    int image;
    String categoryName;

    public CategoryItem(int image, String categoryName) {
        this.image = image;
        this.categoryName = categoryName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
