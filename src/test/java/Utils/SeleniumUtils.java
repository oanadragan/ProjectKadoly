package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Set;
import java.util.regex.Pattern;

public class SeleniumUtils {

    public static WebElement waitForGenericElement(WebDriver driver, By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static Boolean waitForTextOnSite(WebDriver driver, By locator, int timeout, String pattern) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        Pattern patt = Pattern.compile(pattern);
        return wait.until(ExpectedConditions.textMatches(locator,patt));
    }


    public static String takeScreenshot(WebDriver driver) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String filename = ConstantUtils.SCREENSHOT_FOLDER + "screenshot_" + timestamp.getTime() +  ".png";
        try {
            FileUtils.copyFile(screenshotFile,
                    new File(filename));
        } catch (IOException e) {
            System.out.println("File could not be saved on the disk!!");
        }
        return filename;
    }


    public static String getReportName() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return "extentReport_" + timestamp.getTime() + ".html";
    }


}
