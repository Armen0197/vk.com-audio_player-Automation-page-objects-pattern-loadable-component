package com.vk_automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import static com.vk_automation.helpers.DriverHelper.getDriver;
import static com.vk_automation.helpers.WaitHelper.waitForElementToBeClickable;
import static org.testng.AssertJUnit.assertTrue;

public class LoginPage extends BasePage <LoginPage> {

    public static final String BASE_URL = "https://vk.com/";

    @FindBy(id = "index_email")
    private WebElement login_id;

    @FindBy(id = "index_pass")
    private WebElement pass_id;

    @FindBy(id = "index_login_button")
    private WebElement login_button;

    public LoginPage() {
        super();
    }
    @Override
    protected void load() {
        getDriver().get(BASE_URL);
    }

    @Override
    protected void isLoaded() throws Error {
        assertTrue("LoginPage is not loaded!", getDriver().getCurrentUrl().contains(BASE_URL));
    }

    public void getLogin(String login) {
        login_id.sendKeys(login);
    }

    public void getPassword(String password) {
        pass_id.sendKeys(password);
    }

    public UserPage clickLoginButton() {
        waitForElementToBeClickable(getDriver(), login_button);
        login_button.click();
        return new UserPage();
    }
}
