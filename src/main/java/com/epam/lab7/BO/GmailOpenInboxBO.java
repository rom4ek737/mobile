package com.epam.lab7.BO;

import com.epam.lab7.PO.OpenInboxPO;
import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

public class GmailOpenInboxBO {
    private AppiumDriver driver;
    private static final Logger LOGGER = LogManager.getLogger(GmailAuthorizationBO.class);

    public GmailOpenInboxBO(AppiumDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void openInboxPage() throws InterruptedException{
        OpenInboxPO openInboxPO = new OpenInboxPO(driver);
        openInboxPO.openGmail();
        LOGGER.info("Click without update");
//        Thread.sleep(2000);
//        openInboxPO.clickWithoutUpdateGmail();
        LOGGER.info("Main gmail page was opened");
    }
}
