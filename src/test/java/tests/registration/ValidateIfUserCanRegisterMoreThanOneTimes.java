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

public class ValidateIfUserCanRegisterMoreThanOneTimes extends TestBase {
    @Test
    @Description("Cel testu: Potwierdzenie czy w przypadku próby zarejestrowania użytkownika z istniejącym już " +
            "zarejestrowanego wyświetlany jest komunikat ")
    @Severity(SeverityLevel.NORMAL)
    public void checkIfDangerMessageIsDisplayed(){
        final String FIRST_NAME = "JANUSZ";
        final String LAST_NAME = "KOWALSKI";
        DriverUtils.navigateToPage(REGISTRATION_URL);
        RegisterPage registerPage = new RegisterPage();
        registerPage
                .typeIntoFirstNameField(FIRST_NAME)
                .typeIntoLastNameField(LAST_NAME)
                .typeIntoPhoneField("123456789")
                .typeIntoEmailField("janusz.kowalski10@gmail.com")
                .typeIntoPasswordField("123456")
                .typeIntoConfirmPasswordField("123456")
                .clickOnSignUpButton()
                .assertThatDangerMessageAboutExistingMessageIsDisplayed("Email Already Exists.");
    }
}
