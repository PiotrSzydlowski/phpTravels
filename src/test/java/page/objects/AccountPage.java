package page.objects;

import generic.assertions.AssertWebElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.DriverManager;
import waits.WaitForElement;

import static navigation.ApplicationURLs.ACCOUNT_URL;

public class AccountPage extends BasePage {

    @FindBy(css = "h3[class='RTL']")
    private WebElement greetingLabel;

    @FindBy(xpath = "//img[@alt='My Account']")
    private WebElement mainLogo;


    @Step("Sprawdzenie czy powitanie jest wyświetlane")
    public AccountPage assertThatGreentigMessageIsDisplayed(String greetingMessage) {
        log().info("Checking if greeting message {} is displayed", greetingMessage);
        WaitForElement.waitUntilElementIsVisible(greetingLabel);
        AssertWebElement.assertThat(greetingLabel).isDisplayed().hasText(greetingMessage);
        return this;
    }

    @Step("logowanie z wykorzystaniem cookie")
    public AccountPage loginByCookie() {
        Cookie loginCookie = new Cookie("ci_session", "e4jvaj0um8r4v1o9ii6sltenqhesmo0o");
        WebDriver webDriver = DriverManager.getWebDriver();
        webDriver.manage().addCookie(loginCookie);
        webDriver.navigate().to(ACCOUNT_URL);
        return this;
    }

    @Step("Cofnięcie do strony głównej")
    public LandingPage backToLandingPage() {
        mainLogo.click();
        return new LandingPage();
    }
}
