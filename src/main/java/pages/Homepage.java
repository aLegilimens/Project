package main.java.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

public class Homepage {

    private WebDriver driver;
    Actions actions;

    /* Page URL */
    private static String PAGE_URL="https://www.asos.com";

   /* Constructor */
    public Homepage(WebDriver driver){
    this.driver=driver;
    driver.get(PAGE_URL);
    //Initialise Elements
    PageFactory.initElements(driver, this);
    }

   /* ELEMENTS */
   public static By loginIcon = By.xpath("//button[@data-testid='myAccountIcon']");
   public static By search = By.xpath("//input[@data-testid='search-input']");
   public static By menCat = By.id("men-floor");
   public static By sales = By.xpath("//a[@href='/men/sale/cat/?cid=8409&ctaref=hp|mw|promo|banner|1|edit|extra20offsaleapponly']");
   public static By igIcon = By.xpath("//a[@href='https://www.instagram.com/asos/']");
   public static By forgot = By.id("forgot-password-link");
   public static By emailForgot = By.id("Email");
   public static By send = By.id("send");
   public static By emailLogin = By.id("EmailAddress");
   public static By signin = By.id("signin");
   public static By savedList = By.xpath("//a[@data-testid='savedItemsIcon']");
   public static By cart = By.xpath("//button[@data-testid='miniBagIcon']");
   public static By flag = By.xpath("//button[@data-testid='country-selector-btn']");


   /* Go to 'Join' page */
   public void clickOnJoin(){
    driver.findElement(loginIcon).click();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //since the element is initially hidden, we need to put a wait 
	WebElement element = wait.until(
	ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-testid='signup-link']")));
	    driver.findElement(By.xpath("//a[@data-testid='signup-link']")).click();
   }

   /* Go to 'Login' page */
   public void clickOnLogin(){
    driver.findElement(loginIcon).click();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //since the element is initially hidden, we need to put a wait 
	WebElement element = wait.until(
	ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-testid='signin-link']")));
	    driver.findElement(By.xpath("//a[@data-testid='signin-link']")).click();
   }

   /* Go to search bar */
    public void enterInput(String input){
    driver.findElement(search).sendKeys(input+Keys.ENTER);
   }

   /* Add a product by 'Men' category */
   public void chooseSubcategory(String cat, String sub, String s){
        driver.findElement(menCat).click(); /* click on 'Men'*/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); 
        WebElement element = wait.until(
        ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-id='87a52035-f6fa-401f-bd58-0d259e403cbb']")));
        driver.findElement(By.xpath("//button[@data-id='87a52035-f6fa-401f-bd58-0d259e403cbb']")).click();
        WebElement element1 = wait.until(
        ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='https://www.asos.com/men/shoes-boots-trainers/sandals/cat/?cid=6593#nlid=mw|shoes|shop+by+product|sandals']")));
        driver.findElement(By.xpath("//a[@href='https://www.asos.com/men/shoes-boots-trainers/sandals/cat/?cid=6593#nlid=mw|shoes|shop+by+product|sandals']")).click();

        //choose a product and click
        List<WebElement> results = driver.findElements(By.xpath("//article[@class='productTile_U0clN']"));
        results.get(1).click();

        By size = By.xpath("//select[@id='main-size-select-0']");
        driver.findElement(size).sendKeys(s);

        //click on 'Add to cart'
        driver.findElement(By.id("product-add-button")).click();
   }

   /* Add a product by 'Sales' ad */
   public void chooseProductSales(String s) throws InterruptedException{
    driver.findElement(menCat).click(); /* click on 'Men'*/
    Thread.sleep(2000);    
    driver.findElement(sales).click(); /* click on 'Sales Ad' */
        
        //choose a product and click
        List<WebElement> results = driver.findElements(By.xpath("//article[@class='productTile_U0clN']"));
        results.get(1).click();

        Thread.sleep(2000);
        //Select size - keep in mind that some of the products will not have a size selector we need to check for that
        By size;
        try {
            size = By.xpath("//select[@id='main-size-select-0']");
            Select selSize = new Select (driver.findElement(size));
            selSize.selectByIndex(2);
        } catch (org.openqa.selenium.NoSuchElementException e) {
            
        }

        Thread.sleep(2000);
        //click on 'Add to cart'
        driver.findElement(By.id("product-add-button")).click();
   }
   
   /* Go to social media accounts */
   public void clickOnSocialMedia(){
    driver.findElement(igIcon).click();
   }

   
   
   /* Add a product to Saved Items list */
   public void saved(){
    driver.findElement(menCat).click(); //click on 'Men'
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); 
    WebElement element = wait.until(
    ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-id='87a52035-f6fa-401f-bd58-0d259e403cbb']")));
    driver.findElement(By.xpath("//button[@data-id='c51a4a82-3055-436d-8a41-6621fd7439aa']")).click();
    WebElement element1 = wait.until(
    ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='https://www.asos.com/men/sportswear/tops/cat/?cid=27181#nlid=mw|sportswear|shop+by+product|tops']")));
    driver.findElement(By.xpath("//a[@href='https://www.asos.com/men/sportswear/tops/cat/?cid=27181#nlid=mw|sportswear|shop+by+product|tops']")).click();

    /* get the 'Save' button */
    List<WebElement> saveButtons = driver.findElements(By.className("saveForLater_mm1gc"));
    saveButtons.get(2).click();   
   }

   /* Test the 'Filter' option */
   public void filterResults() throws InterruptedException{   
    driver.findElement(menCat).click();
    Thread.sleep(3000);
    driver.findElement(sales).click(); 

    List<WebElement> filters = driver.findElements(By.className("button_eZ0Gy"));
    filters.get(4).click();

    List<WebElement> types = driver.findElements(By.className("li_IVqZE"));
    types.get(0).click();

    Thread.sleep(3000);
   }

   /* Test the 'Forgot password' functionality */
   public void forgotPass(String email){
    clickOnLogin();
    driver.findElement(forgot).click();
    driver.findElement(emailForgot).sendKeys(email);
    driver.findElement(send).click();
   }

   /* Login with invalid data */ 
   public void invalidLogin(String email){
    clickOnLogin();
    driver.findElement(emailLogin).sendKeys(email);
    driver.findElement(signin).click();
   }


   /* Add to cart from saved items */
   public void addFromSaved() throws InterruptedException{
    /* Add an item to Saved list */
    saved();
    /* Go to Saved list */
    driver.findElement(savedList).click();

    /* Select a size and add to the bag */
    Thread.sleep(2000);
    WebElement sizes = driver.findElement(By.cssSelector("[aria-label=Size]"));
    Select selectSize = new Select(sizes);
    selectSize.selectByIndex(2);
    Thread.sleep(2000);

    driver.findElement(By.className("toBagButton_LHRGf")).click();
   }

   /* Remove item from the cart */
   public void removeFromCart() throws InterruptedException{
    /* firstly add an item to the cart */
    addFromSaved();
    Thread.sleep(3000);
    /* go to the cart */
    driver.findElement(cart).click();
    /* click on the 'Delete' icon */
    By delete = By.xpath("//button[@class='_2y4LZqx']");
    driver.findElement(delete).click();
   }

   /*Update size from the cart*/
   public void updateSize() throws InterruptedException{
    driver.manage().window().maximize();
    /*firstly add an item to the cart*/
    addFromSaved();
    Thread.sleep(3000);
    /*go to the cart*/
    driver.get("https://www.asos.com/bag?nlid=nav%20header");
    Thread.sleep(3000);
    /*click on size */
    WebElement s = driver.findElement(By.xpath("//span[contains(@class,'select2 select2-container select2-container--default')]"));
    WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
    wait2.until(ExpectedConditions.elementToBeClickable(s));
    Thread.sleep(5000);
    s.click();

    /* click on the first size */ 
    Thread.sleep(5000);
    WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
    Thread.sleep(1000);
    actions = new Actions(driver);
    Thread.sleep(5000);
    actions.moveToElement(s);
    actions.moveByOffset(0, 20).click().perform();

    /* click on 'UPDATE' button to update the size */
    WebElement update = driver.findElement(By.xpath("//button[@class='bag-item-edit-update']"));
    wait3.until(ExpectedConditions.elementToBeClickable(update));
    update.click();
    Thread.sleep(5000);
   }

   /* Add product without size */
   public void addWithoutSize(String cat, String sub){
    driver.findElement(menCat).click(); /* click on 'Men'*/
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); 
    WebElement element = wait.until(
    ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-id='87a52035-f6fa-401f-bd58-0d259e403cbb']")));
    driver.findElement(By.xpath("//button[@data-id='87a52035-f6fa-401f-bd58-0d259e403cbb']")).click();
    WebElement element1 = wait.until(
    ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='https://www.asos.com/men/shoes-boots-trainers/sandals/cat/?cid=6593#nlid=mw|shoes|shop+by+product|sandals']")));
    driver.findElement(By.xpath("//a[@href='https://www.asos.com/men/shoes-boots-trainers/sandals/cat/?cid=6593#nlid=mw|shoes|shop+by+product|sandals']")).click();

    /* choose a product and click */
    List<WebElement> results = driver.findElements(By.xpath("//article[@class='productTile_U0clN']"));
    results.get(1).click();
    /* without choosing size click on 'Add to cart' */
    driver.findElement(By.id("product-add-button")).click();
   }

    /* Change currency */
    public void ChangeCurrency(){
        driver.manage().window().maximize();
        /* click on the button with the flag*/
        driver.findElement(flag).click();
    
        /* select currency */
        Select selCurr = new Select (driver.findElement(By.xpath("//select[@id='currency']")));
        selCurr.selectByIndex(1);
    
        //Click on 'Update preferences'
        driver.findElement(By.xpath("//button[@data-testid='save-country-button']")).click();
    }
    public void goToProductPage(){
        driver.findElement(menCat).click(); /* click on 'Men'*/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); 
        WebElement element = wait.until(
        ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-id='87a52035-f6fa-401f-bd58-0d259e403cbb']")));
        driver.findElement(By.xpath("//button[@data-id='87a52035-f6fa-401f-bd58-0d259e403cbb']")).click();
        WebElement element1 = wait.until(
        ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='https://www.asos.com/men/shoes-boots-trainers/sandals/cat/?cid=6593#nlid=mw|shoes|shop+by+product|sandals']")));
        driver.findElement(By.xpath("//a[@href='https://www.asos.com/men/shoes-boots-trainers/sandals/cat/?cid=6593#nlid=mw|shoes|shop+by+product|sandals']")).click();
    }
    
   }
   