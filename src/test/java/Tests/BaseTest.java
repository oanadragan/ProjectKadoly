package Tests;

import Utils.BrowserUtils;
import Utils.ConstantUtils;
import Utils.GenericUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    public WebDriver driver;
    String usedConfig = ConstantUtils.CONFIG_DATA;
    String dbHostname, dbUser, dbSchema, dbPassword, dbPort;
    String browser = GenericUtils.getBrowserConfig(usedConfig);
    String baseUrl = GenericUtils.createBaseUrl(usedConfig);
    Base64 base64 = new Base64();

    @BeforeTest (groups = {"Smoke",  "Regression"}, alwaysRun = true)
    public void beforeTest() {
        System.out.println(baseUrl);
        driver = BrowserUtils.getBrowser(browser, usedConfig);
        dbHostname = GenericUtils.getDBHostname(usedConfig);
        dbUser = GenericUtils.getDBUser(usedConfig);
        dbPassword = GenericUtils.getDBPassword(usedConfig);
        dbPort = GenericUtils.getDBPort(usedConfig);
        dbSchema = GenericUtils.getDBSchema(usedConfig);
    }


//    @AfterTest
//    public void afterTest() {
//        driver.quit();
//    }


//    public WebDriver driver;
//
//    //String browser = BrowserUtils.getBrowserExternal("autoBrowser");
//    String browser = GenericUtils.getBrowserConfig(ConstantUtils.CONFIG_FILE);
//    String baseUrl = GenericUtils.createBaseUrl(ConstantUtils.CONFIG_FILE);
//
//    @BeforeTest (groups = {"Smoke",  "Regression"}, alwaysRun = true)
//    public void beforeTest() {
//        System.out.println(baseUrl);
//        driver = BrowserUtils.getBrowser(browser, ConstantUtils.CONFIG_FILE);
//        //driver = BrowserUtils.getBrowser(BrowserTypes.FIREFOX).getDriver();
//    }

}
