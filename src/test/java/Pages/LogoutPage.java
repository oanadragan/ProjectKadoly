package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoutPage extends BasePage{

    private String logoutBtn = "#header_links > li.last"; //CSS


    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    public void logout(){

        WebElement logoutButton = driver.findElement(By.cssSelector(logoutBtn));
        logoutButton.click();
    }


}
