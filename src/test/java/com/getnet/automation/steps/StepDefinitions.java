package com.getnet.automation.steps;

import com.getnet.automation.pages.HelpCenterPage;
import com.getnet.automation.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class StepDefinitions {

    WebDriver driver = Hooks.getDriver();
    HomePage homePage;
    HelpCenterPage helpCenterPage;

    @Given("the user is on the GetNet homepage")
    public void the_user_is_on_the_get_net_homepage() {
        driver.get("https://site.getnet.com.br/");
        homePage = new HomePage(driver);
    }

    @When("he navigate to the Help Center")
    public void he_navigate_to_the_help_center() {
        homePage.hoverAndClickAjudaMenu();
        homePage.clickCentralDeAjuda();
    }

    @When("search for {string}")
    public void search_for(String keyword) {
        helpCenterPage = new HelpCenterPage(driver);
        helpCenterPage.search(keyword);
    }

    @When("select the search result {string}")
    public void select_the_search_result(String result) {
        helpCenterPage.clickSearchResult(result);
    }

    @Then("he should see the modal with the explanation text")
    public void he_should_see_the_modal_with_the_explanation_text() {
        helpCenterPage.isModalDisplayed();
    }
}
