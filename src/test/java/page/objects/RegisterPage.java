package page.objects;

import generic.assertions.AssertWebElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class RegisterPage extends BasePage{

    @FindBy(name = "firstname")
    private WebElement firstNameLabel;

    @FindBy(name = "lastname")
    private WebElement lastNameLabel;

    @FindBy(name = "phone")
    private WebElement phoneLabel;

    @FindBy(name = "email")
    private WebElement emailLabel;

    @FindBy(name = "password")
    private WebElement passLabel;

    @FindBy(name = "confirmpassword")
    private WebElement confirmPassLabel;

    @FindBy(xpath = "//text()[contains(.,'Sign Up')]/ancestor::button[1]")
    private WebElement singUpButton;

    @FindBy(css = "div[class='alert alert-danger']")
    private WebElement alertDanger;

    @Step("Wprowadzenie {username} do pola first name")
    public RegisterPage typeIntoFirstNameField(String username){
        firstNameLabel.sendKeys(username);
        log().info("Tap {} into userName filed", username);
        return this;
    }

    @Step("Wprowadzenie {lastname} do pola last name")
    public RegisterPage typeIntoLastNameField(String lastname){
        lastNameLabel.sendKeys(lastname);
        log().info("Tap {} into lastname filed", lastname);
        return this;
    }

    @Step("Wprowadzenie {phone} do pola mobile number")
    public RegisterPage typeIntoPhoneField(String phone){
        phoneLabel.sendKeys(phone);
        log().info("Tap {} into phone filed", phone);
        return this;
    }

    @Step("Wprowadzenie {email} do pola email")
    public RegisterPage typeIntoEmailField(String email){
        emailLabel.sendKeys(email);
        log().info("Tap {} into email filed", email);
        return this;
    }

    @Step("Wprowadzenie {password} do pola password")
    public RegisterPage typeIntoPasswordField(String password){
        passLabel.sendKeys(password);
        log().info("Tap {} into password filed", password);
        return this;
    }

    @Step("Wprowadzenie {confirmpassword} do pola confirmpassword")
    public RegisterPage typeIntoConfirmPasswordField(String confirmpassword){
        confirmPassLabel.sendKeys(confirmpassword);
        log().info("Tap {} into confirm password filed", confirmpassword);
        return this;
    }

    @Step("Kliknięcie w przycisk Sign Up")
    public RegisterPage clickOnSignUpButton(){
        singUpButton.click();
        log().info("Click sing up button");
        return this;
    }

    @Step("Sprawdzenie czy alert o istniejącym użytkowniku jest wyświetlany")
    public RegisterPage assertThatDangerMessageAboutExistingMessageIsDisplayed(String dangerMessage){
        log().info("Checking if danger message {} is displayed", dangerMessage);
        WaitForElement.waitUntilElementIsVisible(alertDanger);
        AssertWebElement.assertThat(alertDanger).hasText(dangerMessage);
        return this;
    }
}
