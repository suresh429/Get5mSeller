package com.pivotalsoft.get5mseller.ModelItems;

/**
 * Created by Gangadhar on 9/19/2017.
 */

public class ProductsListItem {

    int image;
    String productName;
    String price;
    String discountPrice;
    String status;

    public ProductsListItem(int image, String productName, String price, String discountPrice, String status) {
        this.image = image;
        this.productName = productName;
        this.price = price;
        this.discountPrice = discountPrice;
        this.status = status;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(String discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
