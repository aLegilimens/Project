package test.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;


import main.java.pages.*;

public class AddProductByMenCategoryToCart {
    static WebDriver driver = new ChromeDriver();

    Homepage home;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        home = new Homepage(driver);
    }

    @Test
    public void testMenCategory(){
        String category = "Shoes";
        String subcategory = "Sandals";
        String size = "EU 40";
        home.chooseSubcategory(category, subcategory, size);
        Assert.assertTrue((driver.getPageSource().contains("Sorry")));
   }  
    
    
    @AfterClass
    public void closeDriver() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
