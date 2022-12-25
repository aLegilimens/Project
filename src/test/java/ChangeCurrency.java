package test.java;

import java.beans.Transient;
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

public class ChangeCurrency {
    static WebDriver driver = new ChromeDriver();

    Homepage home;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        home = new Homepage(driver);
    }

    @Test 
    public void testChangingCurrency() throws InterruptedException{
        home.ChangeCurrency();
        Thread.sleep(2000);
        // check if the currency is updated  
        home.goToProductPage();
        List<WebElement> results = driver.findElements(By.xpath("//span[@class='price_CMH3V']"));
        for (int i = 0; i < results.size(); i++) {
            Assert.assertTrue((results.get(i).getText().contains("€")), ("Search result validation failed at instance" + i));
        }
    }

    @AfterClass
    public void closeDriver() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
