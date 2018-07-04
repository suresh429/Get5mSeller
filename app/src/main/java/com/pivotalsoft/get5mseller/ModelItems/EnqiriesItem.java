package com.pivotalsoft.get5mseller.ModelItems;

/**
 * Created by Gangadhar on 9/13/2017.
 */

public class EnqiriesItem {
    private String date,name,discription,time,status;

    public EnqiriesItem(String date, String name, String discription, String time, String status) {
        this.date = date;
        this.name = name;
        this.discription = discription;
        this.time = time;
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
