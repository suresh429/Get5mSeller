package com.pivotalsoft.get5mseller.ModelItems;

/**
 * Created by Gangadhar on 9/16/2017.
 */

public class ProductsItem {
    String productName;

    public ProductsItem(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
