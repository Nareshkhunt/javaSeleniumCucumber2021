package com.resourceWise.stepDefinitions;

import com.resourceWise.webPages.HomePage;
import com.resourceWise.webPages.SearchResultpage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SearchSteps {

    HomePage homePage=new HomePage();
    SearchResultpage searchResultpage=new SearchResultpage();

    @Given("^I am on the home page$")
    public void i_am_on_the_home_page() throws Throwable {
     String acualUrl   =homePage.getPresentUrl();
     assertThat(acualUrl, is(endsWith("co.uk/")));

    }

    @When("^I search for a product \"([^\"]*)\"$")
    public void i_search_for_a_product(String myItem) throws Throwable {
        homePage.searchProduct(myItem);
        homePage.toClick();
    }

    @Then("^I should to see respective results$")
    public void i_should_to_see_respective_results() throws Throwable {
     String actualItem=searchResultpage.getProductsHeaderText();
    String expextedItem =HomePage.searchItem;
    assertThat(actualItem,is(equalToIgnoringCase(expextedItem)));

    }

}
