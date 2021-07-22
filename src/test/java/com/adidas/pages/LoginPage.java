package com.adidas.pages;

import com.adidas.utilities.Driver;
import com.adidas.utilities.DriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "login2")
    private WebElement login_btn;

    @FindBy(id = "loginusername")
    private WebElement username_input;

    @FindBy(id = "loginpassword")
    private WebElement password_input;

    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    private WebElement final_login_btn;

    @FindBy(id = "nameofuser")
    private WebElement name_of_user;

    public void click_on_login(){
        login_btn.click();
    }
    public void enter_username(String username){
        username_input.sendKeys(username);
    }
    public void enter_password(String password){
        password_input.sendKeys(password);
    }
    public void click_on_final_login_btn(){
        final_login_btn.click();
    }
    public String verify_user_access(){
        DriverWait.elementToBeVisible(Driver.getDriver(),name_of_user);
        return name_of_user.getText();
    }
}
