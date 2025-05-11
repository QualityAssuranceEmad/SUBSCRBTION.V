package tests.authentication_Scenarios;

<<<<<<< HEAD
import authentication_Scenarios.pages.DashboardPage;
import authentication_Scenarios.pages.LoginPage;
import data.JsonDataReaderForLogin;
import data.LoadProperties;
=======
import authentication_Scenarios.pages.LoginPage;
import data.JsonDataReaderForLogin;
>>>>>>> b4774f575f14dc8fb8cf29ea7f1e1a7f972a519d
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.io.IOException;

import static io.qameta.allure.SeverityLevel.CRITICAL;

public class Successful_login extends BaseTest {
    LoginPage loginObject;
<<<<<<< HEAD
DashboardPage dashboardObjct;
=======
>>>>>>> b4774f575f14dc8fb8cf29ea7f1e1a7f972a519d

    @Test(priority = 1, description = "Login to the website using valid credentials")
    @Description("This test attempts to log into the website using a login and a password. Fails if any error happens.\n\nNote that this test does not test 2-Factor Authentication.")
    @Severity(CRITICAL)
    @Owner("Emad Maher")
    @Link(name = "Website", url = "http://subscription.advintic.com:6691/plans")
    @Issue("login-001")
    @Epic("Login Positive Scenario")
    @Feature("Essential features")
    @Story("Authentication")
    public void loginToThePlatform() throws IOException, ParseException, InterruptedException {
        loginObject = new LoginPage(driver);
<<<<<<< HEAD
        dashboardObjct= new DashboardPage(driver);
=======
>>>>>>> b4774f575f14dc8fb8cf29ea7f1e1a7f972a519d
        JsonDataReaderForLogin jsonDataReaderForLogin = new JsonDataReaderForLogin();
        jsonDataReaderForLogin.JsonReader();
        //  Thread.sleep(4000);
        loginObject.loginToMyAccount(jsonDataReaderForLogin.email, jsonDataReaderForLogin.password);
        loginObject.AssertHomePAge();
<<<<<<< HEAD
        dashboardObjct.clickLogoutButton();
    }


=======
    }
    @Test(priority = 2, description = "Login to the website using invalid credentials")

    public void LoginWithInvalidData() throws IOException, ParseException, InterruptedException {
        loginObject = new LoginPage(driver);
        JsonDataReaderForLogin jsonDataReaderForLogin = new JsonDataReaderForLogin();
        jsonDataReaderForLogin.JsonReader();
        //  Thread.sleep(4000);
        loginObject.loginToMyAccount(jsonDataReaderForLogin.email, jsonDataReaderForLogin.password);
        loginObject.AssertHomePAge();
    }
>>>>>>> b4774f575f14dc8fb8cf29ea7f1e1a7f972a519d
}
