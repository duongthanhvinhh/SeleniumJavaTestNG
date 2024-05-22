package org.foden.tests;

import io.qameta.allure.*;
import org.foden.enums.MainMenu;
import org.foden.enums.SubMenu;
import org.foden.listeners.AllureListener;
import org.foden.pages.DashboardPage;
import org.foden.pages.LoginPage;
import org.foden.pages.ProductsPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.HashMap;

@Listeners({AllureListener.class})
@Epic("Smoke Tests")
@Feature("Products Tests")
public class ProductsTest extends BaseTest{
    private ProductsTest(){}

    @Test(priority = 0,description = "Verify user can add new product")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify user can add new product")
    @Story("TA-115")
    public void addNewProduct(){
        LoginPage loginPage = new LoginPage();
        loginPage.enterEmail("admin@example.com").enterPassword("123456").clickLogin();
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.goToMainMenu(MainMenu.PRODUCTS).goToSubMenu(SubMenu.ADDNEWPRODUCT);
        ProductsPage productsPage = new ProductsPage();
        productsPage.addNewProduct("Cert", "Ford", "100", "15", "2", "Tags", "BarcodeTest", "Description Test","100","10", new HashMap<String, Boolean>() {{ put("Women Clothing & Fashion", true); put("Women Watch", false);}});
        productsPage.verifyAddNewProductSuccessfully();
    }

}
