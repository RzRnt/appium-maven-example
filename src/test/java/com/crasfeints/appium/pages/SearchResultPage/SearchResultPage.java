package com.crasfeints.appium.pages.SearchResultPage;

import com.crasfeints.appium.helper.Config.Config;
import com.crasfeints.appium.helper.Locator.Locator;
import com.crasfeints.appium.helper.Utilities.util;
import com.crasfeints.appium.pages.BaseSteps;
import com.crasfeints.appium.pages.SearchResultPage.Models.ProductsResultDetail;
import com.crasfeints.appium.pages.SearchResultPage.SearchResultPageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class SearchResultPage extends BaseSteps {

    SearchResultPageFactory searchResultPageFactory;
    List<ProductsResultDetail> productsResultDetailList = new ArrayList<>();


    public SearchResultPage(AndroidDriver driver) {
        this.driver = driver;
        this.searchResultPageFactory = new SearchResultPageFactory();
        verifyOnSearchResultPage();
    }


    public void verifyOnSearchResultPage() {
        dismissOnboarding();
    }

    public void tapOnSort() {
        tapOnElement(searchResultPageFactory.SORT_BUTTON);
    }

    public void tapOnSortBy(String sortBy) {
        tapOnElement(searchResultPageFactory.SORT_BY_TEXT.constructLocator(sortBy));

        /* this shouldn't be here, there's a bug sometimes onboarding doesn't show up instead it show up after sorting the results
         * if i were in ebay i would create a ticket to fix this */
        if (isElementVisible(searchResultPageFactory.POPUP_ONBOARDING, Config.SHORT_TIMEOUT)) {
            tapOnElement(searchResultPageFactory.POPUP_ONBOARDING);
        }
    }

    public void dismissOnboarding() {
        if (isElementVisible(searchResultPageFactory.POPUP_ONBOARDING, Config.TIMEOUT)) {
            tapOnElement(searchResultPageFactory.POPUP_ONBOARDING);
        }
    }


    public void getSearchResultProducts(int count) {
        do {
            if (getTotalResult() < count) {
                /* Should be throw an error */
                System.out.println("Total Result is less than desired count");
                break;
            }
            addProductToList();
            SwipeUp();
        } while (count > this.productsResultDetailList.size());
    }

    public void tapOnProductsResult() {
        List<AndroidElement> PRODUCTS = getElements(searchResultPageFactory.PRODUCT_RESULT_CELLS, Config.TIMEOUT);
        PRODUCTS.get(0).click();
    }

    public void tapOnProductsResult(ProductsResultDetail productsResultDetail) {
        Locator productLocator = searchResultPageFactory.PRODUCT_CELL_BY_PRODUCT_NAME.constructLocator(productsResultDetail.getProductName());
        int position = this.productsResultDetailList.indexOf(productsResultDetail);
        if (getCurrentProductPosition() == -1) {
            //means unknown
            //need to handle search to up then down until the product is found
        } else if (position > getCurrentProductPosition()) {
            swipeTo(productLocator, Config.TIMEOUT);
        } else {
            swipeDownTo(productLocator, Config.TIMEOUT);
        }
        tapOnElement(productLocator);
    }

    public int getCurrentProductPosition() {
        String productName = getText(searchResultPageFactory.PRODUCT_TITLE.constructLocator("*"), Config.TIMEOUT);
        if (this.productsResultDetailList
                .stream()
                .filter(details -> details.getProductName().equals(productName))
                .findFirst()
                .isPresent()) {
            return this.productsResultDetailList.indexOf(
                    this.productsResultDetailList.stream()
                        .filter(details -> details.getProductName().equals(productName))
                        .findFirst()
                        .get());
        } else {
            return -1;
        }
    }

    public int getTotalResult() {
        String results = "";
        long _timeout = Instant.now().getEpochSecond() + Long.valueOf(Config.SHORT_TIMEOUT);
        while (Instant.now().getEpochSecond() < _timeout) {
            try {
                results = getText(searchResultPageFactory.PRODUCT_TOTAL_RESULT, Config.TIMEOUT);
                if (!results.equals("")) break;
            } catch (Exception e) {
                util.delay(200);
            }
        }
        return Integer.parseInt(results.split(" ")[0]
                .replace(",", ""));
    }


    public void tapOnProductsResult(int position) {
        List<AndroidElement> PRODUCTS = getElements(searchResultPageFactory.PRODUCT_RESULT_CELLS, Config.TIMEOUT);
        PRODUCTS.get(position).click();
    }

    public String getProductName(int index) {
        return getText(searchResultPageFactory.PRODUCT_TITLE.constructLocator(index), Config.SHORT_TIMEOUT);
    }

    public String getProductPrice(int index) {
        return getText(searchResultPageFactory.PRODUCT_PRICE.constructLocator(index), Config.SHORT_TIMEOUT);
    }

    public String getProductAttribute(int index) {
        return getText(searchResultPageFactory.PRODUCT_ATTRIBUTE.constructLocator(index), Config.SHORT_TIMEOUT);
    }

    public void addProductToList() {
        IntStream.range(1, getDisplayedTotalProducts()+1).forEach(position -> {
            if(isProductFullyDisplayed(position)) {
                if(!isProductAddedAlreadyToList(getProductName(position))) {
                     this.productsResultDetailList.add(new ProductsResultDetail(
                        getProductName(position),
                        getProductPrice(position)
                    ));
                }
            }
        });
    }

    public int getDisplayedTotalProducts() {
        List<AndroidElement> PRODUCTS = getElements(searchResultPageFactory.PRODUCT_RESULT_CELLS, Config.TIMEOUT);
        return PRODUCTS.size();
    }

    public Boolean isProductFullyDisplayed(int index) {
        return isProductTitleDisplayed(index) && isProductPriceDisplayed(index);
    }

    public Boolean isProductTitleDisplayed(int index) {
        return isElementVisible(
            searchResultPageFactory.PRODUCT_TITLE.constructLocator(index),
            Config.SHORT_TIMEOUT
        );
    }

    public Boolean isProductPriceDisplayed(int index) {
        return isElementVisible(
            searchResultPageFactory.PRODUCT_PRICE.constructLocator(index),
            Config.SHORT_TIMEOUT
        );
    }

    public Boolean isProductAddedAlreadyToList(String productName) {
        return this.productsResultDetailList
            .stream().filter(product -> product.getProductName().equals(productName)).findFirst().isPresent();
    }

    public List<ProductsResultDetail> getProductsResultDetailList() {
        return productsResultDetailList;
    }
}
