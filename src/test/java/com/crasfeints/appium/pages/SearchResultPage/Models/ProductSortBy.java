package com.crasfeints.appium.pages.SearchResultPage.Models;

public enum ProductSortBy {
    BEST_MATCH("Best Match"),
    LOWSET_PRICE_SHIPPING("Lowest Price + Shipping"),
    HIGHEST_PRICE_SHIPPING("Highest Price + Shipping"),
    ENDING_SOONEST("Ending Soonest"),
    NEWLY_LISTED("Newly Listed");


    public final String text;

    ProductSortBy(String text) {
        this.text = text;
    }
}
