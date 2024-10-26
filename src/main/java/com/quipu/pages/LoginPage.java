package com.quipu.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.quipu.base.BaseClass;

public class LoginPage extends BaseClass{
	private WebDriver driver;

    @FindBy(xpath = "//a[contains(@title, 'Log in to your customer account')]")
    private WebElement signInButton;
    
    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    @FindBy(id = "SubmitLogin")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login() {
        signInButton.click();
        emailField.sendKeys(prop.getProperty("email"));
        passwordField.sendKeys(prop.getProperty("password"));
        loginButton.click();
    }
}
