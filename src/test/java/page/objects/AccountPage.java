package page.objects;

import generic.assertions.AssertWebElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class AccountPage extends BasePage{

    @FindBy(css = "h3[class='RTL']")
    private WebElement greetingLabel;


    @Step("Sprawdzenie czy powitanie jest wyświetlane")
    public AccountPage assertThatGreentigMessageIsDisplayed(String greetingMessage) {
        log().info("Checking if greeting message {} is displayed", greetingMessage);
        WaitForElement.waitUntilElementIsVisible(greetingLabel);
        AssertWebElement.assertThat(greetingLabel).isDisplayed().hasText(greetingMessage);
        return this;
    }
}
