package com.adidas.pages;

import com.adidas.utilities.BrowserSleep;
import com.adidas.utilities.Driver;
import com.adidas.utilities.DriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    public Cart() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[contains(text(),'Cart')]")
    private WebElement cart_btn;

    @FindBy(css = "tbody#tbodyid tr")
    private List<WebElement> cart_items;

    @FindBy(css = "tbody#tbodyid tr")
    private List<WebElement> cart_items_remove;

    public void click_on_cart_btn() {
        cart_btn.click();
    }

    public boolean verify_cart_items_price(){
        /**todo explanation of this method
        todo In the first loop I store cart items inside "cart_items_name_prices" data structure.
         */
        Map<String,String> cart_items_name_prices = new HashMap<>();
        DashBoardPage.dashboar_items = new HashMap<>();
        for(int i = 0;i < cart_items.size();i++){
            String name = cart_items.get(i).findElement(By.cssSelector("td:nth-child(2)")).getText();
            String price = cart_items.get(i).findElement(By.cssSelector("td:nth-child(3)")).getText();
            cart_items_name_prices.put(name,price);
        }
        /*
        todo In second loop I am verifying phone items price with cart items price to see if they are matching.
        todo if it is not matching then this method will return false
         */
        for(int i = 0; i < DashBoardPage.dashboar_items.size(); i++){
            if(!DashBoardPage.dashboar_items.get(i).equals(cart_items_name_prices.get(i))){
                System.out.println(DashBoardPage.dashboar_items.get(i));
                System.out.println(cart_items_name_prices.get(i));
                return false;
            }
        }
        return true;
    }
    public int remove_items_from_cart(){
       /*
       todo this method is removing items from the cart
        */
        System.out.println(cart_items.size());
        for(int i = 0;i < cart_items.size();i++){
            cart_items.get(i).findElement(By.cssSelector("tbody#tbodyid tr td:nth-child(4) a")).click();
            BrowserSleep.wait(1);
            i--;
        }
        return cart_items.size();
    }


}
