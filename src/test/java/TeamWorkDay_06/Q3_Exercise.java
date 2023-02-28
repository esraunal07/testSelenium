package TeamWorkDay_06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class Q3_Exercise {
    //https://ultimateqa.com/simple-html-elements-for-automation/ sayfasina gidin
    //" HTML Table with unique id" baslikli WebTable da bulunan butun datalari yazdirin ve data
    // sayisinin 10 dan az oldugunu test edin
    // Automation Testing Architect mesleginin salary bilgisini yazdirin
    // salary in $110,000+ daha yuksek oldugunu test edin


    @Test
    public  void test03(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://ultimateqa.com/simple-html-elements-for-automation/ sayfasina gidin
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
        Actions actions=new Actions(driver);
        WebElement baslik= driver.findElement(By.xpath("//*[text()='HTML Table with no id']"));
        actions.scrollToElement(baslik).perform();

        //"HTML Table with unique id" baslikli WebTable da bulunan butun datalari yazdirin ve data

        List<WebElement> dataList = driver.findElements(By.xpath("//tbody/tr"));
        int siraNo=1;
        for (WebElement eachElement: dataList){
            System.out.println(siraNo+" : "+eachElement.getText());
            siraNo++;
        }

        // data sayisinin 10 dan az oldugunu test edin
        Assert.assertTrue(dataList.size()<10);

        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        // Automation Testing Architect mesleginin salary bilgisini yazdirin
        WebElement maas=driver.findElement(By.xpath("(//tbody/tr/td)[6]"));
        String maasstr=maas.getText();
        System.out.println("Automation Testing Architect maas/Yilik : "+maasstr);

        // salary in 110,000 daha yuksek oldugunu test edin
        maasstr= maasstr.replaceAll("\\D","").replaceAll(",","");
        System.out.println(maasstr);

        int actualmaas=Integer.parseInt(maasstr);
        int expectedMiktar=110000;

        Assert.assertTrue(actualmaas>expectedMiktar);
        driver.close();

    }
}
