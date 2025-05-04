package authentication_Scenarios.pages;

import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage extends BasePage {
    public SignUpPage(WebDriver driver) {
        super(driver);

    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    @FindBy(xpath = "//input[@placeholder='First Name']")
    public WebElement FirstName;
    @FindBy(xpath = "//input[@placeholder='Family Name']")
    public WebElement LastName;
    @FindBy(xpath = "//input[@placeholder='Phone Number']")
    public WebElement Phone;
    @FindBy(xpath = "//input[@placeholder='Email']")
    public WebElement Email;
    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement Password;
    @FindBy(xpath = "//input[@placeholder='Confirm Password']")
    private WebElement ConfirmPassword;
    @FindBy(xpath = "//input[contains(@id, 'terms')]")
    private WebElement ClickCheckBox;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement ClickSignUp;
// Validation on fields
    @FindBy(xpath = "//div[@class='flex gap-3 mt-4']//div[1]//validation-message[1]//div[1]")
    public WebElement FirstNameValidation;
    @FindBy(xpath = "//div[2]//validation-message[1]//div[1]")
    public WebElement LastNameValidation;
    @FindBy(xpath = "//div[normalize-space()='Invalid Phone Number']")
    public WebElement PhoneValidation;
    @FindBy(xpath = "//div[contains(text(),'Please enter a valid email address.')]")
    public WebElement EmailValidation;
    @FindBy(xpath = "//div[@class='text-red-500 text-xs mt-1 ng-star-inserted'][contains(.,'Password must include uppercase, lowercase, number, and special character.')]")
    public WebElement PasswordValidation;
    // Validation on fields Data Exit
    @FindBy(xpath = "//div[contains(@class, 'p-toast-detail') and text()='The email already exists']")
    public WebElement EmailAlreadyExit;
    @FindBy(xpath = "//div[@class='text-red-500 text-xs mt-1 ng-star-inserted'][contains(.,'This email address already exists.')]")
    public WebElement PhoneAlreadyExit;

    public void signUp(String First_Name, String Last_Name, String Phone_Number, String Email_Address,
                       String Password1, String Confirm_Password) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf((WebElement) FirstName));
        setValueOnField(FirstName, First_Name);
        setValueOnField(LastName, Last_Name);
        setValueOnField(Phone, Phone_Number);
        setValueOnField(Email, Email_Address);
        setValueOnField(Password, Password1);
        setValueOnField(ConfirmPassword, Confirm_Password);
        // Wait until the checkbox is CLICKABLE (visible + enabled), then click it
     //  wait.until(ExpectedConditions.elementToBeClickable((WebElement) ClickCheckBox));
      Thread.sleep(2000);
        clickOnButton(ClickCheckBox);
        clickOnButton(ClickSignUp);
    }
    public void testValidationOnFirstName()
    {
        String expectedFirstNameError = "Only letters and spaces are allowed.";
        Assert.assertEquals(FirstNameValidation.getText(), expectedFirstNameError, "First name validation message mismatch");
    }
    public void testValidationOnLastName()
    {
        String expectedLastNameError = "Only letters and spaces are allowed.";
        Assert.assertEquals(LastNameValidation.getText(), expectedLastNameError, "First name validation message mismatch");
    }
    public void testValidationOnPhone()
    {
        String expectedPhoneError = "Only letters and spaces are allowed.";
        Assert.assertEquals(PhoneValidation.getText(), expectedPhoneError, "Invalid Phone Number");
    }
    public void testValidationOnEmail()
    {
        String expectedEmailError = "Only letters and spaces are allowed.";
        Assert.assertEquals(EmailValidation.getText(), expectedEmailError, "Please enter a valid email address.");
    }
    public void testValidationOnPassword()
    {
        String expectedPasswordError = "Only letters and spaces are allowed.";
        Assert.assertEquals(PasswordValidation.getText(), expectedPasswordError, "Password must include uppercase, lowercase, number, and special character.");
    }

    // validation on exiting data
    public void testValidationOnExitEmail()
    {
        String expectedEmailExitMessage = "This email address already exists.";
        Assert.assertEquals(EmailAlreadyExit.getText(), expectedEmailExitMessage, "Password must include uppercase, lowercase, number, and special character.");
    }
}
