package com.provectus.selenidePages;

import com.codeborne.selenide.SelenideElement;

import java.net.URI;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SelenideDownloadPage {

    private final SelenideElement fileLink = $x("//div[@id='content']//a[contains(text(), '.txt')][1]");

    public String getFileName(){
        return fileLink.getText();
    }

}
