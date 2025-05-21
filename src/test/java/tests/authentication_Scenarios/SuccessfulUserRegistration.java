package tests.authentication_Scenarios;

import authentication_Scenarios.pages.Dashboard_Page;
import authentication_Scenarios.pages.Login_Page;
import authentication_Scenarios.pages.SignUp_Page;
import data.JsonDataReaderForSignUp;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.io.IOException;

public class SuccessfulUserRegistration extends BaseTest {
    SignUp_Page registerObject;
    Login_Page loginObject;
    Dashboard_Page dashboardObject;
    JsonDataReaderForSignUp jsonReader = new JsonDataReaderForSignUp();

    @Test(priority = 1)
    public void SignUpAndCheckProfile() throws IOException, ParseException, InterruptedException {
        loginObject = new Login_Page(driver);
        registerObject = new SignUp_Page(driver);
        dashboardObject = new Dashboard_Page(driver);
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
