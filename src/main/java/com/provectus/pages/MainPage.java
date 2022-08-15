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
}
