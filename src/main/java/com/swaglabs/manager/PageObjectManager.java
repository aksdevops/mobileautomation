package com.swaglabs.manager;

import com.swaglabs.pages.LoginPage;
import com.swaglabs.pages.ProductDashboardPage;

public class PageObjectManager {

    private LoginPage loginPage;
    
    private ProductDashboardPage dashboardPage;
    
    public LoginPage getloginPage() {
        return (loginPage == null) ? loginPage = new LoginPage() : loginPage;
    }
    
    public ProductDashboardPage getDashboardPage() {
        return (dashboardPage == null) ? dashboardPage = new ProductDashboardPage() : dashboardPage;
    }
}
