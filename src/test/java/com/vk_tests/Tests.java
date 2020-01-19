package com.vk_tests;

import com.vk_automation.pages.AudioPlayerPage;
import com.vk_automation.pages.LoginPage;
import com.vk_automation.pages.RecommendedMusicPage;
import com.vk_automation.pages.UserPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.vk_automation.helpers.DriverHelper.getDriver;

public class Tests extends BaseTest {

    @Test
    public void firstTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.get();
        loginPage.getLogin("login");
        loginPage.getPassword("password");

        UserPage userPage = loginPage.clickLoginButton();
        userPage.get();

        AudioPlayerPage audioPlayerPage = userPage.chooseMusicCategory();
        audioPlayerPage.get();
        audioPlayerPage.clickPlayerButton();
        audioPlayerPage.nextMusic();
        audioPlayerPage.previousMusic();
        audioPlayerPage.findMusic("hammy");

        Assert.assertTrue(audioPlayerPage.foundResult());

        RecommendedMusicPage recommendedMusic = audioPlayerPage.goToRecommendationCategory();
        recommendedMusic.get();
        recommendedMusic.clickOnMusic();
        recommendedMusic.addMusic();
        audioPlayerPage.goToRecommendationCategory();
        recommendedMusic.clickAllRecommendedButton();
        audioPlayerPage.nextMusic();
        recommendedMusic.addMusic();
        userPage.chooseMusicCategory();
        userPage.logoutAccount();

        Assert.assertEquals(getDriver().getTitle(), "Добро пожаловать | ВКонтакте");
    }
}
