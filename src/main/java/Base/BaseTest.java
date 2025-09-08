package Base;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

import java.time.Duration;

public class BaseTest {

    protected static WebDriver driver;
    public static LoginPage loginPage = null;

    @BeforeMethod
    public void intialiseDriver() throws InterruptedException {
        ChromeOptions option = new ChromeOptions();
        option.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.v3.fireflink.com");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
        Thread.sleep(60000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        loginPage = new LoginPage(driver);
    }


    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
