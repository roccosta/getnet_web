package com.getnet.automation.pages;

import com.getnet.automation.constants.HelpCenterSearchResults;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class HelpCenterPage extends BasePage {

    @FindBy(id = "faq-search-input")
    WebElement searchInput;

    @FindBy(className = "c-search-dropdown-link__title")
    List<WebElement> searchResults;

    @FindBy(css = ".is-modal-open .o-modal__title")
    WebElement modalTitle;

    private String expectedResult;

    public HelpCenterPage(WebDriver driver) {
        super(driver);
    }

    public void search(String keyword) {
        utils.waitAndInputText(searchInput, keyword);
    }

    public void clickSearchResult(String expectedResult) {
        this.expectedResult = expectedResult;
        String link = HelpCenterSearchResults.getUrlForText(expectedResult);
        utils.waitForLink(link);
        for (WebElement result : searchResults) {
            String resultText = result.getText();
            if (resultText.equals(expectedResult)) {
                utils.waitAndClick(result);
                break;
            }
        }
    }

    public void isModalDisplayed() {
        assertTrue(utils.waitForElementToBeVisible(modalTitle));
        utils.assertTextEqual(modalTitle, this.expectedResult);
    }
}
