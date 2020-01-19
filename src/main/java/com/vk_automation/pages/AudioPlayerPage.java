package com.vk_automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.vk_automation.helpers.DriverHelper.getDriver;
import static com.vk_automation.helpers.WaitHelper.waitForElementToBeClickable;
import static com.vk_automation.helpers.WaitHelper.waitForVisibilityOfElement;
import static org.testng.AssertJUnit.assertTrue;

public class AudioPlayerPage extends BasePage <AudioPlayerPage> {

    public static final String AUDIO_URL = "https://vk.com/audios567348707";

    @FindBy(css = "button[class $=\"_page_player_play\"]")
    private WebElement player_button;

    @FindBy(css = "button[class $=\"_page_player_next\"]")
    private WebElement next_music_button;

    @FindBy(css = "button[class $=\"_page_player_prev\"]")
    private WebElement previous_music_button;

    @FindBy(id = "audio_search")
    private WebElement search_music;

    @FindBy(css = "div[class$=\"_sections clear_fix\"]")
    private WebElement found_result;

    @FindBy(css = "div[class*=\"audio_page_sections \"]")
    private WebElement nothing_found;

    @FindBy(css = "a[href$=\"recoms\"]")
    private WebElement list_of_recommendations;


    public AudioPlayerPage() {
        super();
    }

    @Override
    protected void load() {
        getDriver().get(AUDIO_URL);
    }

    @Override
    protected void isLoaded() throws Error {
        assertTrue("AudioPlayerPage is not loaded!", getDriver().getCurrentUrl().contains(AUDIO_URL));
    }

    public void clickPlayerButton() {
        waitForElementToBeClickable(getDriver(), player_button);
        player_button.click();
    }

    public void nextMusic() {
        waitForElementToBeClickable(getDriver(), next_music_button);
        next_music_button.click();
    }

    public void previousMusic() {
        waitForElementToBeClickable(getDriver(), previous_music_button);
        previous_music_button.click();
    }

    public void findMusic(String music_name) {
        waitForVisibilityOfElement(getDriver(), search_music);
        search_music.sendKeys(music_name);
    }

    public Boolean foundResult() {
        return found_result.isDisplayed();
    }

    public Boolean nothingFound() {
        return nothing_found.isDisplayed();
    }

    public RecommendedMusicPage goToRecommendationCategory() {
        waitForElementToBeClickable(getDriver(), list_of_recommendations);
        list_of_recommendations.click();
        return new RecommendedMusicPage();
    }

}

