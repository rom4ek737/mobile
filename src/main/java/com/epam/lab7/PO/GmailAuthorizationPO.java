package com.epam.lab7.PO;

import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailAuthorizationPO {
    private AppiumDriver driver;
    private static final Logger LOGGER = LogManager.getLogger(GmailAuthorizationPO.class);

    public GmailAuthorizationPO(AppiumDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@name = 'identifier']")
    private WebElement loginField;

    @FindBy(css = "#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input")
    private WebElement passwordField;


    public void typeTheLogin(String username) {
        LOGGER.info("We are on the login gmail page");
        loginField.click();
        loginField.sendKeys(username);
        loginField.sendKeys(Keys.ENTER);
        LOGGER.info("Login was entered successfully");
    }

    public void typeThePassword(String password) throws InterruptedException {
        LOGGER.info("We are started to type the password");
        Thread.sleep(1000);
        passwordField.click();
        passwordField.sendKeys(password);
        passwordField.sendKeys(Keys.ENTER);
    }
}
