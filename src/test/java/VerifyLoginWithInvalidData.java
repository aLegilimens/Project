package test.java;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import main.java.pages.Homepage;

public class VerifyLoginWithInvalidData {
    WebDriver driver;

    Homepage home;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        home = new Homepage(driver);
    }

    @Test
    public void changePassword() throws InterruptedException{
        String email = "doe513960@gmail.com";
        home.invalidLogin(email);
        Thread.sleep(2000);
        /* check if an error message is displayed */
        Assert.assertTrue(driver.getPageSource().contains("Hey, we need a password here"));
        /*
         Since we are testing with invalid data, an error message should appear prompting the user to change something. 
        */
    }

    @AfterClass
    public void closeDriver() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
