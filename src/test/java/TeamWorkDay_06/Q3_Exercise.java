package TeamWorkDay_06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Q3_Exercise {
    //https://ultimateqa.com/simple-html-elements-for-automation/ sayfasina gidin
    //" HTML Table with unique id" baslikli WebTable da bulunan butun datalari yazdirin ve data
    // sayisinin 10 dan az oldugunu test edin
    // Automation Testing Architect mesleginin salary bilgisini yazdirin
    // salary in $110,000+ daha yuksek oldugunu test edin


    @Test
    public void test03(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
        //" HTML Table with unique id" baslikli WebTable da bulunan butun datalari yazdirin ve data
        // sayisinin 10 dan az oldugunu test edin
        Actions actions=new Actions(driver);
        WebElement uniqueId=driver.findElement(By.xpath("//h2[text()='HTML Table with no id']"));
        actions.scrollToElement(uniqueId).perform();





    }
}
