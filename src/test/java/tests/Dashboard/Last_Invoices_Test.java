package tests.Dashboard;

import authentication_Scenarios.pages.DashboardPage;
import authentication_Scenarios.pages.LoginPage;
import data.JsonDataReaderForLogin;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.io.IOException;

public class Last_Invoices_Test extends BaseTest {
    LoginPage loginObject;
    DashboardPage dashObject;
    @Test
    public void verifySubscribedPlansDisplay() throws IOException, ParseException {
        loginObject= new LoginPage(driver);
        dashObject= new DashboardPage(driver);
        JsonDataReaderForLogin jsonDataReaderForLogin = new JsonDataReaderForLogin();
        jsonDataReaderForLogin.JsonReader();
        //  Thread.sleep(4000);
        loginObject.loginToMyAccount(jsonDataReaderForLogin.email, jsonDataReaderForLogin.password);
        loginObject.AssertHomePAge();
        dashObject.verifyLatestInvoicesContent();
        dashObject.verifyLatestInvoicesMatching();
        dashObject.verifyLatestInvoicesMatchBetweenSections();

    }
}
