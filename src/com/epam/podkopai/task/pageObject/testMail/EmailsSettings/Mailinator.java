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
    //testemail1337@mailinator.com

    @FindBy(id = "inboxfield")
    private WebElement emailinator;

    @FindBy(css = "button.btn.btn-dark")
    private WebElement emailButton;

    @FindBy(css = ".table")
    private WebElement emailTable;

    @FindBy(xpath = "(//td[@onclick=\"showTheMessage('testemail1337-1538925857-5677859');\"])[3]")
    private WebElement showText;

    @FindBy(css = "#msgpane > div:nth-child(1) > div:nth-child(1) > div:nth-child(2)")
    private WebElement emailiText;

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
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        Assert.assertTrue(emailiText.getText().contains(subjText));
        delay(2000);
        return new Mailinator(driver);
    }


}
