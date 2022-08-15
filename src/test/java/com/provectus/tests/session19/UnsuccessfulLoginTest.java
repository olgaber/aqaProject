package com.provectus.tests.session19;

import com.provectus.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UnsuccessfulLoginTest extends BaseTest{

    @Test
    public void unsuccessfulLogin(){

        LoginPage loginPage = openApp().goToAuthPage()
                .loginWithInvalidCreds("tomsmith", "SuperSecurePwd");

        String alertText = loginPage.getErrorText();
        Assert.assertTrue(alertText.contains("Your password is invalid"),
                "User should be logged out");
    }
}
