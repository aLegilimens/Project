package test.java;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;


import main.java.pages.*;

public class AddProductBySearchbarToCart {
    static WebDriver driver = new ChromeDriver();

    Homepage home;
    @BeforeClass
    public void setup(){
        home = new Homepage(driver);
    }

    @Test
    public void testSearchBar(){
        String input = "t-shirt";
        home.enterInput(input);
        // search results
        List<WebElement> results = driver.findElements(By.xpath("//div[@data-auto-id='productTileDescription']"));
        // Finally, we'll loop over the list to verify each result link contains our term
        for (int i = 0; i < results.size(); i++) {
           Assert.assertTrue((results.get(i).getText().contains(input) || results.get(i).getText().contains("tee")), ("Search result validation failed at instance" + i));
       }
    }
    
    @AfterClass
    public void closeDriver() throws InterruptedException {
        Thread.sleep(500);
        driver.quit();
    }
}
