package TeamWorkDay_08;

import Utilities.TestBase;
import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.units.qual.K;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

public class Q1_Exercise extends TestBase {

    // 1-https://parabank.parasoft.com/parabank/index.htm

    //email iconu na tiklayin
    //Customer Care altindaki gerekli bilgileri dodurun ve islemi onaylayin
    // Thank you  ifadesiin ciktigini test ediniz
    // ekran goruntusu aliniz

    @Test
    public void test01() throws IOException {

        // 1-https://parabank.parasoft.com/parabank/index.htm
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        //email iconu na tiklayin

        driver.findElement(By.linkText("contact")).click();
        //Customer Care altindaki gerekli bilgileri dodurun ve islemi onaylayin
        WebElement isimbolumu = driver.findElement(By.xpath("//input[@id='name']"));
        Actions actions=new Actions(driver);
        Faker faker = new Faker();

        actions.contextClick(isimbolumu).sendKeys(faker.name().fullName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().phoneNumber())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.lorem().characters())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        // Thank you  ifadesi ile baslayan cumlenin ciktigini test ediniz ciktigini test ediniz

        String actualIfade=driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/p[1]")).getText();
        String expectedIfade="Thank you";

        Assert.assertTrue(actualIfade.startsWith(expectedIfade));

        // ekran goruntusu aliniz

        TakesScreenshot tkss = (TakesScreenshot) driver;
        File ekrangoruntusu = new File("target/paraBank.png");
        File geciciData = tkss.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciData,ekrangoruntusu);

        driver.close();


    }
}
