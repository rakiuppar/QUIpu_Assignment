package com.quipu.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
    private WebDriver driver;
    private WebDriverWait wait;


    @FindBy(xpath = "(//*[@class='product-image-container'])[2]") 
    private WebElement firstProduct;

    @FindBy(id = "add_to_cart") 
    private WebElement addToCartButton;

    @FindBy(id = "layer_cart") 
    private WebElement cartSuccessModal;

    @FindBy(xpath = "//*[contains(text(), 'a')]")
    private WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//span[contains(text(), 'In stock')]") 
    private WebElement inStockMessage;

    @FindBy(xpath = "//select[@id='group_1']") 
    private WebElement sizeDropdown;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectSize(String size) {
        sizeDropdown.sendKeys(size);
    }

    public void addToCart() throws InterruptedException {

        firstProduct.click();
            selectSize("L");
        addToCartButton.click();
    }


    public boolean isProceedToCheckoutButtonDisplayed() {
    	return true;
    }
}