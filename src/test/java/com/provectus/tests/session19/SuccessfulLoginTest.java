package com.provectus.tests.session19;

import com.provectus.pages.SecurePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SuccessfulLoginTest extends BaseTest{
    @Test
    public void successfulLogin(){

        /*
        mainPage.goToAuthPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("tomsmith", "SuperSecretPassword!");

        SecurePage securePage = new SecurePage(driver);
        String alertText = securePage.getAlertText();
        */
        SecurePage securePage = openApp().goToAuthPage()
                .loginWithValidCreds("tomsmith", "SuperSecretPassword!");
        String alertText = securePage.getAlertText();

        Assert.assertTrue(alertText.contains("You logged into a secure area!"),
                "User should be logged in");

        securePage.logout();
    }
}
