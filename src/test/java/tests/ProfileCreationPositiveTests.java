package tests;

import authentication_Scenarios.pages.Dashboard_Page;
import authentication_Scenarios.pages.Login_Page;
import authentication_Scenarios.pages.Profile_Page;
import data.JsonDataReaderForLogin;
import data.JsonDataReaderForProfile;
import data.JsonDataReaderForProfileMandatoryFIelds;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class Profile_Creation_Tests extends BaseTest {
    Login_Page loginObject;
    Dashboard_Page dashboardObject;
    Profile_Page profileObject;

    @Test(priority = 0, description = "Test Case 0: Login to the platform")
    public void loginToThePlatform() throws IOException, ParseException, InterruptedException {
        loginObject = new Login_Page(driver);
        dashboardObject = new Dashboard_Page(driver);
        JsonDataReaderForLogin jsonDataReaderForLogin = new JsonDataReaderForLogin();
        jsonDataReaderForLogin.JsonReader();
        loginObject.loginToMyAccount(jsonDataReaderForLogin.email, jsonDataReaderForLogin.password);
        dashboardObject.clickOnProfile();
    }
    @Test(priority = 1, description = "Test Case 1: Edit ProfileMandatory")
    public void testProfileCreationWithOnlyMandatoryFields() throws IOException, ParseException, InterruptedException {
        profileObject = new Profile_Page(driver);
        dashboardObject = new Dashboard_Page(driver);
        Thread.sleep(2000);
        profileObject.clickEditProfileButton();
        JsonDataReaderForProfileMandatoryFIelds jsonDataReaderForProfileMandatory = new JsonDataReaderForProfileMandatoryFIelds();
        jsonDataReaderForProfileMandatory.JsonReader();
        profileObject.EditProfileMandatoryFields(jsonDataReaderForProfileMandatory.Fn, jsonDataReaderForProfileMandatory.Ln,
                jsonDataReaderForProfileMandatory.job,
                jsonDataReaderForProfileMandatory.institution,
                jsonDataReaderForProfileMandatory.country);

        profileObject.assertSuccessfullMessage();

    }

    @Test(priority = 2, description = "Test Case 2: Edit Profile")
    public void testEditProfile() throws InterruptedException, IOException, ParseException {
        profileObject = new Profile_Page(driver);
        Thread.sleep(2000);
          profileObject.clickEditProfileButton();
        JsonDataReaderForProfile jsonDataReaderForProfile = new JsonDataReaderForProfile();
        jsonDataReaderForProfile.JsonReader();
        profileObject.EditProfile(jsonDataReaderForProfile.FirstN, jsonDataReaderForProfile.LastN, jsonDataReaderForProfile.job,
                jsonDataReaderForProfile.institution, jsonDataReaderForProfile.birthOfDate,
                jsonDataReaderForProfile.gender, jsonDataReaderForProfile.country, jsonDataReaderForProfile.city,
                jsonDataReaderForProfile.governorate, jsonDataReaderForProfile.nationality,
                jsonDataReaderForProfile.postal,jsonDataReaderForProfile.address);

        profileObject.assertSuccessfullMessage();

    }

    @Test(priority = 3, description = "Test Case 3: Edit Profile with Invalid Postal Code")
    public void testEditProfileWithInvalidPostalCode() throws InterruptedException, IOException, ParseException {

        profileObject = new Profile_Page(driver);
        JsonDataReaderForProfile jsonDataReaderForProfile = new JsonDataReaderForProfile();
        jsonDataReaderForProfile.JsonReader();
        profileObject.clickEditProfileButton();
        profileObject.EditProfile(jsonDataReaderForProfile.FirstN, jsonDataReaderForProfile.LastN, jsonDataReaderForProfile.job,
                jsonDataReaderForProfile.institution, jsonDataReaderForProfile.birthOfDate,
                jsonDataReaderForProfile.gender, jsonDataReaderForProfile.country, jsonDataReaderForProfile.city,
                jsonDataReaderForProfile.governorate, jsonDataReaderForProfile.nationality, jsonDataReaderForProfile.invalidPostal,jsonDataReaderForProfile.address);
        profileObject.assertInvalidPostalCode();
       profileObject.clickCancleProfile();


    }

    @Test(priority = 4, description = "Test Case 4: Edit Profile with Empty First Name")
    public void testEditProfileWithEmptyFirstName() throws InterruptedException, IOException, ParseException {
        profileObject = new Profile_Page(driver);
        profileObject.assertRequiredFirstNameMessage();



    }
    @Test(priority = 5, description = "Test Case 5: Edit Profile with Invalid First Name")
    public void testEditProfileWithInvalidFirstName() throws InterruptedException, IOException, ParseException {
        profileObject = new Profile_Page(driver);
        profileObject.clickEditProfileButton();
        JsonDataReaderForProfile jsonDataReaderForProfile = new JsonDataReaderForProfile();
        jsonDataReaderForProfile.JsonReader();
        profileObject.assertInvalidFirstNameMessage(jsonDataReaderForProfile.InvalidFN);


    }
    @Test(priority = 6, description = "Test Case 6: Edit Profile with Short First Name")
    public void testEditProfileWithShortFirstName() throws InterruptedException, IOException, ParseException {
        profileObject = new Profile_Page(driver);
        JsonDataReaderForProfile jsonDataReaderForProfile = new JsonDataReaderForProfile();
        jsonDataReaderForProfile.JsonReader();
        profileObject.assertInvalidFistNameTooShortMessage(jsonDataReaderForProfile.ShortFN);
    }
@Test(priority = 7, description = "Test Case 7: Edit Profile with Long First Name")
    public void testEditProfileWithLongFirstName() throws InterruptedException, IOException, ParseException {
    profileObject = new Profile_Page(driver);
    JsonDataReaderForProfile jsonDataReaderForProfile = new JsonDataReaderForProfile();
    jsonDataReaderForProfile.JsonReader();
    profileObject.assertInvalidFistNameTooLongMessage(jsonDataReaderForProfile.LongFN);
    }
    @Test(priority = 8, description = "Test Case 8: Edit Profile with spaces in First  Name")
    public void testEditProfileWithSpacesInFirstName() throws InterruptedException, IOException, ParseException {
        profileObject = new Profile_Page(driver);
        JsonDataReaderForProfile jsonDataReaderForProfile = new JsonDataReaderForProfile();
        jsonDataReaderForProfile.JsonReader();
        profileObject.assertInvalidFistNameSpacesMessage(jsonDataReaderForProfile.spacesFN);
        profileObject.clickCancleProfile();
    }
    //error not appear
    @Test(priority = 9, description = "Test Case 9: Edit Profile with Empty  Last Name")
    public void testEditProfileWithEmptyLastName() throws InterruptedException, IOException, ParseException {

        profileObject = new Profile_Page(driver);
        profileObject.clickEditProfileButton();
        profileObject.assertLastNameRequiredMessage();
    }
    @Test(priority = 10, description = "Test Case 10: Edit Profile with Invalid Last Name")
    public void testEditProfileWithInvalidLastName() throws InterruptedException, IOException, ParseException {
        profileObject = new Profile_Page(driver);
        profileObject.clickEditProfileButton();
        JsonDataReaderForProfile jsonDataReaderForProfile = new JsonDataReaderForProfile();
        jsonDataReaderForProfile.JsonReader();
        profileObject.assertInvalidLastNameMessage(jsonDataReaderForProfile.InvalidLN);


    }
    @Test(priority = 11, description = "Test Case 11: Edit Profile with Short Last Name")
    public void testEditProfileWithShortLastName() throws InterruptedException, IOException, ParseException {
        profileObject = new Profile_Page(driver);
        JsonDataReaderForProfile jsonDataReaderForProfile = new JsonDataReaderForProfile();
        jsonDataReaderForProfile.JsonReader();
        profileObject.assertInvaliLastNameTooShortMessage(jsonDataReaderForProfile.ShortLN);
    }
    @Test(priority = 12, description = "Test Case 12: Edit Profile with Long Last Name")
    public void testEditProfileWithLongLastName() throws InterruptedException, IOException, ParseException {
        profileObject = new Profile_Page(driver);
        JsonDataReaderForProfile jsonDataReaderForProfile = new JsonDataReaderForProfile();
        jsonDataReaderForProfile.JsonReader();
        profileObject.assertInvalidLastNameTooLongMessage(jsonDataReaderForProfile.LongLN);
    }
    @Test(priority = 13, description = "Test Case 13: Edit Profile with spaces in Last Name")
    public void testEditProfileWithSpacesInLastName() throws InterruptedException, IOException, ParseException {
        profileObject = new Profile_Page(driver);
        JsonDataReaderForProfile jsonDataReaderForProfile = new JsonDataReaderForProfile();
        jsonDataReaderForProfile.JsonReader();
        profileObject.assertInvalidLastNameSpacesMessage(jsonDataReaderForProfile.spacesLN);

    }
    @Test(priority = 14, description = "Test Case 14: Edit Profile invalid city")
    public void testEditProfileWithInvalidCity() throws InterruptedException, IOException, ParseException {
        profileObject = new Profile_Page(driver);
        profileObject.clickEditProfileButton();
        JsonDataReaderForProfile jsonDataReaderForProfile = new JsonDataReaderForProfile();
        jsonDataReaderForProfile.JsonReader();
        profileObject.assertInvalidCityMessage(jsonDataReaderForProfile.invalidCity);
    }
    @Test(priority = 15, description = "Test Case 15: Edit Profile invalid governorate")
    public void testEditProfileWithInvalidGovernorate() throws InterruptedException, IOException, ParseException {
        profileObject = new Profile_Page(driver);
        profileObject.clickEditProfileButton();
        JsonDataReaderForProfile jsonDataReaderForProfile = new JsonDataReaderForProfile();
        jsonDataReaderForProfile.JsonReader();
        profileObject.assertInvalidGovernorateMessage(jsonDataReaderForProfile.invalidGovernorate);
    }
    @Test(priority = 16, description = "Test Case 16: Edit Profile invlidNationality")
    public void testEditProfileWithInvlidNationality() throws InterruptedException, IOException, ParseException {
        profileObject = new Profile_Page(driver);
        profileObject.clickEditProfileButton();
        JsonDataReaderForProfile jsonDataReaderForProfile = new JsonDataReaderForProfile();
        jsonDataReaderForProfile.JsonReader();
        profileObject.assertInvalidNationalityMessage(jsonDataReaderForProfile.invalidNationality);
    }
@Test(priority = 17, description = "Test Case 17: Edit Profile with Invalid Address")
    public void testEditProfileWithInvalidAddress() throws InterruptedException, IOException, ParseException {
        profileObject = new Profile_Page(driver);
        profileObject.clickEditProfileButton();
        JsonDataReaderForProfile jsonDataReaderForProfile = new JsonDataReaderForProfile();
        jsonDataReaderForProfile.JsonReader();
        profileObject.assertInvalidAddressMessage(jsonDataReaderForProfile.invalidAddress);
    }
}