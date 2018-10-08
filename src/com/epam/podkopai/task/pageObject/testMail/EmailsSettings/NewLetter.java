package com.epam.podkopai.task.pageObject.testMail.EmailsSettings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewLetter {

    public  void  delay(long mills){
        try {
            Thread.sleep(mills);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private WebDriver driver;

    @FindBy(name = "to")
    private WebElement sendTo;

    @FindBy(name = "subjectbox")
    private WebElement subj;

    @FindBy(css = "#\\3A a5")
    private WebElement letterContent;

    @FindBy(css = "#\\3A 8q")
    private WebElement sendButton;

    public  NewLetter(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public NewLetter sendNewLetter(String email, String letterSubj, String letterText){
        sendTo.sendKeys(email);
        delay(1000);
        subj.sendKeys(letterSubj);
        delay(1000);
        letterContent.sendKeys(letterText);
        delay(1000);
        sendButton.click();
        delay(2000);
        return new NewLetter(driver);
    }

}
