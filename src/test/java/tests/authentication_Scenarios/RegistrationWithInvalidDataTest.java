package tests.authentication_Scenarios;

import authentication_Scenarios.pages.Login_Page;
import authentication_Scenarios.pages.SignUp_Page;
import data.JsonDataReaderForSignUp;
import data.LoadProperties;
import org.testng.annotations.Test;
import tests.BaseTest;

public class RegistrationWithInvalidDataTest extends BaseTest {
    SignUp_Page registerObject;
    Login_Page loginObject;
    JsonDataReaderForSignUp jsonReader = new JsonDataReaderForSignUp();
    String fn= LoadProperties.userData.getProperty("firstname");
    String ln= LoadProperties.userData.getProperty("lastname");
    String phone= LoadProperties.userData.getProperty("phone");
    String em= LoadProperties.userData.getProperty("email");
    String pass= LoadProperties.userData.getProperty("pass");
    String confPass= LoadProperties.userData.getProperty("confirmPass");
    @Test(priority = 1)
    public void SignUpWithInvalidData() throws Exception {
        loginObject = new Login_Page(driver);
        registerObject = new SignUp_Page(driver);
        loginObject.clickSignUpLinck();
        registerObject.signUp(fn,ln,phone,em,pass,confPass);
        registerObject.FirstNameValidation.isDisplayed();
        registerObject.LastNameValidation.isDisplayed();
        registerObject.PhoneValidation.isDisplayed();
        registerObject.EmailValidation.isDisplayed();
        registerObject.PasswordValidation.isDisplayed();


    }
    @Test(priority = 2)

    public void RegisterExistingUserTests() throws Exception {



        registerObject = new SignUp_Page(driver);
        driver.navigate().refresh();
        jsonReader.JsonReader();
        registerObject.signUp(jsonReader.firstName, jsonReader.lastName, jsonReader.mobile, jsonReader.email,
                jsonReader.password, jsonReader.confirmPass);
        registerObject.EmailAlreadyExit.isDisplayed();
    }
}
