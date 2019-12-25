package com.crasfeints.appium.helper.Config;

import io.github.cdimascio.dotenv.Dotenv;

public class Config {

    Dotenv dotenv = Dotenv.load();
    public String PLATFORM_NAME;
    public String DEVICE_NAME;
    public String AUTOMATION_NAME;
    public String PLATFORM_VERSION;
    public String NEW_COMMAND_TIMEOUT;
    public String APP_ACTIVITY;
    public String APP_PACKAGE;
    public String SYSTEM_PORT;
    public String APP_WAIT_ACTIVITY;
    public String APPIUM_URL;
    public static int TIMEOUT = Integer.parseInt(Dotenv.load().get("ELEMENT_WAIT_TIMEOUT"));
    public static int SHORT_TIMEOUT = Integer.parseInt(Dotenv.load().get("ELEMENT_WAIT_SHORT_TIMEOUT"));

    public Config() {
        loadConfig();
    }


    public void loadConfig() {
        this.PLATFORM_NAME = dotenv.get("PLATFORM_NAME");
        this.DEVICE_NAME = dotenv.get("DEVICE_NAME");
        this.AUTOMATION_NAME = dotenv.get("AUTOMATION_NAME");
        this.PLATFORM_VERSION = dotenv.get("PLATFORM_VERSION");
        this.NEW_COMMAND_TIMEOUT = dotenv.get("NEW_COMMAND_TIMEOUT");
        this.APP_ACTIVITY = dotenv.get("APP_ACTIVITY");
        this.APP_PACKAGE = dotenv.get("APP_PACKAGE");
        this.SYSTEM_PORT = dotenv.get("SYSTEM_PORT");
        this.APP_WAIT_ACTIVITY = dotenv.get("APP_WAIT_ACTIVITY");
        this.APPIUM_URL = dotenv.get("APPIUM_URL");
    }




}
