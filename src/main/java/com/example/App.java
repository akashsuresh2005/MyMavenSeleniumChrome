package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;

public class App {

    public static void main(String[] args) throws InterruptedException {

        // Run SauceDemo Login Test
        runSauceDemoTest();

        // Run PracticeTestAutomation Login Test
        runPracticeTestAutomation();

        // Run AutomationExercise Add-To-Cart Test
        runAutomationExerciseTest();
    }



    // ---------------------------------------------------
    // Website 1 : https://www.saucedemo.com/
    // Login using standard_user credentials
    // ---------------------------------------------------
    public static void runSauceDemoTest() throws InterruptedException {

        System.out.println("Running SauceDemo Login Test");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        Thread.sleep(2000);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        Thread.sleep(2000);

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        Thread.sleep(2000);

        driver.findElement(By.id("login-button")).click();

        Thread.sleep(4000);

        driver.quit();
    }



    // ---------------------------------------------------
    // Website 2 : https://practicetestautomation.com/
    // Login using student credentials
    // ---------------------------------------------------
    public static void runPracticeTestAutomation() throws InterruptedException {

        System.out.println("Running PracticeTestAutomation Login");

        WebDriver driver = new ChromeDriver();

        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.manage().window().maximize();

        Thread.sleep(2000);

        driver.findElement(By.id("username")).sendKeys("student");

        Thread.sleep(2000);

        driver.findElement(By.id("password")).sendKeys("Password123");

        Thread.sleep(2000);

        driver.findElement(By.id("submit")).click();

        Thread.sleep(4000);

        driver.quit();
    }



    // ---------------------------------------------------
    // Website 3 : https://automationexercise.com/
    // Scroll → Add first product to cart → Continue shopping
    // ---------------------------------------------------
    public static void runAutomationExerciseTest() throws InterruptedException {

        System.out.println("Running AutomationExercise Add-To-Cart Test");

        WebDriver driver = new ChromeDriver();

        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();

        Thread.sleep(4000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll down to product section
        js.executeScript("window.scrollBy(0,600)");

        Thread.sleep(3000);

        // Locate first Add-to-cart button
        WebElement addToCart = driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[1]"));

        // Scroll button into view
        js.executeScript("arguments[0].scrollIntoView(true);", addToCart);

        Thread.sleep(2000);

        // Click Add-to-cart using JavaScript (avoids intercepted click error)
        js.executeScript("arguments[0].click();", addToCart);

        Thread.sleep(3000);

        // Click Continue Shopping in popup
        driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]")).click();

        Thread.sleep(4000);

        driver.quit();
    }

}
