package com.provectus.selenidePages;

/*Написать PageObject и тест для https://the-internet.herokuapp.com/dynamic_loading После клика на кнопку -
дождаться появления текста на странице и его проверить в ассерте в тесте.*/

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DynamicLoadingPage {

    SelenideElement example1 = $(By.partialLinkText("Example 1"));
    SelenideElement example2 = $(By.partialLinkText("Example 2"));

    SelenideElement startBtn = $x("//div[@id='start']/button");
    SelenideElement loadingBar = $("#loading");
    SelenideElement text = $x("//div[@id='finish']/h4");

    public void example1LinkClick(){
        example1.shouldBe(Condition.visible)
                .shouldBe(Condition.interactable)
                .click();
    }

    public void example2LinkClick(){
        example2.shouldBe(Condition.visible)
                .shouldBe(Condition.interactable)
                .click();
    }

    public DynamicLoadingPage startBtnClick(){
        startBtn.shouldBe(Condition.interactable).click();
        return this;
    }

    public String loadText(){
        if (!loadingBar.isDisplayed()) {
           return text.shouldBe(Condition.visible).getText();
        }
        else return "";
    }

}
