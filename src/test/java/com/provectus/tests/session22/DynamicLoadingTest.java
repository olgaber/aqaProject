package com.provectus.tests.session22;

import com.codeborne.selenide.Configuration;
import com.provectus.selenidePages.DynamicLoadingPage;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;

public class DynamicLoadingTest {

    @Test
    public void dynamicLoad() throws InterruptedException {

        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.savePageSource = false;

        open("/dynamic_loading");

        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage();
        dynamicLoadingPage.example1LinkClick();
        dynamicLoadingPage.startBtnClick();
        TimeUnit.SECONDS.sleep(5);
        String text = dynamicLoadingPage.loadText();
        Assert.assertEquals(text, "Hello World!");
    }
}
