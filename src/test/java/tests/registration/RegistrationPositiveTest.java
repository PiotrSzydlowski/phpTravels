package tests.registration;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import page.objects.AccountPage;
import page.objects.RegisterPage;
import tests.TestBase;
import utils.DriverUtils;

import java.util.Locale;

import static navigation.ApplicationURLs.REGISTRATION_URL;

public class RegistrationPositiveTest extends TestBase {
    @Test
    @Description("Cel testu: Poprawne zarejestrowanie nowego użytkownika")
    @Severity(SeverityLevel.BLOCKER)
    public void registerNewUser(){
        Faker faker = new Faker(new Locale("pl_PL"));
        final String FIRST_NAME = faker.name().firstName();
        final String LAST_NAME = faker.name().lastName();
        final String PASSWORD = faker.internet().password();

        DriverUtils.navigateToPage(REGISTRATION_URL);
        RegisterPage registerPage = new RegisterPage();
        registerPage
                .typeIntoFirstNameField(FIRST_NAME)
                .typeIntoLastNameField(LAST_NAME)
                .typeIntoPhoneField(faker.phoneNumber().phoneNumber())
                .typeIntoEmailField(faker.internet().emailAddress())
                .typeIntoPasswordField(PASSWORD)
                .typeIntoConfirmPasswordField(PASSWORD)
                .clickOnSignUpButton();
        AccountPage accountPage = new AccountPage();
        accountPage
        .assertThatGreentigMessageIsDisplayed("Hi, " + FIRST_NAME + " " + LAST_NAME);
    }
}
