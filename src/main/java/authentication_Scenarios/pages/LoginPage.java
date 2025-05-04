package authentication_Scenarios.pages;

//import com.subscrption.automation.utlis.ElementActions;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    //Constructor
    public LoginPage(WebDriver driver) {
        super(driver);

    }
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    //locators
    @FindBy(xpath = "//a[contains(.,'Sign up')]")
    private   WebElement SingUpLinck;
    @FindBy(id = "username")
    private   WebElement Email;

    @FindBy(xpath = "//input[@type='password']")
    private   WebElement Password;

    @FindBy(xpath = "//button[contains(.,'Login')]")
    private   WebElement Login_button;
    @FindBy(xpath = "//div[contains(@class,'user-page-head')]")
    private   WebElement Dashboard;
    //Validations on invalid login
    @FindBy(xpath = "//span[contains(@class,'p-message-text ng-star-inserted')]")
    public WebElement InvalidLoginAlert;
    @FindBy(id = "remember")
    public WebElement RememberMeAlert;


    //actions
    public void clickSignUpLinck() {
        wait.until(ExpectedConditions.visibilityOf((WebElement) SingUpLinck));
        clickOnButton(SingUpLinck);

    }


    public void loginToMyAccount(String email, String pass) {
        // Wait for email field to be visible and enter email
      // or whatever timeout you prefer
        wait.until(ExpectedConditions.visibilityOf((WebElement) Email));
        setValueOnField((WebElement) Email, email);
        setValueOnField((WebElement) Password, pass);
        clickOnButton(RememberMeAlert);
        clickOnButton((WebElement) Login_button);
    }
    public void AssertHomePAge()
    {
        // Verify that the current URL contains the expected URL
        String expectedUrl  ="http://subscription.advintic.com:6691/home";
        // Wait for URL to match (explicit wait)
        // 10-second timeout
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String currentUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl , "http://subscription.advintic.com:6691/home" );
        Assert.assertEquals(Dashboard.getText(), "Dashboard");
    }
    public void checkInvalidLogin() {
       String expectedAlert = "Invalid credentials";
        // Wait for the alert to be visible
        wait.until(ExpectedConditions.visibilityOf(InvalidLoginAlert));
        // Verify the alert message
        Assert.assertEquals(InvalidLoginAlert.getText(), expectedAlert);

    }

}









