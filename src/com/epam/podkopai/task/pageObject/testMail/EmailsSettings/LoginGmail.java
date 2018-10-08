package com.epam.podkopai.task.pageObject.testMail.EmailsSettings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginGmail {

    public  void  delay(long mills){
        try {
            Thread.sleep(mills);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"identifierId\"]")
    private WebElement loginField;

    @FindBy(xpath = "//div[2]/div/div/div/content/span")
    private WebElement loginButton;

    @FindBy(xpath = "//div/input")
    private WebElement passwordField;

    @FindBy(xpath = "//div/div/content/span")
    private WebElement passwordButton;

    public LoginGmail(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public GmailHome loginGmail(String login, String password){
        loginField.sendKeys(login);
        delay(2000);
        loginButton.click();
        delay(2000);
        passwordField.sendKeys(password);
        passwordButton.click();
        delay(8000);
        return new GmailHome(driver);
    }

}
