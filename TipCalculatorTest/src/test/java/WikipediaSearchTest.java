import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WikipediaSearchTest {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\SUNIL KUMAR\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
         //Create webdriver instance
        WebDriver driver=new ChromeDriver();

        //navigate to url
        driver.get("https://qawikisearch.ccbp.tech/");

        //Find the input field and send keys
        WebElement inputfield1=driver.findElement(By.xpath("//input[@id ='searchInput']"));
        inputfield1.sendKeys("HTML");

        //Find the search button and perform click action
        WebElement Btn=driver.findElement(By.xpath("//button[@class='search-button']"));
        Btn.click();

        //use webdriverwait to wait until elements located
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='result-item']")));

        //find the number of elements visible
        List<WebElement> elements=driver.findElements(By.xpath("//div[@class='result-item']"));
        System.out.println(elements.size()+"items found");

        //close the browser
        driver.quit();
    }
}
