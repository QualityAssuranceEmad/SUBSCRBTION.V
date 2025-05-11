package tests.authentication_Scenarios;

import authentication_Scenarios.pages.DashboardPage;
import authentication_Scenarios.pages.LoginPage;
import authentication_Scenarios.pages.SignUpPage;
import data.JsonDataReaderForSignUp;
import data.LoadProperties;
import org.testng.annotations.Test;
import tests.BaseTest;

public class Registration_with_invalid_data extends BaseTest {
    SignUpPage registerObject;
    LoginPage loginObject;
    JsonDataReaderForSignUp jsonReader = new JsonDataReaderForSignUp();
    String fn= LoadProperties.userData.getProperty("firstname");
    String ln= LoadProperties.userData.getProperty("lastname");
    String phone= LoadProperties.userData.getProperty("phone");
    String em= LoadProperties.userData.getProperty("email");
    String pass= LoadProperties.userData.getProperty("pass");
    String confPass= LoadProperties.userData.getProperty("confirmPass");
    @Test(priority = 1)
    public void SignUpWithInvalidData() throws Exception {
        loginObject = new LoginPage(driver);
        registerObject = new SignUpPage(driver);
        loginObject.clickSignUpLinck();
        registerObject.signUp(fn,ln,phone,em,pass,confPass);
        registerObject.FirstNameValidation.isDisplayed();
        registerObject.LastNameValidation.isDisplayed();
        registerObject.PhoneValidation.isDisplayed();
        registerObject.EmailValidation.isDisplayed();
        registerObject.PasswordValidation.isDisplayed();


    }
    @Test(priority = 2)
<<<<<<< HEAD
    public void RegisterExistingUserTests() throws Exception {
=======
    public void SignUpDataAlreadyEmailExit() throws Exception {
>>>>>>> b4774f575f14dc8fb8cf29ea7f1e1a7f972a519d
        registerObject = new SignUpPage(driver);
        driver.navigate().refresh();
        jsonReader.JsonReader();
        registerObject.signUp(jsonReader.firstName, jsonReader.lastName, jsonReader.mobile, jsonReader.email,
                jsonReader.password, jsonReader.confirmPass);
        registerObject.EmailAlreadyExit.isDisplayed();
    }
}
