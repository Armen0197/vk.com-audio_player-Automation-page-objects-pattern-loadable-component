package com.vk_automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.vk_automation.helpers.DriverHelper.getDriver;
import static com.vk_automation.helpers.WaitHelper.waitForElementToBeClickable;
import static com.vk_automation.helpers.WaitHelper.waitForVisibilityOfElement;
import static org.testng.AssertJUnit.assertTrue;

public class UserPage extends BasePage <UserPage>{

    public static final String USER_PAGE_URL = "https://vk.com/feed";

    @FindBy(id = "l_aud")
    private WebElement music_category_id;

    @FindBy(id = "top_profile_link")
    private WebElement page_settings_id;

    @FindBy(id = "top_logout_link")
    private WebElement logout_id;

    public UserPage() {
        super();
    }
    @Override
    protected void load() {
        getDriver().get(USER_PAGE_URL);
    }

    @Override
    protected void isLoaded() throws Error {
        assertTrue("UserPage is not loaded!", getDriver().getCurrentUrl().contains(USER_PAGE_URL));
    }

    public AudioPlayerPage chooseMusicCategory() {
        waitForElementToBeClickable(getDriver(), music_category_id);
        music_category_id.click();
             return new AudioPlayerPage();
    }

    public void logoutAccount() {
        waitForElementToBeClickable(getDriver(), page_settings_id);
        page_settings_id.click();
        waitForVisibilityOfElement(getDriver(), logout_id);
        logout_id.click();
    }
}
