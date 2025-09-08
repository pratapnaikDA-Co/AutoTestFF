package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
    private WebDriver driver;

    @FindBy(id = "email")
    private WebElement emailTextField;

    @FindBy(id = "password")
    private WebElement passwordTextField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement signInButton;



    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String emailId, String password){
        emailTextField.sendKeys(emailId);
        passwordTextField.sendKeys(password);
        signInButton.click();
    }

    public WebElement emailField(){
        return emailTextField;
    }
    public WebElement passwordField(){
        return passwordTextField;
    }
    public WebElement signInButton(){
        return signInButton;
    }

    public WebElement getRequiredProject(String projectName){
        String projectXpath = "//tr[@class='ff-table-data-row']//span[text()='"+projectName+"']";
        return driver.findElement(By.xpath(projectXpath));
    }

    public WebElement getSection(String headerName) {
        String headerXpath = "//div[@class=\"ff-app-header-nav-bar-items fontSm\"]//div//div[text()='" + headerName + "']";
        return driver.findElement(By.xpath(headerXpath));
    }
}
