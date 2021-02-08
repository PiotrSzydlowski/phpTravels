package page.objects;

import generic.assertions.AssertWebElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;


public class LoginPage extends BasePage{

    @FindBy(name = "username")
    private WebElement userNameLabel;

    @FindBy(name = "password")
    private WebElement passwordLabel;

    @FindBy(xpath = "//button[text()='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//img[@class='center-block wow fadeIn center-block animated']")
    private WebElement avatar;

    @Step("Wprowadzenie {username} do pola email")
    public LoginPage typeIntoFirstNameField(String username){
        log().info("Tap {} into userName filed", username);
        userNameLabel.sendKeys(username);
        return this;
    }

    @Step("Wprowadzenie {password} do pola password")
    public LoginPage typeIntoPasswordField(String password){
        passwordLabel.sendKeys(password);
        log().info("Tap {} into password filed", password);
        return this;
    }

    @Step("Kliknięcie przycisku login")
    public AccountPage clickLoginButton(){
        loginButton.click();
        log().info("Click Login Button");
        return new AccountPage();
    }

    @Step("Sprawdzenie czy na stronie występuje avatar")
    public LoginPage assertThatAvatarIsDisplayed(){
        WaitForElement.waitUntilElementIsVisible(avatar);
        log().info("Check is avatar is displayed");
        AssertWebElement.assertThat(avatar).isDisplayed();
        return this;
    }
}
