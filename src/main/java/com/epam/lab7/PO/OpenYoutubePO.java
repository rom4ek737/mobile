package com.epam.lab7.PO;

import com.epam.lab7.PropertySettings;
import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenYoutubePO {
    private AppiumDriver driver;
    private static final Logger LOGGER = LogManager.getLogger(OpenInboxPO.class);

    public OpenYoutubePO(AppiumDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id='yDmH0d']/div[2]/c-wiz/div/div/div[5]/div[2]/c-wiz/div/div[1]/div/div[1]/div[2]/a[4]")
    WebElement youtubeButton;

    @FindBy(xpath = "//*[@id='app']/ytm-header-bar/header/div/div/button")
    WebElement searchField;

    @FindBy(xpath = "//*[@id='app']/ytm-header-bar/header/ytm-searchbox/form/div[1]/input")
    WebElement typeValue;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/ytm-search/ytm-section-list-renderer/lazy-list/ytm-item-section-renderer/lazy-list/ytm-compact-video-renderer[1]/div/a/div/img")
    WebElement play;

    public void openYoutube() {
        youtubeButton.click();
    }

    public void searchVideo() {
        searchField.click();
        typeValue.sendKeys(PropertySettings.openPrprtFile("word"));
        typeValue.sendKeys(Keys.ENTER);
        LOGGER.info("Searching video result");
    }

     public void playVideo() {
        play.click();
        LOGGER.info("Video is playing:)");
     }

}
