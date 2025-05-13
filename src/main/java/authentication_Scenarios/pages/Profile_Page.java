package authentication_Scenarios.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Profile_Page extends Base_Page {
    public Profile_Page(WebDriver driver) {
        super(driver);
    }

    // Add locators for the elements on the Profile page
    // For example:
    @FindBy(xpath = "//span[@class='p-button-label ng-star-inserted'][contains(.,'Edit Your Info')]")
    private WebElement clickOnEditProfile;
    @FindBy(xpath = "//input[contains(@formcontrolname,'first_name')]")
    private WebElement clickOnEditFirstName;
    @FindBy(xpath = "//input[contains(@formcontrolname,'last_name')]")
    private WebElement clickOnEditLastName;
    @FindBy(xpath = "//input[contains(@formcontrolname,'job_title')]")
    private WebElement clickOnEditJopTitle;
    @FindBy(xpath = "//input[contains(@formcontrolname,'institution')]")
    private WebElement clickOnEditInstitution;
    @FindBy(xpath = "//input[@role='combobox'][@type='text']")
    private WebElement clickOnBirthDate;
    @FindBy(xpath = "(//div[@class='p-select-dropdown'])[1]")
    private WebElement clickOnDropDownGender;
    @FindBy(xpath = "//li[@role='option'][contains(@id,'0')][contains(.,'\" + genderToSelect + \"')]")
    private WebElement selectFromDropDownGender;
    @FindBy(xpath = "(//div[@class='p-select-dropdown'])[2]")
    private WebElement clickOnCountryDropDown;
    @FindBy(xpath = "//input[contains(@class,'p-inputtext p-component p-select-filter')]")
    private WebElement clickOnSearchCountry;
    @FindBy(xpath = "//input[contains(@formcontrolname,'city')]")
    private WebElement clickOnEditCity;
    @FindBy(xpath = "//input[contains(@formcontrolname,'governorate')]")
    private WebElement clickOnEditGovernorate;
    @FindBy(xpath = "//input[contains(@formcontrolname,'nationality')]")
    private WebElement clickOnEditNationality;
    @FindBy(xpath = "//input[contains(@formcontrolname,'postal_code')]")
    private WebElement clickOnEditPostalCode;
    @FindBy(xpath = "//span[@class='p-button-label ng-star-inserted'][contains(.,'Save Profile')]")
    private WebElement clickOnSaveProfile;
    @FindBy(xpath = "//span[@class='p-button-label ng-star-inserted'][contains(.,'Cancel')]")
    private WebElement clickOnCancle;
    @FindBy(xpath = "//div[contains(@class, 'p-toast-detail') and text()='Profile Updated Successfully']")
    private WebElement assertSuccessMessage;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public void EditProfile(String firstName, String lastName, String jobTitle, String institution,
                            String BarthOfData,String genderToSelect,String country, String city, String governorate,
                            String nationality,  String postal) throws InterruptedException {
        clickOnButton(clickOnEditProfile);
        Thread.sleep(2000);
        clearText(clickOnEditFirstName);
        setValueOnField(clickOnEditFirstName, firstName);
        clearText(clickOnEditLastName);
        setValueOnField(clickOnEditLastName, lastName);
        clearText(clickOnEditJopTitle);
        setValueOnField(clickOnEditJopTitle, jobTitle);
        clearText(clickOnEditInstitution);
        setValueOnField(clickOnEditInstitution, institution);
        clearText(clickOnBirthDate);
        setValueOnField(clickOnBirthDate, BarthOfData);
        Thread.sleep(2000);
        clickOnBirthDate.sendKeys(Keys.ENTER);
        clickOnButton(clickOnDropDownGender);
        WebElement optionToClick = driver.findElement(By.xpath(" //li[@role='option' and @aria-label='"+genderToSelect+"' and contains(@class, 'p-select-option')]"));
        optionToClick.click();
        clickOnButton(clickOnCountryDropDown);
        setValueOnField(clickOnSearchCountry, country);
        // 5. Wait for the search result for "South Korea" to appear in the list
        WebElement southKoreaResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@role='option'][contains(.,'"+country+"')]"))); // Adjust the XPath to specifically target the "South Korea" result. Inspect the HTML of the search results.
        // 6. Click on the "South Korea" search result
        southKoreaResult.click();
        clearText(clickOnEditCity);
        setValueOnField(clickOnEditCity, city);
        clearText(clickOnEditGovernorate);
        setValueOnField(clickOnEditGovernorate, governorate);
        clearText(clickOnEditNationality);
        setValueOnField(clickOnEditNationality,nationality);
        clearText(clickOnEditPostalCode);
        setValueOnField(clickOnEditPostalCode, postal);
        clickOnButton(clickOnSaveProfile);

    }
    public void assertSuccessfullMessage() {
        // Wait for the success message to be visible

        wait.until(ExpectedConditions.visibilityOf(assertSuccessMessage));
        Assert.assertTrue("Success message is not displayed", assertSuccessMessage.isDisplayed());
    }
}
