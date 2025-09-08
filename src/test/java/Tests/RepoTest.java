package Tests;

import Base.BaseTest;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.LoginPage;

public class RepoTest extends BaseTest {
    @Test
    public void createAPageInRepo(){
        loginPage.login("pavan.n@yopmail.com","Password@123");
        WebElement desiredProject = loginPage.getRequiredProject("TestAuto_Proj");
        JavascriptExecutor exe= (JavascriptExecutor) driver;
        exe.executeScript("arguments[0].scrollIntoView(true);",desiredProject);
        WebElement desiredSection = loginPage.getSection("Repo");
        desiredSection.click();




    }
}
