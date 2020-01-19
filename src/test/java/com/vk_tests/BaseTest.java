package com.vk_tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static com.vk_automation.helpers.DriverHelper.getDriver;

public class BaseTest {

    public static void scrollPage() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,200)");
    }

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        getDriver().manage().window().maximize();

    }

    @AfterMethod
    public static void closeDriver() {
        getDriver().close();
    }

    @AfterClass
    public static void turnDown() {
        getDriver().quit();
    }
}