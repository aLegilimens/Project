package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import main.java.pages.Homepage;

public class AddToSavedItems {
    WebDriver driver;

    Homepage home;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        home = new Homepage(driver);
    }

    @Test
    public void addToSaved(){
        home.saved();
        //check if added to 'Saved items' list
        driver.findElement(By.xpath("//a[@data-testid='savedItemsIcon']")).click();
        Assert.assertFalse(driver.getPageSource().contains("You have no Saved Items"));
    }

    @AfterClass
    public void closeDriver() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
