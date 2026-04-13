package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WindowType;

public class App {

    public static void main(String[] args) throws InterruptedException {

     WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // ---------------------------------------------------
        // TAB 1 : PracticeTestAutomation
        // ---------------------------------------------------
        driver.get("https://practicetestautomation.com/practice-test-login/");

        Thread.sleep(2000);

        driver.findElement(By.id("username")).sendKeys("student");

        Thread.sleep(2000);

        driver.findElement(By.id("password")).sendKeys("Password123");

        Thread.sleep(2000);

        driver.findElement(By.id("submit")).click();

        Thread.sleep(4000);



        // ---------------------------------------------------
        // TAB 2 : AutomationExercise
        // ---------------------------------------------------
        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://automationexercise.com/");

        Thread.sleep(4000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,600)");

        Thread.sleep(3000);

        WebElement addToCart = driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[1]"));

        js.executeScript("arguments[0].scrollIntoView(true);", addToCart);

        Thread.sleep(2000);

        js.executeScript("arguments[0].click();", addToCart);

        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]")).click();

        Thread.sleep(5000);

        driver.quit();
    }
}
