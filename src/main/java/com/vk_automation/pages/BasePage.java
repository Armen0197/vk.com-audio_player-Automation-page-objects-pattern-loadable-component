package com.vk_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.vk_automation.helpers.DriverHelper.getDriver;

public class BasePage <T extends LoadableComponent<T>> extends LoadableComponent<T>{

    WebDriver driver;

    public BasePage() {
        this.driver = getDriver();
        PageFactory.initElements(getDriver(), this);
    }

    protected void load() {

    }

    protected void isLoaded() throws Error {

    }
}
