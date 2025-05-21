package tests.authentication_Scenarios;

import authentication_Scenarios.pages.Dashboard_Page;
import authentication_Scenarios.pages.Login_Page;
import data.JsonDataReaderForLogin;
import jdk.jfr.Description;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;
import java.io.IOException;
public class LoginWithValidData extends BaseTest {
    Login_Page loginObject;
Dashboard_Page dashboardObject;
    @Test
    @Description("This test attempts to log into the website using a login and a password. Fails if any error happens.\n\nNote that this test does not test 2-Factor Authentication.")

    public void loginToThePlatform() throws IOException, ParseException, InterruptedException {
        loginObject = new Login_Page(driver);
        JsonDataReaderForLogin jsonDataReaderForLogin = new JsonDataReaderForLogin();
        jsonDataReaderForLogin.JsonReader();
        //  Thread.sleep(4000);
        loginObject.loginToMyAccount(jsonDataReaderForLogin.email, jsonDataReaderForLogin.password);
        loginObject.AssertHomePAge();
        dashboardObject = new Dashboard_Page(driver);
        dashboardObject.clickLogoutButton();
    }
}
