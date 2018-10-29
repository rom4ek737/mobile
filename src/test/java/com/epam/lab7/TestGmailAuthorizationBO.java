package com.epam.lab7;

import com.epam.lab7.BO.GmailAuthorizationBO;
import com.epam.lab7.BO.PlayYoutubeBO;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestGmailAuthorizationBO {

    private AppiumDriver driver;
    WebDriverWait wait;

    private static final Logger LOGGER = LogManager.getLogger(TestGmailAuthorizationBO.class);

    @Test
    public void beforeMethod() throws Exception {
        URL serverUrl = new URL(PropertySettings.openPrprtFile("url"));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1.1");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "MTP71561206825");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        capabilities.acceptInsecureCerts();

        LOGGER.info("Init pass!!!");
        AppiumDriver driver = new AndroidDriver(serverUrl, capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(PropertySettings.openPrprtFile("webadress"));
        LOGGER.info(driver.getDeviceTime());
//    }
//    @Test
//    public void firstPage() throws InterruptedException {
        GmailAuthorizationBO gaBO = new GmailAuthorizationBO(driver);
        Boolean result = gaBO.loginGoogleAccountAndGmail();
        Assert.assertTrue(result);
//        GmailOpenInboxBO goiBO = new GmailOpenInboxBO(driver);
//        goiBO.openInboxPage();
        PlayYoutubeBO pyBO = new PlayYoutubeBO(driver);
        pyBO.searcAndPlayVideo();

//    }
//    @AfterTest
//    public void closeDriver() {
        driver.close();
    }
}
