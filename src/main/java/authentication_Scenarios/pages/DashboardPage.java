package authentication_Scenarios.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {
    public DashboardPage(WebDriver driver) {
        super(driver);
    }
@FindBy(xpath = "//span[@class='pi pi-sign-out p-button-icon ng-star-inserted']")
    WebElement LogoutButton;

    public void clickLogoutButton() {
        clickOnButton(LogoutButton);
    }

    // Add any specific elements or methods related to the dashboard page here
    // For example:
    // @FindBy(xpath = "//h1[contains(text(),'Dashboard')]")
    // private WebElement dashboardHeader;

    // public void verifyDashboardHeader() {
    //     Assert.assertTrue(dashboardHeader.isDisplayed(), "Dashboard header is not displayed");
    // }
}
