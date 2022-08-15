package com.provectus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HoverPage extends BasePage {

    @FindBy(xpath = "//div[@class='figure'][1]")
    private WebElement avatar1;

    @FindBy(xpath = "//div[@class='figure'][1]//h5")
    private WebElement name1;

    @FindBy(xpath = "//div[@class='figure'][2]")
    private WebElement avatar2;

    @FindBy(xpath = "//div[@class='figure'][2]//h5")
    private WebElement name2;

    @FindBy(xpath = "//div[@class='figure'][3]")
    private WebElement avatar3;

    @FindBy(xpath = "//div[@class='figure'][3]//h5")
    private WebElement name3;

    public HoverPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getAvatar1Name(){
        // WebElement avatar1 = driver.findElement(By.xpath("//div[@class='figure'][1]"));
        // WebElement name1 = driver.findElement(By.xpath("//div[@class='figure'][1]//h5"));
        actions.moveToElement(avatar1).moveToElement(name1).perform();
        return name1.getText();
    }

    public String getAvatar2Name(){
        // WebElement avatar2 = driver.findElement(By.xpath("//div[@class='figure'][2]"));
        // WebElement name2 = driver.findElement(By.xpath("//div[@class='figure'][2]//h5"));
        actions.moveToElement(avatar2).moveToElement(name2).perform();
        return name2.getText();
    }

    public String getAvatar3Name(){
        // WebElement avatar3 = driver.findElement(By.xpath("//div[@class='figure'][3]"));
        // WebElement name3 = driver.findElement(By.xpath("//div[@class='figure'][3]//h5"));
        actions.moveToElement(avatar3).moveToElement(name3).perform();
        return name3.getText();
    }

    public void printNames(){
        System.out.println(getAvatar1Name());
        System.out.println(getAvatar2Name());
        System.out.println(getAvatar3Name());
    }

}
