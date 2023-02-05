package Tests;

import Utils.BrowserUtils;
import Utils.ConstantUtils;
import Utils.ExtentTestManager;
import Utils.GenericUtils;
import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class BaseTest {

    public WebDriver driver;
    String usedConfig = ConstantUtils.CONFIG_DATA;
    String dbHostname, dbUser, dbSchema, dbPassword, dbPort;
    String browser;
    String baseUrl = GenericUtils.createBaseUrl(usedConfig);
    Base64 base64 = new Base64();
    ExtentTest test;

    @BeforeTest (alwaysRun = true)
    public void beforeTest() {
        System.out.println(baseUrl);
        browser = System.getProperty("browser");
        if (browser == null)
            //default value
            browser = GenericUtils.getBrowserConfig(usedConfig);

        System.out.println("Used browser:" + browser);
       setupDriver();
    }

//    @BeforeClass
//    public void beforeClass(){
//        if(driver == null)
//            setupDriver();
//    }

    @AfterMethod
    public void getResult(ITestResult result) {
        test = ExtentTestManager.updateTest(test, driver, result);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
        ExtentTestManager.extent.flush();
    }

//    @AfterClass
//    public void afterClass(){
//        if (driver != null)
//            driver.quit();
//    }


    public void setupDriver(){
        driver = BrowserUtils.getBrowser(browser, usedConfig);
        dbHostname = GenericUtils.getDBHostname(usedConfig);
        dbUser = GenericUtils.getDBUser(usedConfig);
        dbPassword = GenericUtils.getDBPassword(usedConfig);
        dbPort = GenericUtils.getDBPort(usedConfig);
        dbSchema = GenericUtils.getDBSchema(usedConfig);
    }



}
