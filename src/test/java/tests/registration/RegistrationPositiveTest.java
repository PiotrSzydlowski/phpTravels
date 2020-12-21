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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static navigation.ApplicationURLs.REGISTRATION_URL;

public class RegistrationPositiveTest extends TestBase {
    @Test
    @Description("Cel testu: Poprawne zarejestrowanie nowego użytkownika")
    @Severity(SeverityLevel.BLOCKER)
    public void registerNewUser(){

        Faker faker = new Faker(new Locale("pl_PL"));
        String email = faker.bothify("????##@gmail.com");
        String name = faker.name().firstName();
        String lastName = faker.name().lastName();

        DriverUtils.navigateToPage(REGISTRATION_URL);
        RegisterPage registerPage = new RegisterPage();
        registerPage
                .typeIntoFirstNameField(name)
                .typeIntoLastNameField(lastName)
                .typeIntoPhoneField(faker.phoneNumber().cellPhone())
                .typeIntoEmailField(email)
                .typeIntoPasswordField("123456")
                .typeIntoConfirmPasswordField("123456")
                .clickOnSignUpButton();
        AccountPage accountPage = new AccountPage();
        accountPage
        .assertThatGreentigMessageIsDisplayed("Hi, " + name + " " + lastName);
    }
}
