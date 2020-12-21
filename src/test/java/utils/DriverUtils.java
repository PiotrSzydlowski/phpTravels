package utils;

import io.qameta.allure.Step;


public class DriverUtils {

    @Step("Maxymalizowanie okna przeglądarki")
    public static void setInitialConfiguration(){
        DriverManager.getWebDriver().manage().window().maximize();
    }

    @Step("Przejście do adresu: {pageUrl}")
    public static void navigateToPage(String pageUrl){
        DriverManager.getWebDriver().navigate().to(pageUrl);
    }
}
