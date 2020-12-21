package tests.login;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import page.objects.LandingPage;
import tests.TestBase;

public class MoveFromHomePageToLoginPage extends TestBase {
    @Test
    @Description("Cel testu: Poprawne przejście do strony Logowania")
    @Severity(SeverityLevel.BLOCKER)
    public void logInByMovingFromHomePage() {
        LandingPage landingPage = new LandingPage();
        landingPage
                .clickOnMyAccountLink()
                .clickOnLoginLink()
                .assertThatAvatarIsDisplayed();
    }
}
