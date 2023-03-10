package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


    public class TestBaseClass {
        public static WebDriver driver ;

        @BeforeClass
        public void setup(){
            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

        @After
        public static void teardown(){
            driver.close();

        }

}
