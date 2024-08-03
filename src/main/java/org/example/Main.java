package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

//public class Main {
//    public static void main(String[] args) {
////        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user6\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
////        WebDriver driver = new ChromeDriver();
////        driver.get("https://www.example.com");
////        System.out.println("Title: " + driver.getTitle());
////        driver.quit();
////        WebDriver driver;
////
////        @BeforeClass
////        public void setUp() {
////            // Set the path to the ChromeDriver executable
////            System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\user6\\\\Downloads\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");
////
////            // Initialize the ChromeDriver
////            driver = new ChromeDriver();
////        }
////
////        @Test
////        public void testGoogleSearch() {
////            // Navigate to Google
////            driver.get("https://www.google.com");
////
////            // Find the search box using its name attribute
////            WebElement searchBox = driver.findElement(By.name("q"));
////
////            // Enter a search term and submit the search
////            searchBox.sendKeys("TestNG");
////            searchBox.submit();
////
////            // Wait for the results to load and verify the title
////            WebElement results = driver.findElement(By.id("search"));
////            Assert.assertTrue(results.getText().contains("TestNG"));
////
////            // Print the title of the page
////            System.out.println("Page Title: " + driver.getTitle());
////        }
////
////        @AfterClass
////        public void tearDown() {
////            // Close the browser
////            if (driver != null) {
////                driver.quit();
////            }
////        }
////
////    }
//}