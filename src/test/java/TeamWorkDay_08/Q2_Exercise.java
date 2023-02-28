package TeamWorkDay_08;

import Utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class Q2_Exercise extends TestBase {

    //https://amazon.com adresine gidin

    //iphone aratalim
    //en ucuza sirala secenegini secip
    // ilk urune tiklayin ve ekran resmini

    @Test
    public void test01() throws IOException, IOException {
        // https://www.amazon.com gidin
        driver.get("https://www.amazon.com");
        // iphone 4s aratalim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Iphone 4s" + Keys.ENTER);

        // en ucuza sirala secenegini secip

        WebElement ddm = driver.findElement(By.xpath("//span[@data-csa-c-func-deps='aui-da-a-dropdown-button']"));
        ddm.click();

        driver.findElement(By.linkText("Price: Low to High")).click();


        // ilk urune tiklayin ve ekrran resmini

        WebElement siralamaSonIlkUrun = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/div/div/div/div[1]/div/div[2]/div/span/a/div/img"));

        TakesScreenshot tkSs = (TakesScreenshot) driver;

        File sonurunSs = new File("target/urun.png");

        File geciciData = tkSs.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciData, sonurunSs);


    }
}