package tests.userRegistration;

import authentication_Scenarios.pages.DashboardPage;
import authentication_Scenarios.pages.LoginPage;
import authentication_Scenarios.pages.SignUpPage;
import tests.BaseTest;
import data.JsonDataReaderForSignUp;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class SignUpTest extends BaseTest {
    SignUpPage registerObject;
    LoginPage loginObject;
    DashboardPage dashboardObject;
    JsonDataReaderForSignUp jsonReader = new JsonDataReaderForSignUp();

    @Test(priority = 1)
    public void SignUpAndCheckProfile() throws IOException, ParseException, InterruptedException {
        loginObject = new LoginPage(driver);
        registerObject = new SignUpPage(driver);
        dashboardObject = new DashboardPage(driver);
        jsonReader.JsonReader();
        loginObject.clickSignUpLinck();
        registerObject.signUp(jsonReader.firstName, jsonReader.lastName, jsonReader.mobile, jsonReader.email,
                jsonReader.password, jsonReader.confirmPass);
    }

    @Test(priority = 2, dependsOnMethods = "SignUpAndCheckProfile")
    public void testLogoutAfterSignUp() throws InterruptedException {
        Thread.sleep(2000); // Only if absolutely necessary (prefer explicit waits)
        dashboardObject.clickLogoutButton();
    }

    @Test(priority = 3, dependsOnMethods = "testLogoutAfterSignUp")
    public void testLoginWithNewAccount() {
        loginObject.loginToMyAccount(jsonReader.email, jsonReader.password);
        loginObject.AssertHomePAge();
    }

}


