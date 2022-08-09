package com.provectus.tests.session17;

/*
https://the-internet.herokuapp.com/login - написать 2 теста, на корректный и некорректный логин.
В первом случае - проверить, что отображается сообщение "You logged into a secure area!",
 во втором сообщение об ошибке логина/пароля
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task2 {
    @Test
    public void login1(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/login");

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");

        WebElement pwd = driver.findElement(By.id("password"));
        pwd.sendKeys("SuperSecretPassword!");

        WebElement submitBtn = driver.findElement(By.xpath("//button[@class='radius']"));
        submitBtn.click();

        String text = driver.findElement(By.xpath("//div[@id='flash']")).getText();

        Assert.assertTrue(text.contains("You logged into a secure area!"));

       driver.quit();
    }

    @Test
    public void login2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/login");

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");

        WebElement pwd = driver.findElement(By.id("password"));
        pwd.sendKeys("SuperSecretPassword!!!");

        WebElement submitBtn = driver.findElement(By.xpath("//button[@class='radius']"));
        submitBtn.click();

        String text = driver.findElement(By.xpath("//div[@id='flash']")).getText();

        Assert.assertTrue(text.contains("Your password is invalid"));

        driver.quit();
    }

}
