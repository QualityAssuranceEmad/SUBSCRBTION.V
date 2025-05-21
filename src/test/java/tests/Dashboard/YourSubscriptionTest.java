package tests.Dashboard;

import authentication_Scenarios.pages.Dashboard_Page;
import authentication_Scenarios.pages.Login_Page;
import data.JsonDataReaderForLogin;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.io.IOException;

public class YourSubscriptionTest extends BaseTest {
Login_Page loginObject;
Dashboard_Page dashObject;
@Test
    public void verifySubscribedPlansDisplay() throws IOException, ParseException {
    loginObject= new Login_Page(driver);
    dashObject= new Dashboard_Page(driver);
    JsonDataReaderForLogin jsonDataReaderForLogin = new JsonDataReaderForLogin();
    jsonDataReaderForLogin.JsonReader();
    //  Thread.sleep(4000);
    loginObject.loginToMyAccount(jsonDataReaderForLogin.email, jsonDataReaderForLogin.password);
    loginObject.AssertHomePAge();
    dashObject.verifySpecificPlanDetails();

}
}
