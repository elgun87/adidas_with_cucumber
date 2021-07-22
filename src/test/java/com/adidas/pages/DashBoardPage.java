package com.adidas.pages;

import com.adidas.utilities.BrowserSleep;
import com.adidas.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DashBoardPage {
    public static Map<String,String> dashboar_items = new HashMap<>();

    public DashBoardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    public void click_on_category_meny(String category) {
        BrowserSleep.wait(1);
        Driver.getDriver().findElement(By.linkText(category)).click();
    }

    public boolean get_items_under_phone_category(List<String> items) {
        BrowserSleep.wait(2);
        List<WebElement> allItems = Driver.getDriver().findElements(By.cssSelector("div#tbodyid a.hrefch"));
        for (int i = 0; i < allItems.size(); i++) {
            System.out.println(allItems.get(i).getText());
            if (!allItems.get(i).getText().equals(items.get(i))) {
                return false;
            }
        }
        return true;
    }

    //todo Add Item Steps
    @FindBy(css = "div#tbodyid h5")
    private List<WebElement> item_prices;

    @FindBy(css = "div#tbodyid h4")
    private List<WebElement> item_names;



    public Map<String, String> get_items_names_and_prices() {
        BrowserSleep.wait(2);
        for (int i = 0; i < item_names.size(); i++) {
            dashboar_items.put(item_names.get(i).getText(), item_prices.get(i).getText().replace("$",""));
        }
        for (Map.Entry each : dashboar_items.entrySet()) {
            System.out.println(each);
        }
        return dashboar_items;
    }

    public void add_all_items_to_cart() {
        for (WebElement element : item_names) {
            String controlKey = Keys.chord(Keys.CONTROL, Keys.ENTER);
            element.findElement(By.tagName("a")).sendKeys(controlKey);
        }
        String parentWindow = Driver.getDriver().getWindowHandle();
        for (String windowHandle : Driver.getDriver().getWindowHandles()) {
            if (!windowHandle.equals(parentWindow)) {
                Driver.getDriver().switchTo().window(windowHandle);
                WebElement add_to_cart = Driver.getDriver().findElement(By.xpath("//a[contains(text(),'Add to cart')]"));
                add_to_cart.click();
                BrowserSleep.wait(2);
                Driver.getDriver().switchTo().alert().accept();
                BrowserSleep.wait(2);
                Driver.getDriver().close(); //closing child window
                Driver.getDriver().switchTo().window(parentWindow); //cntrl to parent window
            }
        }
    }

}
