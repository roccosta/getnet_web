package com.getnet.automation.utils;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WebDriverUtils {

    private final WebDriverWait wait;
    private final Actions actions;

    public WebDriverUtils(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.actions = new Actions(driver);
    }

    public void waitAndClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void waitAndInputText(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }

    public boolean waitForElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }

    public void waitAndHover(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        actions.moveToElement(element).perform();
    }

    public void assertTextEqual(WebElement element, String expectedText) {
        String actualText = element.getText();
        Assert.assertEquals("Os textos são diferentes:", expectedText, actualText);
    }

    public void waitForLink(String link) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='" + link + "']")));
    }

}
