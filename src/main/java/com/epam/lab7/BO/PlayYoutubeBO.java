package com.epam.lab7.BO;

import com.epam.lab7.PO.OpenYoutubePO;
import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

public class PlayYoutubeBO {
    private AppiumDriver driver;
    private static final Logger LOGGER = LogManager.getLogger(GmailAuthorizationBO.class);

    public PlayYoutubeBO(AppiumDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void searcAndPlayVideo() {
        LOGGER.info("Before searching video");
        OpenYoutubePO oyPO = new OpenYoutubePO(driver);
        oyPO.openYoutube();
        oyPO.searchVideo();
        oyPO.playVideo();
        LOGGER.info("After searching video");
    }
}
