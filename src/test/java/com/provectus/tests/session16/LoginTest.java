package com.provectus.tests.session16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;



public class LoginTest {
    @Test(dataProvider = "userProvider", groups = {"groupA"})
    public void loginTest1(String name, String password, String role){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/login");

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys(name);

        WebElement pwd = driver.findElement(By.id("password"));
        pwd.sendKeys(password);

        WebElement submitBtn = driver.findElement(By.xpath("//button[@class=\"radius\"]"));
        submitBtn.click();

        WebElement title1 = driver.findElement(By.xpath("//h2"));
        String text = title1.getText();


        if (name.equals("tomsmith")){
            Assert.assertEquals(text, "Secure Area");
        }
        else {
            Assert.assertEquals(text, "Login Page");
        }

        driver.quit();
    }

    @DataProvider(name = "userProvider")
    public Object[][] userProvider(){
        Object[][] result = {

                {"tomsmith", "SuperSecretPassword!", "role1"},
                {"user2", "pw2", "role2"},
                {"user3", "pw3", "role3"}
        };
        return result;
    }

    @Parameters({"tomsmith", "password"})
    @Test(groups = {"groupB"}, dependsOnGroups = {"groupA"})
    public void loginTest2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/login");
        String title = driver.getTitle();
        Assert.assertEquals(title, ("The Internet"));

        driver.quit();
    }

    @Parameters({ "username1", "password1", "role1" })
    @Test(groups = {"groupA"})
    public void loginTest3(String username1, String password1, String role1){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/login");

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys(username1);

        WebElement pwd = driver.findElement(By.id("password"));
        pwd.sendKeys(password1);

        WebElement submitBtn = driver.findElement(By.xpath("//button[@class=\"radius\"]"));
        submitBtn.click();

        WebElement title1 = driver.findElement(By.xpath("//h2"));
        String text = title1.getText();


        if (username1.equals("tomsmith")){
            Assert.assertEquals(text, "Secure Area");
        }

        driver.quit();
    }



}
