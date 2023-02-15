package TeamWorkDay_02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q01_AutoTest {
    public static void main(String[] args) {

        // https://www.mercedes-benz.com adresine gidin
        // search bolumune "S class" yazip aratin
        // ilk cikan resme tiklayin.
        // sayfnin en alt bolumunde olan instagram linkine tiklayin
        // instagram linki acildiktan sonra kac tane takipcisi oldugunu bilgisini yazdirin
        // 5 saniye sonra driveri kapatin


        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.mercedes-benz.com ");








    }

}
