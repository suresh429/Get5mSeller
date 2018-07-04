package com.pivotalsoft.get5mseller.ModelItems;

/**
 * Created by Gangadhar on 9/13/2017.
 */

public class ReviewsItem {

    private String name,time,rating,description;

    public ReviewsItem(String name, String time, String rating, String description) {
        this.name = name;
        this.time = time;
        this.rating = rating;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
