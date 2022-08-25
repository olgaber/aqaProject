package com.provectus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class DownloadPage extends BasePage{

    @FindBy(xpath = "//div[@id='content']//a[contains(text(), '.txt')][1]")
    private WebElement fileLink;

    private String fName;

    public DownloadPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public DownloadPage downloadFile(){
        fileLink.click();
        return this;
    }

    public String getFileName(){
        return fileLink.getText();
    }

}
