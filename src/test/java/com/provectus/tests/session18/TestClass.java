package com.provectus.tests.session18;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass {

    /*
    https://crossbrowsertesting.github.io/drag-and-drop.html - написать тест, который будет перетаскивать элементы и
    проверять результат (Dropped!)
    */

   @Test
    public void Test1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://crossbrowsertesting.github.io/drag-and-drop.html");

        WebElement item = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(item, target).perform();
        Assert.assertEquals(target.getText(), "Dropped!");

        driver.quit();
    }
    /*
    https://crossbrowsertesting.github.io/hover-menu.html - написать тест, который раскрывает dropdown-меню,
    кликает на пункт Secondary Action и проверяет, что текст "Secondary Page" отобразился на странице
    */
    @Test
    public void Test2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://crossbrowsertesting.github.io/hover-menu.html");

        WebElement dropdown = driver.findElement(By.xpath("//ul//li[@class='dropdown']"));
        WebElement expMenu = driver.findElement(By.xpath("//ul//li[@class='secondary-dropdown']/a"));
        WebElement item = driver.findElement(By.xpath("//ul[@class='dropdown-menu secondary']//a"));
        WebElement text = driver.findElement(By.xpath("//div[@class='jumbotron secondary-clicked']/h1"));

        Actions actions = new Actions(driver);

        actions.click(dropdown)
                .moveToElement(expMenu)
                .moveToElement(item)
                .click()
                .perform();

        Assert.assertEquals(text.getText(), "Secondary Page");

        driver.quit();
    }

    /*
    https://the-internet.herokuapp.com/hovers - написать тест, который выводит юзернейм каждого пользователя
    (для этого нужно навести мышку на аватар)
    */

    @Test
    public void Test3() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/hovers");

        WebElement avatar1 = driver.findElement(By.xpath("//div[@class='figure'][1]"));
        WebElement avatar2 = driver.findElement(By.xpath("//div[@class='figure'][2]"));
        WebElement avatar3 = driver.findElement(By.xpath("//div[@class='figure'][3]"));

        WebElement name1 = driver.findElement(By.xpath("//div[@class='figure'][1]//h5"));
        WebElement name2 = driver.findElement(By.xpath("//div[@class='figure'][2]//h5"));
        WebElement name3 = driver.findElement(By.xpath("//div[@class='figure'][3]//h5"));

        Actions actions = new Actions(driver);
        actions.moveToElement(avatar1).moveToElement(name1).perform();
        System.out.println(name1.getText());

        actions.moveToElement(avatar2).moveToElement(name2).perform();
        System.out.println(name2.getText());

        actions.moveToElement(avatar3).moveToElement(name3).perform();
        System.out.println(name3.getText());

        driver.quit();
    }
}