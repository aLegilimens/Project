package test.java;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import main.java.pages.*;

public class UpdateSizeFromTheCart {
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
    public void updateSizeItems() throws InterruptedException{
        home.updateSize();
        Thread.sleep(3000);
        /* check if the size is updated from the bag */
        String size = driver.findElement(By.xpath("//span[contains(@class,'select2 select2-container select2-container--default')]")).getText();
        Assert.assertTrue(size.equals("S"));
    }
    
    @AfterClass
    public void closeDriver() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
