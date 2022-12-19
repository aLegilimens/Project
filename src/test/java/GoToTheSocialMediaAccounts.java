package test.java;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import main.java.pages.*;

public class GoToTheSocialMediaAccounts {
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
    public void goToSocialMedia() throws InterruptedException{
        home.clickOnSocialMedia();
        /* verify that a new tab is opened with the Instagram page loaded. */
        /* get window handlers as list */
	    List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
	    //switch to new tab
	    driver.switchTo().window(browserTabs .get(1));
	    /* check is it correct page opened or not (check page's title) */
        Assert.assertTrue(driver.getCurrentUrl().contentEquals("https://www.instagram.com/asos/"));
    }
    
    @AfterClass
    public void closeDriver() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
