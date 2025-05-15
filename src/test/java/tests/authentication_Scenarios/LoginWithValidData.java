package tests.authentication_Scenarios;

import authentication_Scenarios.pages.Login_Page;
import data.JsonDataReaderForLogin;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.io.IOException;

import static io.qameta.allure.SeverityLevel.CRITICAL;

public class Login_With_Valid_Data extends BaseTest {
    Login_Page loginObject;

    @Test
    @Description("This test attempts to log into the website using a login and a password. Fails if any error happens.\n\nNote that this test does not test 2-Factor Authentication.")
    @Severity(CRITICAL)
    @Owner("Emad Maher")
    @Link(name = "Website", url = "http://subscription.advintic.com:6691/plans")
    @Issue("login-001")
    @Epic("Login Positive Scenario")
    @Feature("Essential features")
    @Story("Authentication")
    public void loginToThePlatform() throws IOException, ParseException, InterruptedException {
        loginObject = new Login_Page(driver);
        JsonDataReaderForLogin jsonDataReaderForLogin = new JsonDataReaderForLogin();
        jsonDataReaderForLogin.JsonReader();
        //  Thread.sleep(4000);
        loginObject.loginToMyAccount(jsonDataReaderForLogin.email, jsonDataReaderForLogin.password);
        loginObject.AssertHomePAge();
    }
}
