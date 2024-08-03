package org.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class tests {
    // Web driver
    WebDriver driver;

    // Expected Stocks
    List<String> expectedStockSymbols = Arrays.asList("NFLX", "MSFT", "TSLA");


    @BeforeClass
    public void setUp() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user6\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Initialize the ChromeDriver
        driver = new ChromeDriver();

        // Navigate to google finance
        driver.get("https://www.google.com/finance");


    }
    @Test
    //Asserts the page loads by verifying the title matches
    public void assertGoogleFinanceTitle () {
        //Assert title matches expected title
        Assert.assertEquals(driver.getTitle(), "Google Finance - Stock Market Prices, Real-time Quotes & Business News");

        //Print Actual title
        System.out.println("The title is: " + driver.getTitle());
    }
    @Test
    // Prints actual stock list from google.com/finance
    public void printMayBeInterestedInStocks() {
        List<WebElement> stocks = driver.findElements(By.cssSelector("ul.sbnBtf li"));
        List<String> stockSymbols = new ArrayList<>();

        for (WebElement stock : stocks) {
            WebElement symbolElement = stock.findElement(By.cssSelector("div.COaKTb"));
            String symbol = symbolElement.getText();
            stockSymbols.add(symbol);
        }
        System.out.println("The current stock symbols are: " + stockSymbols);
    }

    @Test
    // Asserts if any of the expected stocks are in the actual stock list
    public void assertExpectedStocks() {
        List<WebElement> stocks = driver.findElements(By.cssSelector("ul.sbnBtf li"));

        List<String> actualValues = new ArrayList<>();
        for (WebElement stock : stocks) {
            WebElement symbolElement = stock.findElement(By.cssSelector("div.COaKTb"));
            actualValues.add(symbolElement.getText());
        }
        for (String expectedItem : expectedStockSymbols) {
            Assert.assertTrue(actualValues.contains(expectedItem));
        }
    }


        @Test
        // Asserts stocks in expected stocks are not in actual stock list
        public void assertExpectedStocksNotIn() {
            List<WebElement> stocks = driver.findElements(By.cssSelector("ul.sbnBtf li"));

            List<String> actualValues = new ArrayList<>();
            for (WebElement stock : stocks) {
                WebElement symbolElement = stock.findElement(By.cssSelector("div.COaKTb"));
                actualValues.add(symbolElement.getText());
            }
            for (String expectedItem : expectedStockSymbols) {
                Assert.assertFalse(actualValues.contains(expectedItem));
            }
        }

        @Test
        // Returns any of the expected stocks if found in actual stock list
        public void compareStocksList() {
            boolean anyStockMatches = false;

            List<WebElement> stocks = driver.findElements(By.cssSelector("ul.sbnBtf li"));
            List<String> stockSymbols = new ArrayList<>();

            for (WebElement stock : stocks) {
                WebElement symbolElement = stock.findElement(By.cssSelector("div.COaKTb"));
                String symbol = symbolElement.getText();
                stockSymbols.add(symbol);}
            for (String compare : expectedStockSymbols)
                if (stockSymbols.contains(compare)) {
                    System.out.println("The list contains " + compare + " from the expected stocks");
                    anyStockMatches = true; // Set the flag to true if any item is found
                }


        }


        @AfterClass
        // Cleans up the mess
        public void tearDown () {
            // Close the browser
            if (driver != null) {
                driver.quit();
            }
        }

    }

