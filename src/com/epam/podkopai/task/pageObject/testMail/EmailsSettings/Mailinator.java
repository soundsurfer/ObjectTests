package com.epam.podkopai.task.pageObject.testMail.EmailsSettings;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Mailinator {

    public void delay(long mills){
        try {
            Thread.sleep(mills);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    private WebDriver driver;

    @FindBy(id = "inboxfield")
    private WebElement emailinator;

    @FindBy(css = "button.btn.btn-dark")
    private WebElement emailButton;

    @FindBy(css = ".table")
    private WebElement emailTable;

    @FindBy(css = "#row_testemail1337-1538992762-7082456 > .ng-binding:nth-child(4)")
    private WebElement showText;

    @FindBy(css = "body")
    private WebElement emailiText;

    @FindBy(css = "#msg_body")
    private WebElement msgFrame;

    public Mailinator(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public Mailinator checkMail(String emaili, String subjVerify, String subjText){
        emailinator.sendKeys(emaili);
        emailButton.click();
        delay(2000);
        Assert.assertTrue(emailTable.getText().contains(subjVerify));
        delay(2000);
        showText.click();
        driver.switchTo().frame(msgFrame);
        Assert.assertTrue(emailiText.getText().contains(subjText));
        delay(2000);
        return new Mailinator(driver);
    }


}
