import authentication_Scenarios.pages.Dashboard_Page;
import authentication_Scenarios.pages.Login_Page;
import authentication_Scenarios.pages.Track_Invoices_Page;
import data.JsonDataReaderForLogin;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.io.IOException;

public class TrackInvoicesTests extends BaseTest {
    Login_Page loginObject;
    Dashboard_Page dashboardPage;
    Track_Invoices_Page trackInvoicesPage;
    @Test(priority = 0, description = "Test Case 0: Login to the platform")
    public void loginToThePlatform() throws IOException, ParseException, InterruptedException {
        loginObject = new Login_Page(driver);
        dashboardPage = new Dashboard_Page(driver);
        JsonDataReaderForLogin jsonDataReaderForLogin = new JsonDataReaderForLogin();
        jsonDataReaderForLogin.JsonReader();
        loginObject.loginToMyAccount(jsonDataReaderForLogin.email, jsonDataReaderForLogin.password);
        dashboardPage.clickOnProfile();
    }
    @Test(priority = 1)
    public void testTrackInvoices() throws InterruptedException {
        dashboardPage = new Dashboard_Page(driver);
        trackInvoicesPage = new Track_Invoices_Page(driver);
        // Click on the "Track Invoices" link
        dashboardPage.clickOnTrackInvoices();
        // Verify the latest invoices match between sections
        trackInvoicesPage.verifyPaginationCount();
    }
}
