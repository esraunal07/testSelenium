package TeamWorkDay_06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Q1_ExplicityWait_Exercise {
    //Wise quarter adseine gidin
    // id si "zsiq_agtpic" olan chat objesi yuklenenne kadar bekleyin
    // chat objesinin basarili bir sekilde yuklandigini ve ulasilabilir oldugunu test edin


    @Test
    public void test01() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        //Wise quarter adseine gidin
        driver.get("https://www.wisequarter.com");
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        // id si "zsiq_agtpic" olan chat objesi yuklenenne kadar bekleyin
        WebElement mesajIconu= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("zsiq_agtpic")));
        mesajIconu.click();

        driver.switchTo().frame("siqiframe");

        // chat objesinin basarili bir sekilde yuklandigini ve ulasilabilir oldugunu test edin
        WebElement logo=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"emptybg\"]/div[2]/em[2]")));

        Assert.assertTrue(logo.isDisplayed());
        driver.switchTo().parentFrame();

        Thread.sleep(2000);

        driver.close();

    }

    }
