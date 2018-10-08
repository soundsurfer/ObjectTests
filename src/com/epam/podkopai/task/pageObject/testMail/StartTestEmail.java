package com.epam.podkopai.task.pageObject.testMail;

import com.epam.podkopai.task.pageObject.testMail.EmailsSettings.GmailHome;
import com.epam.podkopai.task.pageObject.testMail.EmailsSettings.LoginGmail;
import com.epam.podkopai.task.pageObject.testMail.EmailsSettings.Mailinator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class StartTestEmail {

    WebDriver driver;
    String gmail = "https://accounts.google.com/ServiceLogin/identifier?service=mail" +
            "&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=" +
            "default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=AddSession";
    String mailinator  = "https://www.mailinator.com/";
    String testemail = "testemail1337@mailinator.com";
    String login = "eaccun353";
    String password = "hidriver12345";
    String email = "testemail1337@mailinator.com";
    String subj = "Test subj";
    String letter = "Test text!";

    @Before
    public void setUpTest(){
        File file = new File(".\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
    }

    GmailHome gmailHome;

    @Test
    public void loginTest(){
        driver.get(gmail);
        new LoginGmail(driver)
                .loginGmail(login, password)
                .goToCreateNewLetter()
                .sendNewLetter(email, subj, letter);
        driver.close();

    }
    @Test
    public void verifyEmail(){
        driver.get(mailinator);
        new Mailinator(driver)
                .checkMail(testemail, subj, letter);
        driver.close();
    }
}
