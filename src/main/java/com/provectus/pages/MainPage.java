package com.provectus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver){
        super(driver);
    }

    public LoginPage goToAuthPage(){
        driver.findElement(By.linkText("Form Authentication")).click();
        return new LoginPage(driver);
    }

    public HoverPage goToHoverPage(){
        driver.findElement(By.linkText("Hovers")).click();
        return new HoverPage(driver);
    }

    public ChallengingDomPage goToChallengingDomPage(){
        driver.findElement(By.linkText("Challenging DOM")).click();
        return new ChallengingDomPage(driver);
    }

    public DownloadPage goToDownloadPage(){
        driver.findElement(By.linkText("File Download")).click();
        return new DownloadPage(driver);
    }

    public UploadPage goToUploadPage(){
        driver.findElement(By.linkText("File Upload")).click();
        return new UploadPage(driver);
    }
}
