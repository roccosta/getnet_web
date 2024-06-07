package com.getnet.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    @FindBy(css = "#menu-header-menu > li:nth-child(3) > span")
    WebElement ajudaMenu;

    @FindBy(css = "#menu-ajuda-sou-cliente-central-ajuda")
    WebElement centralDeAjuda;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void hoverAndClickAjudaMenu() {
        utils.waitAndHover(ajudaMenu);
    }

    public void clickCentralDeAjuda() {
        utils.waitAndClick(centralDeAjuda);
    }
}
