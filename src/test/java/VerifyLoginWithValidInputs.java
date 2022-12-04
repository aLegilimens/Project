package test.java;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import main.java.pages.*;

public class VerifyLoginWithValidInputs {
    WebDriver driver;

    Registrationpage reg;
    Homepage home;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver","C:/Users/Nurdzihana/Documents/Selenium/chromedriver_win32/chromedriver.exe");
        home = new Homepage(driver);
        reg = new Registrationpage(this.driver);
    }
    
    
    @Test
    public void login() throws InterruptedException{
        home.clickOnLogin();
        reg.inputLogin("doe513960@gmail.com", "Pass12345?");
    }
    
    @AfterClass
    public void closeDriver() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
