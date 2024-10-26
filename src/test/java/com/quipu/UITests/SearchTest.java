package com.quipu.UITests;

import org.testng.annotations.*;

import com.quipu.pages.SearchPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.testng.Assert.assertTrue;

public class SearchTest {
    private WebDriver driver;
    private SearchPage searchPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://www.automationpractice.pl/index.php");
        searchPage = new SearchPage(driver);
    }

    @Test
    public void testValidProductSearch() {
        String productName = "Dress";
        searchPage.searchProduct(productName);

        assertTrue(searchPage.areResultsDisplayed());
    }

    @Test
    public void testInvalidProductSearch() {
        String invalidProductName = "NonExistentProduct123";
        searchPage.searchProduct(invalidProductName);

        assertTrue(searchPage.isNoResultsAlertDisplayed());
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
