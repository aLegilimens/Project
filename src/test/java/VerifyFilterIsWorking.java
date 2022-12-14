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

public class VerifyFilterIsWorking {
    WebDriver driver;

    Homepage home;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        home = new Homepage(driver);
    }

    @Test
    public void testFilterFunctionality() throws InterruptedException{
        home.filterResults();
        //check if the resulting products are filtered
        Thread.sleep(2000);
        List<WebElement> results = driver.findElements(By.xpath("//div[@data-auto-id='productTileDescription']"));
        //we loop over the list to verify each result link contains our term
        for (int i = 0; i < results.size(); i++) {
           Assert.assertTrue((results.get(i).getText().contains("t-shirt") || results.get(i).getText().contains("tee") || results.get(i).getText().contains("T-shirt")), ("Search result validation failed at instance" + i));
       }
    }

    @AfterClass
    public void closeDriver() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
