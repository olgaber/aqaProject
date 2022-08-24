package com.provectus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class UploadPage extends BasePage {

    @FindBy(css = "input#file-upload")
    private WebElement chooseButton;

    @FindBy(css="#file-submit")
    private WebElement uploadButton;

    @FindBy(css = "h3")
    private WebElement feedback;

    public UploadPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectFile(String fileName){
        chooseButton.sendKeys(new File("target/downloads/" + fileName).getAbsolutePath());
    }

    public void uploadFile(){
        uploadButton.click();
    }

    public String getFeedback(){
        return feedback.getText();
    }

}
