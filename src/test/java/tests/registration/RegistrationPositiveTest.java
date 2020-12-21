package tests.registration;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import page.objects.AccountPage;
import page.objects.RegisterPage;
import tests.TestBase;
import utils.DriverUtils;
import static navigation.ApplicationURLs.REGISTRATION_URL;

public class RegistrationPositiveTest extends TestBase {
    @Test
    @Description("Cel testu: Poprawne zarejestrowanie nowego użytkownika")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("Id-1")
    public void registerNewUser(){
        final String FIRST_NAME = "JANUSZ";
        final String LAST_NAME = "KOWALSKI";
        DriverUtils.navigateToPage(REGISTRATION_URL);
        RegisterPage registerPage = new RegisterPage();
        registerPage
                .typeIntoFirstNameField(FIRST_NAME)
                .typeIntoLastNameField(LAST_NAME)
                .typeIntoPhoneField("123456789")
                .typeIntoEmailField("janusz.opo@gmail.com")
                .typeIntoPasswordField("123456")
                .typeIntoConfirmPasswordField("123456")
                .clickOnSignUpButton();
        AccountPage accountPage = new AccountPage();
        accountPage
        .assertThatGreentigMessageIsDisplayed("Hi, " + FIRST_NAME + " " + LAST_NAME);
    }
}
