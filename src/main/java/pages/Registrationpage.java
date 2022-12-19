package main.java.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;



public class Registrationpage {

    private WebDriver driver;
  
    /* CONSTRUCTOR */
    public Registrationpage(WebDriver driver){
    this.driver=driver;
    }

   /* elements */
   public static By emailLogin = By.id("EmailAddress");
   public static By passLogin = By.id("Password");

   public static By email = By.id("Email");
   public static By firstName = By.id("FirstName");
   public static By lastName = By.id("LastName");
   public static By password = By.id("Password");
   By dateOfBirthDay = By.id("BirthDay");
   By dateOfBirthMonth = By.id("BirthMonth");
   By dateOfBirthYear = By.id("BirthYear");
   public static By interestedIn = By.id("female");
   public static By registerBtn = By.id("register");

   /* registration information input */
   public void inputRegistrationInfo(String mail, String fName, String lName, String pass, String bDay, String bMonth, String bYear, String interested){
    driver.findElement(email).sendKeys(mail);
    driver.findElement(firstName).sendKeys(fName);
    driver.findElement(lastName).sendKeys(lName);
    driver.findElement(password).sendKeys(pass);
    driver.findElement(dateOfBirthDay).sendKeys(bDay);
    driver.findElement(dateOfBirthMonth).sendKeys(bMonth);
    driver.findElement(dateOfBirthYear).sendKeys(bYear);
    driver.findElement(registerBtn).click();
   }

   /* login information input */
   public void inputLogin(String em, String pas) throws InterruptedException{
    Thread.sleep(2000);
    driver.findElement(emailLogin).sendKeys(em);
    Thread.sleep(2000);
    driver.findElement(passLogin).sendKeys(pas);
    Thread.sleep(2000);
    driver.findElement(By.id("signin")).click();
   }

}