package org.foden.pages;
import org.foden.enums.MainMenu;
import org.foden.enums.SubMenu;
import org.foden.utils.DynamicXpathUtils;
import org.openqa.selenium.By;

public final class DashboardPage extends BasePage{

    private final By drpdwnProfile = By.xpath("//div[@class='aiz-topbar-item']");
    private final By linkLogout = By.xpath("//span[text()='Logout']");
    private final String commonMainMenu = "//span[normalize-space()='%s']";
    private final String commonSubMenu = "//span[normalize-space()='%s']";

    public DashboardPage() {
    }

    public DashboardPage clickUserProfile(){
//        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(dropdown_profile)); //old-fashioned way
//        wait.until(d->d.findElement(drpdwnProfile).isDisplayed());
        clickElement(drpdwnProfile);
        return this;
    }

    public LoginPage clickLogout(){
        clickElement(linkLogout);
        return new LoginPage();
    }

    public DashboardPage goToMainMenu(MainMenu mainMenuOption){

        String mainMenu = DynamicXpathUtils.getXpath(commonMainMenu, mainMenuOption.getDescription());
        By itemMainMenu = By.xpath(mainMenu);
        clickElement(itemMainMenu);
        return this;
    }

    public void goToSubMenu(SubMenu subMenuOption){
        String subMenu = DynamicXpathUtils.getXpath(commonSubMenu, subMenuOption.getDescription());
        By itemSubMenu = By.xpath(subMenu);
        clickElement(itemSubMenu);
    }
}
