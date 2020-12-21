package tests;

import configuration.ConfigurationProperties;
import configuration.PropertiesLoader;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import utils.DriverManager;
import utils.DriverUtils;
import java.util.Properties;


import static navigation.ApplicationURLs.APPLICATION_URL;

public class TestBase {

    public WebDriver driver;

    @Step("Ladowanie konfiguracji z: configuration.properties")
    @BeforeClass
    public void beforeClass() {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        Properties propertiesFromFile = propertiesLoader.getPropertiesFromFile("configuration.properties");
        ConfigurationProperties.setProperties(propertiesFromFile);
    }

    @Step("Ustawienie przeglądarki i przejście do strony głównej")
    @Parameters("browser")
    @BeforeMethod
    public void beforeTest() {
        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage(APPLICATION_URL);
    }

    @Step("Zamknięcie Web drivera")
    @AfterMethod
    public void afterTest() {
        DriverManager.disposeDriver();
    }
}
