import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TipCalculatorPageTest {
    public static void main(String[] args){
        //SET PATH TO CHROME DRIVER
        System.setProperty("webdriver.chrome.driver","C:\\Users\\SUNIL KUMAR\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");

        //Create WebDriver Insatnce
        WebDriver driver=new ChromeDriver();

        //Navigate to url
        driver.get("https://qatipcalc.ccbp.tech/");

        //CALCULATE THE TIP AMOUNT

        //Find Bill Amount Input Field
        WebElement Bill=driver.findElement(By.cssSelector("input[id ^= 'bill']"));
        Bill.sendKeys("1000");

        //Find Tip Percentage Input Field
        WebElement Tip=driver.findElement(By.cssSelector("input[id ^= 'percentage']"));
        Tip.sendKeys("12");

        //Find The Calculate Button and Perform Click Action
        WebElement Btn=driver.findElement(By.cssSelector("button[id ^= 'calculate']"));
        Btn.click();

        //Calculate The Tip Amount and TotalAmount
        WebElement TipAmount1=driver.findElement(By.cssSelector("p[id *= 'tipAmount']"));
        String TipAmount=TipAmount1.getText();
        String ExpectedText1="120.00";
        if(ExpectedText1.equals(TipAmount)){
            System.out.println("Tip amount calculate correctly");
        }else{
            System.out.println("Tip amount calculate Incorrectly");
        }


        WebElement TotalAmount1=driver.findElement(By.cssSelector("p[id *= 'total']"));
        String TotalAmount=TotalAmount1.getText();
        String ExpectedText2="1120.00";
        if(ExpectedText2.equals(TotalAmount)){
            System.out.println("Tip amount calculate correctly");
        }else{
            System.out.println("Tip amount calculate Incorrectly");
        }

        //TEST THE ERROR MESSAGE OF NO INPUTS

        //Find Tip Percentage Input Field and clear the field
        WebElement Tip1=driver.findElement(By.cssSelector("input[id ^= 'percentage']"));
        Tip1.clear();

        //Find The Calculate Button and Perform Click Action
        WebElement Btn1=driver.findElement(By.cssSelector("button[id ^= 'calculate']"));
        Btn1.click();

        //Verify the error message
        WebElement Errormsg=driver.findElement(By.cssSelector("p[id *= 'error']"));
        String Errormsgfield=Errormsg.getText();
        String Expectederror="Please Enter a Valid Input.";
        if(Expectederror.equals(Errormsgfield)){
            System.out.println("Error message displayed for no inputs");
        }else{
            System.out.println("Error message not displayed for no inputs");
        }

        //TEST THE ERROR MESSAGE OF INVALID INPUTS

        //Find Tip Percentage Input Field
        WebElement TipPercent=driver.findElement(By.cssSelector("input[id ^= 'percentage']"));
        TipPercent.sendKeys("10f");


        //Find The Calculate Button and Perform Click Action
        WebElement Btn2=driver.findElement(By.cssSelector("button[id ^= 'calculate']"));
        Btn2.click();

        //Verify the error message
        WebElement Errormsg2=driver.findElement(By.cssSelector("p[id $= 'Message']"));
        String Errormsgfield2=Errormsg2.getText();
        String Expectederror2="Please Enter a Valid Input.";
        if(Expectederror2.equals(Errormsgfield2)){
            System.out.println("Error message displayed for invalid inputs");
        }else{
            System.out.println("Error message not displayed for invalid inputs");
        }
    }
}
