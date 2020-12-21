package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LandingPage extends BasePage {

    @FindBy(xpath = "//text()[contains(.,'My Account')]/ancestor::a[1]")
    private List<WebElement> myAccountList;

    @FindBy(xpath = "/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]")
    private WebElement loginLink;

    @FindBy(css = "#s2id_autogen8 > .select2-choice > .select2-chosen")
    private WebElement choseHotelNameFiled;

    @FindBy(xpath = "")
    private WebElement hotelNameField;

    public LandingPage clickOnMyAccountLink() {
        WebElement myAccount = myAccountList.get(1);
        myAccount.click();
        return this;
    }

    public LoginPage clickOnLoginLink(){
        loginLink.click();
        return new LoginPage();
    }

    public LandingPage clickHotelNameFiled(String nameHotel){
        choseHotelNameFiled.click();
        return this;
    }
}
