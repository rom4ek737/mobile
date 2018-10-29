package com.epam.lab7.PO;

import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class OpenInboxPO {
    private AppiumDriver driver;
    private static final Logger LOGGER = LogManager.getLogger(OpenInboxPO.class);

    public OpenInboxPO(AppiumDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = ".WaidBe")
    WebElement openGmail;

    @FindBy(xpath = "//*[@id = 'sdppromo']/div/div/div[4]/div/div[1]")
    WebElement notInterested;

    public void openGmail() {
        LOGGER.info("Starting open gmail");
        openGmail.click();

    }

    public void clickWithoutUpdateGmail() {
        notInterested.click();
    }
}
