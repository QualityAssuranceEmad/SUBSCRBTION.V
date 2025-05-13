package tests.authentication_Scenarios;

import authentication_Scenarios.pages.Login_Page;
import data.LoadProperties;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.io.IOException;

public class LoginWithInvalidData extends BaseTest {
    Login_Page loginObject;
    String invalidEmail= LoadProperties.userData2.getProperty("invalidEmail");
    String pass= LoadProperties.userData2.getProperty("password");
    String em= LoadProperties.userData2.getProperty("Email");
    String invalidPass= LoadProperties.userData2.getProperty("invalidPassword");

    @Test(priority = 1, description = "Login to the website using invalid credentials")
    public void loginToThePlatformWithInvalidEmail() throws IOException, ParseException, InterruptedException {
        loginObject = new Login_Page(driver);
        loginObject.loginToMyAccount(invalidEmail, pass);
        loginObject.checkInvalidLogin();

    }
    @Test(priority = 2, description = "Login to the website using invalid credentials")
    public void loginToThePlatformWithInvalidPass() throws IOException, ParseException, InterruptedException {
        loginObject = new Login_Page(driver);
        driver.navigate().refresh();
        loginObject.loginToMyAccount(em, invalidPass);
        loginObject.checkInvalidLogin();

    }
}
