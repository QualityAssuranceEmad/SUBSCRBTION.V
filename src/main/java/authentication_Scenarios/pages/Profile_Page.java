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
    @FindBy(xpath = " //input[contains(@formcontrolname,'address')]")
    private WebElement clickOnEditAddress;
    @FindBy(xpath = "//span[@class='p-button-label ng-star-inserted'][contains(.,'Save Profile')]")
    private WebElement clickOnSaveProfile;
    @FindBy(xpath = "//span[@class='p-button-label ng-star-inserted'][contains(.,'Cancel')]")
    private WebElement clickOnCancle;
    @FindBy(xpath = "//div[contains(@class, 'p-toast-detail') and text()='Profile Updated Successfully']")
    private WebElement assertSuccessMessage;
    //First name required message
    @FindBy(xpath = "//div[contains(@class,'text-red-500 text-xs mt-1 ng-star-inserted') and text()=' First name is required. ']")
    private WebElement assertFirstNameRequiredMessage;
    @FindBy(xpath = "//div[contains(@class,'p-toast-detail') and text()='Invalid First Name']")
    private WebElement assertInvalidFistNameMessage;
    @FindBy(xpath = "//div[contains(@class,'p-toast-detail') and text()='Invalid First Name']")
    private WebElement assertInvalidFistNameTooShortMessage;
    @FindBy(xpath = "//div[contains(@class,'p-toast-detail') and text()='Please enter a valid name without leading, trailing, or middle spaces.']")
    private WebElement assertInvalidFistNameSpacesMessage;
    //Last name required message
    @FindBy(xpath = "//div[contains(@class,'text-red-500 text-xs mt-1 ng-star-inserted') and text()=' Last name is required. ']")
    private WebElement assertLastNameRequiredMessage;
    @FindBy(xpath = "//div[contains(@class,'p-toast-detail') and text()='Invalid Last Name']")
    private WebElement assertInvalidLastNameMessage;
    @FindBy(xpath = "//div[contains(@class,'p-toast-detail') and text()='Invalid Last Name']")
    private WebElement assertInvalidLastNameTooLongMessage;
    @FindBy(xpath = "//div[contains(@class,'p-toast-detail') and text()='Please enter a valid name without leading, trailing, or middle spaces.']")
    private WebElement assertInvalidLastNameSpaceMessage;
    //Job title required message
    @FindBy(xpath = "//div[contains(@class,'p-toast-detail') and text()='Invalid Job Title']")
    private WebElement assertInvalidJobTitleMessage;
    //Institution required message
    @FindBy(xpath = "//div[contains(@class,'p-toast-detail') and text()='Invalid City']")
    private WebElement assertInvalidCityMessage;
    //governorate required message
    @FindBy(xpath = "//div[contains(@class,'p-toast-detail') and text()='Invalid Governorate']")
    private WebElement assertInvalidGovernorateMessage;
    //Nationality required message
    @FindBy(xpath = "//div[contains(@class,'p-toast-detail') and text()='Invalid Nationality']")
    private WebElement assertInvalidNationalityMessage;
    //Address required message
    @FindBy(xpath = "//div[contains(@class,'p-toast-detail') and text()='Invalid Address']")
    private WebElement assertInvalidAddressMessage;
    //Postal code required message
    @FindBy(xpath = "//div[contains(@class,'p-toast-detail') and text()='Invalid Postal Code']")
    private WebElement assertInvalidPostalCodeMessage;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public void clickEditProfileButton()
    {
        wait.until(ExpectedConditions.elementToBeClickable(clickOnEditProfile));
        clickOnButton(clickOnEditProfile);

    }
    public void EditProfile(String firstName, String lastName, String jobTitle, String institution,
                            String BarthOfData,String genderToSelect,String country, String city, String governorate,
                            String nationality,  String postal,String address) throws InterruptedException {

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
        WebElement optionToClick = driver.findElement(By.xpath("//li[@role='option' and @aria-label='"+genderToSelect+"' and contains(@class, 'p-select-option')]"));
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
        clearText(clickOnEditAddress);
        setValueOnField(clickOnEditAddress, address);
        clickOnButton(clickOnSaveProfile);

    }
    public void EditProfileMandatoryFields(String firstName, String lastName, String jobTitle, String institution,
                            String country) throws InterruptedException {

        clearText(clickOnEditFirstName);
        setValueOnField(clickOnEditFirstName, firstName);
        clearText(clickOnEditLastName);
        setValueOnField(clickOnEditLastName, lastName);
        clearText(clickOnEditJopTitle);
        setValueOnField(clickOnEditJopTitle, jobTitle);
        clearText(clickOnEditInstitution);
        setValueOnField(clickOnEditInstitution, institution);
        clickOnButton(clickOnCountryDropDown);
        setValueOnField(clickOnSearchCountry, country);
        // 5. Wait for the search result for "South Korea" to appear in the list
        WebElement countryResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@role='option'][contains(.,'"+country+"')]"))); // Adjust the XPath to specifically target the "South Korea" result. Inspect the HTML of the search results.
        // 6. Click on the "South Korea" search result
        countryResult.click();
        clickOnButton(clickOnSaveProfile);

    }
    public void clickCancleProfile() {
        wait.until(ExpectedConditions.elementToBeClickable(clickOnCancle));
        clickOnButton(clickOnCancle);
    }
    public void assertSuccessfullMessage() {
        // Wait for the success message to be visible

        wait.until(ExpectedConditions.visibilityOf(assertSuccessMessage));
        Assert.assertTrue("Success message is not displayed", assertSuccessMessage.isDisplayed());
    }
    //First Name Assertions////////////////////////////////////////////////////////////
    public void assertRequiredFirstNameMessage() throws InterruptedException {

        clickOnEditFirstName.sendKeys(Keys.CONTROL + "a");
        clickOnEditFirstName.sendKeys(Keys.DELETE);
        clickOnEditLastName.click();
        wait.until(ExpectedConditions.visibilityOf(assertFirstNameRequiredMessage));
        Assert.assertTrue("Success message is not displayed",assertFirstNameRequiredMessage.isDisplayed());
    }
    public void assertInvalidFirstNameMessage(String FN) throws InterruptedException {
        clearText(clickOnEditFirstName);
        setValueOnField(clickOnEditFirstName, FN);
        clickOnButton(clickOnSaveProfile);
        wait.until(ExpectedConditions.visibilityOf(assertInvalidFistNameMessage));
        Assert.assertTrue("Success message is not displayed",assertInvalidFistNameMessage.isDisplayed());

    }
    public void assertInvalidFistNameTooShortMessage(String FN) {
        clearText(clickOnEditFirstName);
        setValueOnField(clickOnEditFirstName, FN);
        clickOnButton(clickOnSaveProfile);
        wait.until(ExpectedConditions.visibilityOf(assertInvalidFistNameTooShortMessage));
        Assert.assertTrue("Success message is not displayed",assertInvalidFistNameTooShortMessage.isDisplayed());

    }
    public void assertInvalidFistNameTooLongMessage(String FN) {
        clearText(clickOnEditFirstName);
        setValueOnField(clickOnEditFirstName, FN);
        clickOnButton(clickOnSaveProfile);
        wait.until(ExpectedConditions.visibilityOf(assertInvalidFistNameMessage));
        Assert.assertTrue("Success message is not displayed",assertInvalidFistNameMessage.isDisplayed());

    }
    public void assertInvalidFistNameSpacesMessage(String FN) {
        clearText(clickOnEditFirstName);
        setValueOnField(clickOnEditFirstName, FN);
        clickOnButton(clickOnSaveProfile);
        wait.until(ExpectedConditions.visibilityOf(assertInvalidFistNameSpacesMessage));
        Assert.assertTrue("Success message is not displayed", assertInvalidFistNameSpacesMessage.isDisplayed());
    }
        //Last Name Assertions///////////////////////////////////////////////////////////////
    public void assertLastNameRequiredMessage() {

        clickOnEditLastName.sendKeys(Keys.CONTROL + "a");
        clickOnEditLastName.sendKeys(Keys.DELETE);
        clickOnEditFirstName.click();
        wait.until(ExpectedConditions.visibilityOf(assertLastNameRequiredMessage));
        Assert.assertTrue("Success message is not displayed",assertLastNameRequiredMessage.isDisplayed());

    }
    public void assertInvalidLastNameMessage(String LN) {

        clearText(clickOnEditLastName);
        setValueOnField(clickOnEditLastName, LN);
        clickOnButton(clickOnSaveProfile);
        wait.until(ExpectedConditions.visibilityOf(assertInvalidLastNameMessage));
        Assert.assertTrue("Success message is not displayed",assertInvalidLastNameMessage.isDisplayed());


    }
    public void assertInvaliLastNameTooShortMessage(String Ln)
    {
        clearText(clickOnEditLastName);
        setValueOnField(clickOnEditLastName, Ln);
        clickOnButton(clickOnSaveProfile);
        wait.until(ExpectedConditions.visibilityOf(assertInvalidLastNameMessage));
        Assert.assertTrue("Success message is not displayed",assertInvalidLastNameMessage.isDisplayed());
    }
    public void assertInvalidLastNameTooLongMessage(String LN) {
        clearText(clickOnEditLastName);
        setValueOnField(clickOnEditLastName, LN);
        clickOnButton(clickOnSaveProfile);
        wait.until(ExpectedConditions.visibilityOf(assertInvalidLastNameTooLongMessage));
        Assert.assertTrue("Success message is not displayed",assertInvalidLastNameTooLongMessage.isDisplayed());

    }
    public void assertInvalidLastNameSpacesMessage(String LN) {
        clearText(clickOnEditLastName);
        setValueOnField(clickOnEditLastName, LN);
        clickOnButton(clickOnSaveProfile);
        wait.until(ExpectedConditions.visibilityOf(assertInvalidLastNameSpaceMessage));
        Assert.assertTrue("Success message is not displayed",assertInvalidLastNameSpaceMessage.isDisplayed());

    }

    //Job Title Assertions///////////////////////////////////////////////////////////////
    public void assertInvalidJobTitleMessage() {
        wait.until(ExpectedConditions.visibilityOf(assertInvalidJobTitleMessage));
        Assert.assertTrue("Success message is not displayed",assertInvalidJobTitleMessage.isDisplayed());

    }
    //Institution Assertions///////////////////////////////////////////////////////////////
    public void assertInvalidInstitutionMessage() {
        wait.until(ExpectedConditions.visibilityOf(assertInvalidCityMessage));
        Assert.assertTrue("Success message is not displayed",assertInvalidCityMessage.isDisplayed());

    }
    // city Assertion/////////////////////////////////////////////////////////////
    public void assertInvalidCityMessage(String InvalidCity) {

        clearText(clickOnEditCity);
        setValueOnField(clickOnEditCity, InvalidCity);
        clickOnButton(clickOnSaveProfile);
        wait.until(ExpectedConditions.visibilityOf(assertInvalidCityMessage));
        Assert.assertTrue("Success message is not displayed", assertInvalidCityMessage.isDisplayed());
    }
    //Governorate Assertions///////////////////////////////////////////////////////////////
    public void assertInvalidGovernorateMessage(String InvalidGovernorate) {
        clearText(clickOnEditGovernorate);
        setValueOnField(clickOnEditGovernorate, InvalidGovernorate);
        clickOnButton(clickOnSaveProfile);
        wait.until(ExpectedConditions.visibilityOf(assertInvalidGovernorateMessage));
        Assert.assertTrue("Success message is not displayed",assertInvalidGovernorateMessage.isDisplayed());

    }
    //Nationality Assertion///////////////////////////////////////////////////////////////
    public void assertInvalidNationalityMessage(String invalidNationality)
    {

        clearText(clickOnEditNationality);
        setValueOnField(clickOnEditNationality,invalidNationality);
        clickOnButton(clickOnSaveProfile);
        wait.until(ExpectedConditions.visibilityOf(assertInvalidNationalityMessage));
        Assert.assertTrue("Success message is not displayed",assertInvalidNationalityMessage.isDisplayed());
    }
    //Address Assertion///////////////////////////////////////////////////////////////
    public void assertInvalidAddressMessage(String address)
    {

        clearText(clickOnEditAddress);
        setValueOnField(clickOnEditAddress,address);
        clickOnButton(clickOnSaveProfile);
        wait.until(ExpectedConditions.visibilityOf(assertInvalidAddressMessage));
        Assert.assertTrue("Success message is not displayed",assertInvalidAddressMessage.isDisplayed());

    }
    //postal code Assertions///////////////////////////////////////////////////////////////
    public void assertInvalidPostalCode(String Postal)
    {

        clearText(clickOnEditPostalCode);
        setValueOnField(clickOnEditPostalCode,Postal);
        clickOnButton(clickOnSaveProfile);
        wait.until(ExpectedConditions.visibilityOf(assertInvalidPostalCodeMessage));
        Assert.assertTrue("Success message is not displayed",assertInvalidPostalCodeMessage.isDisplayed());

    }

}
