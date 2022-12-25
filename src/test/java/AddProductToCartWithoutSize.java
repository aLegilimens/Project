package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import main.java.pages.Homepage;

public class AddProductToCartWithoutSize {
    static WebDriver driver = new ChromeDriver();

    Homepage home;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        home = new Homepage(driver);
    }

    @Test
    public void testAddingWithoutSize() throws InterruptedException {
        String category = "Shoes";
        Thread.sleep(1000);
        String subcategory = "Sandals";
        home.addWithoutSize(category, subcategory);

        /* After putting the product in the bag, check if an error message shows up*/
        Assert.assertTrue(driver.getPageSource().contains("Please select from the available colour and size options"));
        /*
         Since we are testing with invalid data, an error message should appear prompting the user to change something. 
        */
    }
    
    @AfterClass
    public void closeDriver() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}