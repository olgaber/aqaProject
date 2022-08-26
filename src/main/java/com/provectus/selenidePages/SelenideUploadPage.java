package com.provectus.selenidePages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.io.File;
import java.nio.file.Path;
import static com.codeborne.selenide.Selenide.$;

public class SelenideUploadPage {

    private final SelenideElement chooseButton = $("input#file-upload");
    private final SelenideElement uploadButton = $("input#file-submit.button");
    private final SelenideElement feedback = $("h3");

    public void selectFile(String path){
        chooseButton.uploadFile(new File(path));
    }

    public void uploadFile(){
        System.out.println("Exist = " + uploadButton.exists());
        System.out.println("Is Displayed = " + uploadButton.isDisplayed());
        uploadButton.should(Condition.exist)
                .shouldBe(Condition.interactable)
                .click();
    }

    public String getFeedback(){
        return feedback.getText();
    }

}
