package com.adidas.step_definitions;

import com.adidas.pages.DashBoardPage;
import com.adidas.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class VerifyItems_Steps extends BaseClass{

    @Given("user open url {string}")
    public void user_open_url(String url) {
        Driver.getDriver().get(url);
        dashBoardPage = new DashBoardPage();
    }

    @When("user click on {string}")
    public void userClickOn(String category) {
        dashBoardPage.click_on_category_meny(category);
    }


    @Then("user can view items under items as showen below:")
    public void verify_items(List<String> items) {
        boolean flag = dashBoardPage.get_items_under_phone_category(items);
        Assert.assertTrue("Expected items does not match actual items ",flag);
    }
}