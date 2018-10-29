package com.epam.lab7.BO;

import com.epam.lab7.PO.GmailAuthorizationPO;
import com.epam.lab7.PropertySettings;
import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

public class GmailAuthorizationBO {
    private AppiumDriver driver;
    private static final Logger LOGGER = LogManager.getLogger(GmailAuthorizationBO.class);

    public GmailAuthorizationBO(AppiumDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public Boolean loginGoogleAccountAndGmail() throws InterruptedException {
        GmailAuthorizationPO gaPO = new GmailAuthorizationPO(driver);
        LOGGER.info("Type the login BO");
        gaPO.typeTheLogin(PropertySettings.openPrprtFile("login"));
        LOGGER.info("Login was entered successfully");
        gaPO.typeThePassword(PropertySettings.openPrprtFile("password"));
        LOGGER.info("Password was entered successfully");
        return true;
    }
}
