package com.adidas.step_definitions;

import com.adidas.pages.Cart;
import com.adidas.pages.DashBoardPage;
import com.adidas.pages.LoginPage;

public abstract class BaseClass{
    public Cart cart = new Cart();
    public DashBoardPage dashBoardPage = new DashBoardPage();
    public LoginPage loginPage = new LoginPage();
}
