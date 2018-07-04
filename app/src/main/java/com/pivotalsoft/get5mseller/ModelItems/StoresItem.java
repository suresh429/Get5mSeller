package com.pivotalsoft.get5mseller.ModelItems;

/**
 * Created by Gangadhar on 10/25/2017.
 */

public class StoresItem {

    int image;
    String shopName;
    String mobile;
    String email;
    String address;

    public StoresItem(int image, String shopName, String mobile, String email, String address) {
        this.image = image;
        this.shopName = shopName;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
