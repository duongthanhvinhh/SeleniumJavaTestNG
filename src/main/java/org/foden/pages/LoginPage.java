package org.foden.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public final class LoginPage extends BasePage {
    private final By txtboxEmail = By.xpath("//input[@id='email']");
    private final By txtboxPassword = By.xpath("//input[@id='password']");
    private final By btnLogin = By.xpath("//button[normalize-space()='Login']");
    private final By alertLoginFailed = By.xpath("//*[text()='Invalid login credentials']");

    public LoginPage() {
    }

    @Step("Enter email {0}")
    public LoginPage enterEmail(String userName) {
        waitForPageLoaded();
        setText(txtboxEmail, userName);
        return this;
    }

    @Step("Enter password {0}")
    public LoginPage enterPassword(String password) {
        setText(txtboxPassword, password);
        return this;
    }

    @Step("Click login")
    public DashboardPage clickLogin() {
        clickElement(btnLogin);
        return new DashboardPage();
    }

    @Step("Verify user can not login with invalid credentials")
    public void verifyUserCannotLogin() {
        verifyElementVisible(alertLoginFailed);
    }

}
