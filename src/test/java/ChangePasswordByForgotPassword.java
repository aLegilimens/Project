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

public class ChangePasswordByForgotPassword {
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
        home.forgotPass(email);
        Thread.sleep(2000);
        //check if reset link is sent
        Assert.assertTrue(driver.getPageSource().contains("We've sent you an email to reset your password"));
        
    }

    @AfterClass
    public void closeDriver() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
