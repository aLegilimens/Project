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

public class RemoveItemsFromCart {
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
    public void removeItems() throws InterruptedException{
        home.removeFromCart();
        Thread.sleep(3000);
        /* check if the item is removed from the bag / if the item is removed, the cart will be empty */
        driver.findElement(By.xpath("//a[@data-testid='miniBagIcon']")).click();
        Assert.assertTrue(driver.getPageSource().contains("Your bag is empty"));
    }
    
    @AfterClass
    public void closeDriver() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
