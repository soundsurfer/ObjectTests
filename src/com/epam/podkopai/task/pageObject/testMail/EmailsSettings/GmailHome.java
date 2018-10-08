package com.epam.podkopai.task.pageObject.testMail.EmailsSettings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailHome {

    private WebDriver driver;

    @FindBy (css = ".T-I-KE")
    private WebElement createMessage;

//    @FindBy (xpath = "sss")
//    private WebElement inboxMessage;

    public GmailHome(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public NewLetter goToCreateNewLetter(){
        createMessage.click();
        return new NewLetter(driver);
    }

}
