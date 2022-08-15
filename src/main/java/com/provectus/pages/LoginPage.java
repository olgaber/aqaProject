package com.provectus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id="password")
    private WebElement passwordInput;

    @FindBy(xpath="//button[@class='radius']")
    private WebElement loginBtn;

    @FindBy(css=".flash.error")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPage setUserName(String username){
        //WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.clear();
        usernameInput.sendKeys(username);
        return this;
    }

    public LoginPage setPassword(String password){
       // WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }

    public SecurePage clickLoginButton(){
        //driver.findElement(By.xpath("//button[@class='radius']")).click();
        loginBtn.click();
        return new SecurePage(driver);
    }

    public LoginPage clickLoginInvalidCreds(){
        //driver.findElement(By.xpath("//button[@class='radius']")).click();
        loginBtn.click();
        return new LoginPage(driver);
    }

    public String getErrorText(){
        return errorMessage.getText();
    }
    public SecurePage loginWithValidCreds(String username, String password){
        setUserName(username);
        setPassword(password);
        return clickLoginButton();
    }

    public LoginPage loginWithInvalidCreds(String username, String password){
        setUserName(username);
        setPassword(password);
        return clickLoginInvalidCreds();
    }
}
