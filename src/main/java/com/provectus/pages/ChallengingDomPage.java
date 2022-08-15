package com.provectus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;

public class ChallengingDomPage extends BasePage{

    @FindBy(xpath = "//div[@id='content']//a[@class='button'][1]")
    private WebElement btn1;

    @FindBy(xpath = "//div[@id='content']//a[@class='button alert']")
    private WebElement btn2;

    @FindBy(xpath = "//div[@id='content']//a[@class='button success']")
    private WebElement btn3;

    @FindBy(xpath="//tr/td[4]")
    private List<WebElement> cells;

    public ChallengingDomPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickButtons(){
       // WebElement btn1 = driver.findElement(By.xpath("//div[@id='content']//a[@class='button'][1]"));
        btn1.click();
        //WebElement btn2 = driver.findElement(By.xpath("//div[@id='content']//a[@class='button alert']"));
        btn2.click();
        //WebElement btn3 = driver.findElement(By.xpath("//div[@id='content']//a[@class='button success']"));
        btn3.click();
    }

    public List<String> getValues(){
        List<String> values = new ArrayList<>();

      //  List<WebElement> cells = driver.findElements(By.xpath("//tr/td[4]"));

        for (WebElement value : cells) {
            values.add(value.getText());
        }
        return values;
    }

    public void printValues(List<String> values){
        System.out.println(values.toString());
    }
}
