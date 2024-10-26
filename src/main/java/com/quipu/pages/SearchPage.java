package com.quipu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class SearchPage {
    private WebDriver driver;

    @FindBy(id = "search_query_top")
    private WebElement searchInput;

    @FindBy(name = "submit_search")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='product_list']//div[contains(@class, 'product-container')]")
    private List<WebElement> productResults;

    @FindBy(xpath = "//div[@class='alert-warning']")
    private WebElement noResultsAlert;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchProduct(String productName) {
        searchInput.clear();
        searchInput.sendKeys(productName);
        searchButton.click();
    }

    public boolean areResultsDisplayed() {
        return !productResults.isEmpty();
    }

    public boolean isNoResultsAlertDisplayed() {
        return noResultsAlert.isDisplayed();
    }
}
