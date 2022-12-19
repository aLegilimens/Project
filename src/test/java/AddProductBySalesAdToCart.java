package test.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;


import main.java.pages.*;

public class AddProductBySalesAdToCart {
    static WebDriver driver = new ChromeDriver();

    Homepage home;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        home = new Homepage(driver);
    }

    @Test
    public void testSalesAdCategory() throws InterruptedException{
        String size = "EU 40";
        home.chooseProductSales(size);
        /*After putting the product in the bag, check if an error message shows up
        If yes, the action did not succeed. */
        Thread.sleep(1000);
        Assert.assertFalse((driver.getPageSource().contains("Sorry")));
        /*
         Since the product will not get added to the cart (driver problem), the test will not pass. 
         */
   }  
    
    
    @AfterClass
    public void closeDriver() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
