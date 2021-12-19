package com.resourceWise.stepDefinitions;

import com.resourceWise.webPages.BasketPage;
import com.resourceWise.webPages.ProductDescriptionPage;
import com.resourceWise.webPages.SearchResultpage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;


public class BasketSteps {
    SearchResultpage searchResultpage=new SearchResultpage();
    ProductDescriptionPage productDescriptionPage=new ProductDescriptionPage();
    BasketPage basketPage=new BasketPage();

    @When("^I select any product$")
    public void i_select_any_product() throws Throwable {
      searchResultpage.selectAnyProduct();
    }

    @When("^I add the product to the basket$")
    public void i_add_the_product_to_the_basket() throws Throwable {
        productDescriptionPage.addProductToBasket();
        productDescriptionPage.goToBasket();

    }

    @Then("^the product should be in the basket$")
    public void the_product_should_be_in_the_basket() throws Throwable {
       List<String> acualProductsInBasket =basketPage.getProductNmaesInBasket();
        System.out.println(acualProductsInBasket);

        String expected=SearchResultpage.selectedProduct;
        System.out.println(expected);

        assertThat(acualProductsInBasket, hasItem(expected));

    }

}
