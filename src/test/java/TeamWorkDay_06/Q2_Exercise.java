package TeamWorkDay_06;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class Q2_Exercise {

    // youtube sayfasina gidin
    // butun cookies leri listeleyin
    // tum cookies sayisinin 10 dan dusuk oldugunu test edin
    // sayfanin tum cookielerinin siliniz

    @Test
    public void test02(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.youtube.com");

        // butun cookies leri listeleyin


        Set<Cookie> ytCookie =driver.manage().getCookies();
        int siraNo=1;
        for (Cookie eachCookie:ytCookie){
            System.out.println(siraNo+" : "+eachCookie.toString());
            siraNo++;
        }

        // tum cookies sayisinin 10 dan dusuk oldugunu test edin
        Assert.assertTrue(ytCookie.size()<10);


        // sayfanin tum cookielerinin siliniz

        driver.manage().deleteAllCookies();
        Assert.assertTrue(ytCookie.size()!=0);
    }





}
