package com.adidas.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddItem_Steps extends BaseClass{


    @When("user captures all items and add all items to the cart")
    public void user_captures_all_items_and_add_all_items_to_the_cart() {
        dashBoardPage.get_items_names_and_prices();
        dashBoardPage.add_all_items_to_cart();

    }

    @When("user click on cart")
    public void user_click_on_cart() {

    }

    @When("user verfyies all items price")
    public void user_verfyies_all_items_price() {

    }

    @Then("user removes all items from cart")
    public void user_removes_all_items_from_cart() {


    }
}
