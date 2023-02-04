package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BrowserUtils {

    public static WebDriver getBrowser(String browser, String configFile) {

        switch (browser.toLowerCase()) {
            case ("chrome") : {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                if(GenericUtils.startMaximized(configFile)) {
                    // Start the browser maximized
                    options.addArguments("--start-maximized");
                }
                return new ChromeDriver(options);
            }

            case ("firefox") : {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                FirefoxProfile profile = new FirefoxProfile();
                if(GenericUtils.startMaximized(configFile)) {
                    options.addArguments("--start-maximized");
                }

                options.setProfile(profile);
                WebDriver driver = new FirefoxDriver(options);

                if(GenericUtils.startMaximized(configFile)) {
                    driver.manage().window().maximize();
                }
                return driver;
            }

            case ("edge") : {
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            }
            default : {
                System.out.println("Driver is not supported officially, please be careful");
                return WebDriverManager.getInstance(browser).getWebDriver();
            }
        }
    }


    public static Browser getBrowser(BrowserTypes browserType) {
        switch(browserType.toString()) {
            case ("CHROME") : {
                return new ChromeBrowser();
            }
            case("FIREFOX") : {
                return new FirefoxBrowser();
            }
            case("EDGE") : {
                return new EdgeBrowser();
            }
            default : {
                System.out.println("Browser not supported");
                return null;
            }
        }
    }

    public static String getBrowserExternal(String propName) {
        // Take all the system environment names and values
        Map<String, String> env = System.getenv();
        // Check if the property is set
        if (env.containsKey(propName)) {
            System.out.println("Running from ENV variable with browser: " + System.getenv(propName));
            return System.getenv(propName).toLowerCase();
        }
        else {
            return "CHROME";
        }
    }
}