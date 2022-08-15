package com.provectus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecurePage extends BasePage{
    @FindBy(css="a.button")
    private WebElement logoutBtn;

    @FindBy(css=".flash.success")
    private WebElement alertMessage;
    public SecurePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPage logout(){
        //driver.findElement(By.cssSelector("a.button")).click();
        logoutBtn.click();
        return new LoginPage(driver);
    }

    public String getAlertText(){
        //return driver.findElement(By.cssSelector(".flash.success")).getText();
        return alertMessage.getText();
    }
}
