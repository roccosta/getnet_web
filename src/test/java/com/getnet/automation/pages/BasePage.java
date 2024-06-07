package com.getnet.automation.pages;

import com.getnet.automation.utils.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverUtils utils;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.utils = new WebDriverUtils(driver);
        PageFactory.initElements(driver, this);
    }

}
