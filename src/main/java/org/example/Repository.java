package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Repository {
    static WebDriver driver = null;
    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.v3.fireflink.com");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.findElement(By.xpath("//input[@id=\"email\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys("pavan.n@yopmail.com");
        driver.findElement(By.xpath("//input[@id=\"password\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("Password@123");



    }
}
