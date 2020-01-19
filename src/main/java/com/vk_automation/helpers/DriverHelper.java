package com.vk_automation.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverHelper {

    public static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null){
            driver = new ChromeDriver();
        }
        return driver;
    }
}
