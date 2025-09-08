package Tests;

import Base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class LoginTest extends BaseTest {
    @Test
    public void verifyValidLogin() {
        loginPage.login("pavan.n@yopmail.com", "Password@123");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.urlContains("projects"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://app.v3.fireflink.com/app/projects");
    }

    @Test
    public void testInvalidLoginWrongPassword() {
        loginPage.login("pavan.n@yopmail.com", "wrongpassword");

        Assert.assertTrue(driver.getPageSource().contains("Invalid, please"),
                "Email or Password is invalid, please try again");
    }

    @Test
    public void testInvalidLoginEmptyFields() {
        loginPage.emailField().sendKeys("");
        loginPage.passwordField().sendKeys("");
        Assert.assertFalse(loginPage.signInButton().isEnabled());
    }

}
