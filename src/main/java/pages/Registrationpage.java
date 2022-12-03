package main.java.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;



public class Registrationpage {

    private WebDriver driver;
   //Constructor
    public Registrationpage(WebDriver driver){
    this.driver=driver;
    }

   //elements 
   public static By email = By.id("Email");
   public static By firstName = By.id("FirstName");
   public static By lastName = By.id("LastName");
   public static By password = By.id("Password");
   By dateOfBirthDay = By.id("BirthDay");
   By dateOfBirthMonth = By.id("BirthMonth");
   By dateOfBirthYear = By.id("BirthYear");
   public static By interestedIn = By.id("female");
   public static By registerBtn = By.id("register");

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

}