package com.crasfeints.appium.tests.GuestUserTests.WatchProduct;


import com.crasfeints.appium.BaseDriver;
import com.crasfeints.appium.pages.HomePage.HomePage;
import com.crasfeints.appium.pages.ProductDetailPage.ProductDetailPage;
import com.crasfeints.appium.pages.SearchPage.SearchPage;
import com.crasfeints.appium.pages.SearchResultPage.Models.ProductSortBy;
import com.crasfeints.appium.pages.SearchResultPage.Models.ProductsResultDetail;
import com.crasfeints.appium.pages.SearchResultPage.SearchResultPage;
import com.crasfeints.appium.pages.SignInPage.SignInPage;
import com.crasfeints.appium.tests.GuestUserTests.WatchProduct.LoginFromWatchProductTestData;

import io.appium.java_client.android.AndroidDriver;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;

import java.util.List;



public class LoginFromWatchProductTests {


    @Test
    @Tag("guest-001")
    public void UserGoBackFromSignInPage() {
        BaseDriver baseDriver = new BaseDriver();
        AndroidDriver androidDriver = baseDriver.SetUpDriver();

        HomePage home = new HomePage(androidDriver);
        home.tapOnSearchBox();

        SearchPage search = new SearchPage(androidDriver);
        search.inputSearchBox(LoginFromWatchProductTestData.products);
        search.tapOnSuggestionResult();

        SearchResultPage searchResult = new SearchResultPage(androidDriver);
        searchResult.tapOnSort();
        searchResult.tapOnSortBy(ProductSortBy.LOWSET_PRICE_SHIPPING.text);
        searchResult.getSearchResultProducts(5);
        List<ProductsResultDetail> productsResultDetailList = searchResult.getProductsResultDetailList();
        searchResult.tapOnProductsResult(productsResultDetailList.get(0));

        ProductDetailPage productDetail = new ProductDetailPage(
                androidDriver,
                productsResultDetailList.get(0).getProductName(),
                productsResultDetailList.get(0).getProductPrice()
        );
        productDetail.tapOnWatchProduct();

        SignInPage signIn = new SignInPage(androidDriver);

        /*
        Can't Inspect Login Page, tried to check if it's a webview, turns out not
        signIn.tapOnUseEmailOrUsername();
        signIn.inputEmailOrUsername(username);
        signIn.closeSignInPage();
        */

        signIn.closeSignInPage();
        productDetail.verifyOnProductDetailPage();

        baseDriver.TearDown(androidDriver);
    }
}
