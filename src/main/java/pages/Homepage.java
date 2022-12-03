package main.java.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


public class Homepage {

    private WebDriver driver;

    //Page URL
    private static String PAGE_URL="https://www.asos.com";

   //Constructor
    public Homepage(WebDriver driver){
    this.driver=driver;
    driver.get(PAGE_URL);
    //Initialise Elements
    PageFactory.initElements(driver, this);
    }

   //Instagram icon
   public static By igIcon = By.xpath("//a[@href='https://www.instagram.com/asos/']");
   public void clickOnSocialMedia(){
    driver.findElement(igIcon).click();
   }
   //Go to register
   public static By loginIcon = By.xpath("//button[@data-testid='myAccountIcon']");

   public void clickOnJoin(){
    driver.findElement(loginIcon).click();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //since the element is initially hidden, we need to put a wait 
	WebElement element = wait.until(
	ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-testid='signup-link']")));
	    driver.findElement(By.xpath("//a[@data-testid='signup-link']")).click();
   }

   public void clickOnLogin(){
    driver.findElement(loginIcon).click();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //since the element is initially hidden, we need to put a wait 
	WebElement element = wait.until(
	ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-testid='signin-link']")));
	    driver.findElement(By.xpath("//a[@data-testid='signin-link']")).click();
   }

   //search bar
   public static By search = By.xpath("//input[@data-testid='search-input']");
   public void enterInput(String input){
    driver.findElement(search).sendKeys(input+Keys.ENTER);
   }

   //Men's category 
   public static By menCat = By.id("men-floor");
   public void chooseSubcategory(String cat, String sub, String s){
        driver.findElement(menCat).click(); //click on 'Men'
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); 
        WebElement element = wait.until(
        ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-id='87a52035-f6fa-401f-bd58-0d259e403cbb']")));
        driver.findElement(By.xpath("//button[@data-id='87a52035-f6fa-401f-bd58-0d259e403cbb']")).click();
        WebElement element1 = wait.until(
        ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='https://www.asos.com/men/shoes-boots-trainers/sandals/cat/?cid=6593#nlid=mw|shoes|shop+by+product|sandals']")));
        driver.findElement(By.xpath("//a[@href='https://www.asos.com/men/shoes-boots-trainers/sandals/cat/?cid=6593#nlid=mw|shoes|shop+by+product|sandals']")).click();

        //choose a product and click
        List<WebElement> results = driver.findElements(By.xpath("//div[@data-auto-id='productTileDescription']"));
        results.get(1).click();

        
        By size = By.xpath("//select[@id='main-size-select-0']");
        driver.findElement(size).sendKeys(s);

        //click on 'Add to cart'
        driver.findElement(By.id("product-add-button")).click();
   }

   
   }
    