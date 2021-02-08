package tests.login;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.objects.LoginPage;
import tests.TestBase;
import utils.DriverUtils;
import static navigation.ApplicationURLs.LOGIN_URL;

public class PositiveLoginTest extends TestBase {
    @Parameters("email")
    @Test
    @Description("Cel testu: Poprawne zalogowanie użytkownika")
    @Severity(SeverityLevel.BLOCKER)
    public void loginUser(String email){
        DriverUtils.navigateToPage(LOGIN_URL);
        final String FIRST_NAME = "JANUSZ";
        final String LAST_NAME = "KOWALSKI";
        LoginPage loginPage = new LoginPage();
        loginPage
                .typeIntoFirstNameField(email)
                .typeIntoPasswordField("123456")
                .clickLoginButton()
                .assertThatGreentigMessageIsDisplayed("Hi, " + FIRST_NAME + " " + LAST_NAME);
    }
}
