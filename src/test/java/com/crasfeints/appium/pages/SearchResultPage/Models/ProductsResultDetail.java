package com.crasfeints.appium.pages.SearchResultPage.Models;

public class ProductsResultDetail {

    String productName;
    String productPrice;

    public ProductsResultDetail(
            String productName,
            String productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return this.productName;
    }

    public String getProductPrice() {
        return this.productPrice;
    }
}
