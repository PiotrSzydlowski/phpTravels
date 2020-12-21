package tests.login;

import org.testng.annotations.Test;
import page.objects.AccountPage;
import tests.TestBase;


public class LoginByCookie extends TestBase {

    @Test
    public void loginByCookie(){
        AccountPage accountPage = new AccountPage();
        accountPage
                .loginByCookie()
                .assertThatGreentigMessageIsDisplayed("Hi, " + "JANUSZ" + " " + "KOWALSKI");
    }
}
