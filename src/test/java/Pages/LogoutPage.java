package Pages;

import Utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoutPage extends BasePage{

    private String logoutBtn = "#header_links > li.last"; //CSS

    private String logoutBtnTextSelector = "#header_links > li.last > a"; //CSS
    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    public void logout(){

        WebElement logoutButton = driver.findElement(By.cssSelector(logoutBtn));
        logoutButton.click();
    }

    public String getLogoutBtnTextSelector() {
        WebElement logoutBtnText = SeleniumUtils.waitForGenericElement(driver, By.cssSelector(logoutBtnTextSelector), 10);
        return logoutBtnText.getText();
    }




}
