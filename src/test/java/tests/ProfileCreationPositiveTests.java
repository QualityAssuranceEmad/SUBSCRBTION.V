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

public class ProfileCreationPositiveTests extends BaseTest {
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


}