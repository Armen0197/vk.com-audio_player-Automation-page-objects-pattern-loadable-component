package com.vk_automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.vk_automation.helpers.DriverHelper.getDriver;
import static com.vk_automation.helpers.WaitHelper.waitForElementToBeClickable;
import static org.testng.AssertJUnit.assertTrue;

public class RecommendedMusicPage extends BasePage <RecommendedMusicPage> {

    public static final String RECOMMENDED_MUSIC_URL = "https://vk.com/audios567348707?section=recoms";

    @FindBy(css = "div[class*=\"_-147845620_456282882 \"]")
    private WebElement music;

    @FindBy(id = "add")
    private WebElement add_music_locator;

    @FindBy(id = "recoms_special_listen_all_btn")
    private WebElement listen_to_all_recommended_button;

    public RecommendedMusicPage() {
        super();
    }

    @Override
    protected void load() {
        getDriver().get(RECOMMENDED_MUSIC_URL);
    }

    @Override
    protected void isLoaded() throws Error {
        assertTrue("RecommendedMusic is not loaded!", getDriver().getCurrentUrl().contains(RECOMMENDED_MUSIC_URL));
    }

    public void clickOnMusic() {
        Actions builder = new Actions(getDriver());
        waitForElementToBeClickable(getDriver(), music);
        Action mouse = builder.moveToElement(music).click().build();
        mouse.perform();
    }

    public void addMusic() {
        waitForElementToBeClickable(getDriver(), add_music_locator);
        add_music_locator.click();
    }

    public void clickAllRecommendedButton() {
        waitForElementToBeClickable(getDriver(), listen_to_all_recommended_button);
        listen_to_all_recommended_button.click();
    }
}
