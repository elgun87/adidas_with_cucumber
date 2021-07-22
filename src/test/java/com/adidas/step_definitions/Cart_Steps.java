package com.adidas.step_definitions;

import com.adidas.utilities.BrowserSleep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class Cart_Steps extends BaseClass{
    @And("user click on cart button")
    public void userClickOnCartButton() {
        BrowserSleep.wait(1);
        cart.click_on_cart_btn();
    }

    @Then("verify all added phone item price one by one")
    public void verifyAllAddedPhoneItemPriceOneByOne() {
        boolean flag = cart.verify_cart_items_price();
        System.out.println(flag);
        Assert.assertTrue("Phone items price does not match Cart items price",flag);
    }

    @Then("remove all items")
    public void removeAllItems() {
        int size = cart.remove_items_from_cart();
        Assert.assertTrue("Cart items count is not zero",size == 0);
    }
}
