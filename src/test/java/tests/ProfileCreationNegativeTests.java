package tests;

import authentication_Scenarios.pages.Dashboard_Page;
import authentication_Scenarios.pages.Login_Page;
import authentication_Scenarios.pages.Profile_Page;
import data.JsonDataReaderForLogin;
import data.JsonDataReaderForProfile;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.json.simple.parser.ParseException;
//import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

import java.io.IOException;
public class ProfileCreationNegativeTests extends BaseTest{

    Login_Page loginObject;
    Dashboard_Page dashboardObject;
    Profile_Page profileObject;
    @Epic("Profile Management")
    @Feature("Profile Creation - Negative Tests")
    //@DisplayName("Successful Login Test")
    @Description("This test verifies that a user can successfully log in with valid credentials.")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 0, description = "Test Case 0: Login to the platform")
    public void loginToThePlatform() throws IOException, ParseException, InterruptedException {
        loginObject = new Login_Page(driver);
        dashboardObject = new Dashboard_Page(driver);
        JsonDataReaderForLogin jsonDataReaderForLogin = new JsonDataReaderForLogin();
        jsonDataReaderForLogin.JsonReader();
        loginObject.loginToMyAccount(jsonDataReaderForLogin.email, jsonDataReaderForLogin.password);
       dashboardObject.clickOnProfile();



    }


    @Test(priority = 1, description = "Test Case 1: Edit Profile with Empty First Name")
    public void testEditProfileWithEmptyFirstName() throws InterruptedException, IOException, ParseException {
        profileObject = new Profile_Page(driver);
        profileObject.clickEditProfileButton();
        profileObject.assertRequiredFirstNameMessage();

    }
/*@Test(priority = 2, description = "Test Case 2: Edit Profile with Invalid First Name")
@Severity(SeverityLevel.NORMAL)
@Description("Verify error message when editing profile with an invalid first name.")
@Story("Edit Profile - First Name Validation")
public void testEditProfileWithInvalidFirstName() throws InterruptedException, IOException, ParseException {
    profileObject = new Profile_Page(driver);
    profileObject.clickEditProfileButton();
    JsonDataReaderForProfile jsonDataReaderForProfile = new JsonDataReaderForProfile();
    jsonDataReaderForProfile.JsonReader();
    profileObject.assertInvalidFirstNameMessage(jsonDataReaderForProfile.InvalidFN);
}*/
/*
    @Test(priority = 3, description = "Test Case 3: Edit Profile with Short First Name")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify error message when editing profile with a first name that is too short.")
    @Story("Edit Profile - First Name Validation")
    public void testEditProfileWithShortFirstName() throws InterruptedException, IOException, ParseException {
        profileObject = new Profile_Page(driver);
        JsonDataReaderForProfile jsonDataReaderForProfile = new JsonDataReaderForProfile();
        jsonDataReaderForProfile.JsonReader();
        profileObject.assertInvalidFistNameTooShortMessage(jsonDataReaderForProfile.ShortFN);
    }

    @Test(priority = 4, description = "Test Case 4: Edit Profile with Long First Name")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify error message when editing profile with a first name that is too long.")
    @Story("Edit Profile - First Name Validation")
    public void testEditProfileWithLongFirstName() throws InterruptedException, IOException, ParseException {
        profileObject = new Profile_Page(driver);
        JsonDataReaderForProfile jsonDataReaderForProfile = new JsonDataReaderForProfile();
        jsonDataReaderForProfile.JsonReader();
        profileObject.assertInvalidFistNameTooLongMessage(jsonDataReaderForProfile.LongFN);
    }

    @Test(priority = 5, description = "Test Case 5: Edit Profile with spaces in First  Name")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify error message when editing profile with spaces in the first name.")
    @Story("Edit Profile - First Name Validation")
    public void testEditProfileWithSpacesInFirstName() throws InterruptedException, IOException, ParseException {
        profileObject = new Profile_Page(driver);
        JsonDataReaderForProfile jsonDataReaderForProfile = new JsonDataReaderForProfile();
        jsonDataReaderForProfile.JsonReader();
        profileObject.assertInvalidFistNameSpacesMessage(jsonDataReaderForProfile.spacesFN);
        profileObject.clickCancleProfile();
    }
    //error not appear
   *//* @Test(priority = 6, description = "Test Case 6: Edit Profile with Empty  Last Name")
    public void testEditProfileWithEmptyLastName() throws InterruptedException, IOException, ParseException {

        profileObject = new Profile_Page(driver);
        profileObject.clickEditProfileButton();
        profileObject.assertLastNameRequiredMessage();
    }*//*
    @Test(priority = 7, description = "Test Case 7: Edit Profile with Invalid Last Name")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify error message when editing profile with an invalid last name.")
    @Story("Edit Profile - Last Name Validation")
    public void testEditProfileWithInvalidLastName() throws InterruptedException, IOException, ParseException {
        profileObject = new Profile_Page(driver);
        profileObject.clickEditProfileButton();
        JsonDataReaderForProfile jsonDataReaderForProfile = new JsonDataReaderForProfile();
        jsonDataReaderForProfile.JsonReader();
        profileObject.assertInvalidLastNameMessage(jsonDataReaderForProfile.InvalidLN);
    }

    @Test(priority = 8, description = "Test Case 8: Edit Profile with Short Last Name")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify error message when editing profile with a last name that is too short.")
    @Story("Edit Profile - Last Name Validation")
    public void testEditProfileWithShortLastName() throws InterruptedException, IOException, ParseException {
        profileObject = new Profile_Page(driver);
        JsonDataReaderForProfile jsonDataReaderForProfile = new JsonDataReaderForProfile();
        jsonDataReaderForProfile.JsonReader();
        profileObject.assertInvaliLastNameTooShortMessage(jsonDataReaderForProfile.ShortLN);
    }

    @Test(priority = 9, description = "Test Case 9: Edit Profile with Long Last Name")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify error message when editing profile with a last name that is too long.")
    @Story("Edit Profile - Last Name Validation")
    public void testEditProfileWithLongLastName() throws InterruptedException, IOException, ParseException {
        profileObject = new Profile_Page(driver);
        JsonDataReaderForProfile jsonDataReaderForProfile = new JsonDataReaderForProfile();
        jsonDataReaderForProfile.JsonReader();
        profileObject.assertInvalidLastNameTooLongMessage(jsonDataReaderForProfile.LongLN);
    }

    @Test(priority = 10, description = "Test Case 10: Edit Profile with spaces in Last Name")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify error message when editing profile with spaces in the last name.")
    @Story("Edit Profile - Last Name Validation")
    public void testEditProfileWithSpacesInLastName() throws InterruptedException, IOException, ParseException {
        profileObject = new Profile_Page(driver);
        JsonDataReaderForProfile jsonDataReaderForProfile = new JsonDataReaderForProfile();
        jsonDataReaderForProfile.JsonReader();
        profileObject.assertInvalidLastNameSpacesMessage(jsonDataReaderForProfile.spacesLN);
        Thread.sleep(2000);
        profileObject.clickCancleProfile();
    }

    @Test(priority = 11, description = "Test Case 11: Edit Profile invalid city")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify error message when editing profile with an invalid city.")
    @Story("Edit Profile - Location Validation")
    public void testEditProfileWithInvalidCity() throws InterruptedException, IOException, ParseException {
        profileObject = new Profile_Page(driver);
        profileObject.clickEditProfileButton();
        JsonDataReaderForProfile jsonDataReaderForProfile = new JsonDataReaderForProfile();
        jsonDataReaderForProfile.JsonReader();
        profileObject.assertInvalidCityMessage(jsonDataReaderForProfile.invalidCity);
        profileObject.clickCancleProfile();
    }

    @Test(priority = 12, description = "Test Case 12: Edit Profile invalid governorate")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify error message when editing profile with an invalid governorate.")
    @Story("Edit Profile - Location Validation")
    public void testEditProfileWithInvalidGovernorate() throws InterruptedException, IOException, ParseException {
        profileObject = new Profile_Page(driver);
        profileObject.clickEditProfileButton();
        JsonDataReaderForProfile jsonDataReaderForProfile = new JsonDataReaderForProfile();
        jsonDataReaderForProfile.JsonReader();
        profileObject.assertInvalidGovernorateMessage(jsonDataReaderForProfile.invalidGovernorate);
        profileObject.clickCancleProfile();
    }

    @Test(priority = 13, description = "Test Case 13: Edit Profile invlidNationality")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify error message when editing profile with an invalid nationality.")
    @Story("Edit Profile - Nationality Validation")
    public void testEditProfileWithInvlidNationality() throws InterruptedException, IOException, ParseException {
        profileObject = new Profile_Page(driver);
        profileObject.clickEditProfileButton();
        JsonDataReaderForProfile jsonDataReaderForProfile = new JsonDataReaderForProfile();
        jsonDataReaderForProfile.JsonReader();
        profileObject.assertInvalidNationalityMessage(jsonDataReaderForProfile.invalidNationality);
        profileObject.clickCancleProfile();
    }

    @Test(priority = 14, description = "Test Case 14: Edit Profile with Invalid Address")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify error message when editing profile with an invalid address.")
    @Story("Edit Profile - Address Validation")
    public void testEditProfileWithInvalidAddress() throws InterruptedException, IOException, ParseException {
        profileObject = new Profile_Page(driver);
        profileObject.clickEditProfileButton();
        JsonDataReaderForProfile jsonDataReaderForProfile = new JsonDataReaderForProfile();
        jsonDataReaderForProfile.JsonReader();
        profileObject.assertInvalidAddressMessage(jsonDataReaderForProfile.invalidAddress);
        profileObject.clickCancleProfile();
    }

    @Test(priority = 15, description = "Test Case 15: Edit Profile with Invalid Postal Code")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify error message when editing profile with an invalid postal code.")
    @Story("Edit Profile - Postal Code Validation")
    public void testEditProfileWithInvalidPostalCode() throws InterruptedException, IOException, ParseException {
        profileObject = new Profile_Page(driver);
        profileObject.clickEditProfileButton();
        JsonDataReaderForProfile jsonDataReaderForProfile = new JsonDataReaderForProfile();
        jsonDataReaderForProfile.JsonReader();
        profileObject.assertInvalidPostalCode(jsonDataReaderForProfile.invalidPostal);
        profileObject.clickCancleProfile();
    }*/
}