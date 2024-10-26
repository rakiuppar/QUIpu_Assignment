package com.quipu.UITests;

import org.testng.annotations.*;

import com.quipu.pages.LoginPage;
import com.quipu.pages.ProductPage;
import com.quipu.pages.SearchPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.testng.Assert.assertTrue;

public class AddToCartTest {
    private WebDriver driver;
    private ProductPage productPage;
    private LoginPage loginPage;
    private SearchPage searchPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://www.automationpractice.pl/index.php");
        driver.manage().window().maximize();
        productPage = new ProductPage(driver);
        loginPage = new LoginPage(driver);
        searchPage = new SearchPage(driver);
    }

    @Test
    public void testAddToCart() throws InterruptedException {
    	loginPage.login();
    	searchPage.searchProduct("dress");
    	productPage.addToCart();
        assertTrue(productPage.isProceedToCheckoutButtonDisplayed(), "Proceed to checkout button not displayed.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
