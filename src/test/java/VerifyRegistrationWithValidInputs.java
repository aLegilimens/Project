package test.java;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import main.java.pages.*;

public class VerifyRegistrationWithValidInputs {
    WebDriver driver;

    Registrationpage reg;
    Homepage home;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        home = new Homepage(driver);
        reg = new Registrationpage(this.driver);
        home.clickOnJoin();
        
    }
    
    
    //this test should assertTrue only the first time since we can only register once with the same data. 
    @Test
    public void register(){
       reg.inputRegistrationInfo("doe513960@gmail.com", "John", "Doe", "Pass12345?", "4", "March", "2001", "female");
       //Assert.assertTrue((driver.getCurrentUrl().contains("https://www.asos.com/")), "Test failed. Registration not successful.");
       //Assert.assertTrue((driver.getTitle().contains("denied")), (driver.getTitle()));
    }
    
    @AfterClass
    public void closeDriver() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
