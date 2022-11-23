import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class App {

    static WebDriver driver = new ChromeDriver();
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        
        driver.get("https://www.asos.com");

        Thread.sleep(1000); 
        driver.quit();
    }
}
