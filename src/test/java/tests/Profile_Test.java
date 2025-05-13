package tests;

import authentication_Scenarios.pages.Dashboard_Page;
import authentication_Scenarios.pages.Login_Page;
import authentication_Scenarios.pages.Profile_Page;
import data.JsonDataReaderForLogin;
import data.JsonDataReaderForProfile;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class Profile_Test extends BaseTest {
    Login_Page loginObject;
    Dashboard_Page dashboardObject;
    Profile_Page profileObject;

    @Test
    public void testEditProfile() throws InterruptedException, IOException, ParseException {
        loginObject = new Login_Page(driver);
        dashboardObject = new Dashboard_Page(driver);
        profileObject = new Profile_Page(driver);
        JsonDataReaderForLogin jsonDataReaderForLogin = new JsonDataReaderForLogin();
        jsonDataReaderForLogin.JsonReader();
        loginObject.loginToMyAccount(jsonDataReaderForLogin.email, jsonDataReaderForLogin.password);
        dashboardObject.clickOnProfile();
        Thread.sleep(2000);
        JsonDataReaderForProfile jsonDataReaderForProfile = new JsonDataReaderForProfile();
        jsonDataReaderForProfile.JsonReader();
        profileObject.EditProfile(jsonDataReaderForProfile.Fn, jsonDataReaderForProfile.Ln, jsonDataReaderForProfile.job,
                jsonDataReaderForProfile.institution, jsonDataReaderForProfile.birthOfDate,
                jsonDataReaderForProfile.gender,jsonDataReaderForProfile.country, jsonDataReaderForProfile.city,
                jsonDataReaderForProfile.governorate, jsonDataReaderForProfile.nationality, jsonDataReaderForProfile.postal);

        profileObject.assertSuccessfullMessage();

    }
}
