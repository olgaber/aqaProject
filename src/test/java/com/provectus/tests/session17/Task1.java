package com.provectus.tests.session17;

/*
https://the-internet.herokuapp.com/challenging_dom - нужно кликнуть на каждую кнопку. после этого нужно выбрать
все значения из 4й колонки и вывести на экран
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Task1 {
    @Test
    public void Test1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/challenging_dom");

        WebElement btn1 = driver.findElement(By.xpath("//div[@id='content']//a[@class='button'][1]"));
        btn1.click();
        WebElement btn2 = driver.findElement(By.xpath("//div[@id='content']//a[@class='button alert']"));
        btn2.click();
        WebElement btn3 = driver.findElement(By.xpath("//div[@id='content']//a[@class='button success']"));
        btn3.click();

        WebElement table = driver.findElement(By.xpath("//table"));
        List<WebElement> rows = table.findElements(By.xpath("//table//tbody/tr"));
        List<String> values = new ArrayList<>();

        for (int i = 0; i < rows.size() ; i++){
            WebElement el = table.findElement(By.xpath("//table//tbody/tr[" + (i + 1) +"]/td[4]"));
            values.add(el.getText());
        }

        System.out.println(values);

    }
}
