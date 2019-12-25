package com.crasfeints.appium.helper.Utilities;

public class util {

    public static void delay(int timeout) {
        try {
            Thread.currentThread().sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
