package com.pivotalsoft.get5mseller.ModelItems;

/**
 * Created by Gangadhar on 10/12/2017.
 */

public class OfferItme {
    private String offerName;
    private String offercode;
    private String day;
    private String month;


    public OfferItme(String offerName, String offercode, String day, String month) {
        this.offerName = offerName;
        this.offercode = offercode;
        this.day = day;
        this.month = month;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public String getOffercode() {
        return offercode;
    }

    public void setOffercode(String offercode) {
        this.offercode = offercode;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
