package tests.login;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import page.objects.LoginPage;
import tests.TestBase;
import utils.DriverUtils;
import static navigation.ApplicationURLs.LOGIN_URL;

public class PositiveLoginTest extends TestBase {
    @Test
    @Description("Cel testu: Poprawne zalogowanie użytkownika")
    @Severity(SeverityLevel.BLOCKER)
    public void loginUser(){
        DriverUtils.navigateToPage(LOGIN_URL);
        final String FIRST_NAME = "JANUSZ";
        final String LAST_NAME = "KOWALSKI";
        LoginPage loginPage = new LoginPage();
        loginPage
                .typeIntoFirstNameField("janusz.kowalski@gmail.com")
                .typeIntoPasswordField("123456")
                .clickLoginButton()
                .assertThatGreentigMessageIsDisplayed("Hi, " + FIRST_NAME + " " + LAST_NAME);
    }
}
