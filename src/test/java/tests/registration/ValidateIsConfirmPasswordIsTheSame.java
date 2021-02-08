package tests.registration;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import page.objects.RegisterPage;
import tests.TestBase;
import utils.DriverUtils;

import static navigation.ApplicationURLs.REGISTRATION_URL;

public class ValidateIsConfirmPasswordIsTheSame extends TestBase {
    @Test
    @Description("Cel testu: Potwierdzenie walidacji jednakowych haseł w polach Password i Confirm Password ")
    @Severity(SeverityLevel.CRITICAL)
    public void checkIfDangerMessageIsDisplayedAfterTypeIncorrectConfirmPassword() {
        final String FIRST_NAME = "JANUSZ";
        final String LAST_NAME = "KOWALSKI";
        DriverUtils.navigateToPage(REGISTRATION_URL);
        RegisterPage registerPage = new RegisterPage();
        registerPage
                .typeIntoFirstNameField(FIRST_NAME)
                .typeIntoLastNameField(LAST_NAME)
                .typeIntoPhoneField("123456789")
                .typeIntoEmailField("janusz.t10@gmail.com")
                .typeIntoPasswordField("123456")
                .typeIntoConfirmPasswordField("789456")
                .clickOnSignUpButton()
                .assertThatDangerMessageAboutExistingMessageIsDisplayed("Password not matching with confirm password.");
    }
}
