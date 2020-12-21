package tests.login;

import org.testng.annotations.Test;
import page.objects.AccountPage;
import tests.TestBase;


public class ChooseHotelTest extends TestBase {

    @Test
    public void chooseHotelOption(){
        AccountPage accountPage = new AccountPage();
        accountPage
                .loginByCookie()
                .assertThatGreentigMessageIsDisplayed("Hi, " + "JANUSZ" + " " + "KOWALSKI")
                .backToLandingPage();
    }
}
