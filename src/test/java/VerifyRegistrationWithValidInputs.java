package test.java;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import main.java.pages.*;

public class VerifyRegistrationWithValidInputs {
    WebDriver driver;

    Registrationpage reg;
    Homepage home;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        home = new Homepage(driver);
        reg = new Registrationpage(this.driver);
    }
    
    
    //this test should assertTrue only the first time since we can only register once with the same data. 
    @Test
    public void register(){
       home.clickOnJoin();
       reg.inputRegistrationInfo("doe513960@gmail.com", "John", "Doe", "Pass12345?", "4", "March", "2001", "female");
       Assert.assertTrue((driver.getCurrentUrl().contains("https://www.asos.com/")), "Test failed. Registration not successful.");
    }
    @Test
    public void login() throws InterruptedException{
        home.clickOnLogin();
        reg.inputLogin("doe513960@gmail.com", "Pass12345?");
        //check if logged in, check if on the 'User' icon we have our name 
	    Assert.assertTrue((driver.getPageSource()).contains("Hi John"));
    }
    
    @AfterClass
    public void closeDriver() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
