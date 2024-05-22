package org.foden.tests;

import io.qameta.allure.*;
import org.foden.listeners.AllureListener;
import org.foden.pages.LoginPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureListener.class})
@Epic("Smoke Tests")
@Feature("Login Tests")
public class LoginTest extends BaseTest{
    private LoginTest(){}

    @Test(priority = 0,description = "User can login and logout successfully with valid credentials")
    @Severity(SeverityLevel.NORMAL)
    @Description("User can login and logout successfully with valid credentials")
    @Story("TA-114")
    public void loginLogoutSuccessfully(){
        LoginPage loginPage = new LoginPage();
        loginPage.enterEmail("admin@example.com").enterPassword("123456").clickLogin()
                .clickUserProfile().clickLogout();
    }

    @Test(priority = 0,description = "User can not login with invalid credentials - Invalid username")
    @Severity(SeverityLevel.NORMAL)
    @Description("User can not login with invalid credential - Invalid username")
    @Story("TA-114")
    public void cannotLoginWithInvalidUsername(){
        LoginPage loginPage = new LoginPage();
        loginPage.enterEmail("admin1@example.com").enterPassword("123456").clickLogin();
        loginPage.verifyUserCannotLogin();
    }

    @Test(priority = 0,description = "User can not login with invalid credentials - Incorrect password")
    @Severity(SeverityLevel.NORMAL)
    @Description("User can not login with invalid credential - Incorrect password")
    @Story("TA-114")
    public void cannotLoginWithInCorrectPassword(){
        LoginPage loginPage = new LoginPage();
        loginPage.enterEmail("admin@example.com").enterPassword("a123456").clickLogin();
        loginPage.verifyUserCannotLogin();
    }

}
