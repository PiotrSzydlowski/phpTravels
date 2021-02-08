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

public class ValidateLengthOfPassword extends TestBase {
    @Test
    @Description("Cel testu: Potwierdzenie czy walidowana jest długość wprowadzanego hasła")
    @Severity(SeverityLevel.NORMAL)
    public void checkIfDangerMessageIsDisplayed() {
        final String FIRST_NAME = "JANUSZ";
        final String LAST_NAME = "KOWALSKI";
        DriverUtils.navigateToPage(REGISTRATION_URL);
        RegisterPage registerPage = new RegisterPage();
        registerPage
                .typeIntoFirstNameField(FIRST_NAME)
                .typeIntoLastNameField(LAST_NAME)
                .typeIntoPhoneField("123456789")
                .typeIntoEmailField("janusz.t2@gmail.com")
                .typeIntoPasswordField("123")
                .typeIntoConfirmPasswordField("123")
                .clickOnSignUpButton()
                .assertThatDangerMessageAboutExistingMessageIsDisplayed("The Password field must be at least 6 " +
                        "characters in length.");
    }
}
