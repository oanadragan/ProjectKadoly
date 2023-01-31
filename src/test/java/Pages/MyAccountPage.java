package Pages;

import Utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyAccountPage extends BasePage{


    private String myAccount = "#header_links > li:nth-child(5) > a"; //CSS

    private String myAccountText = "#center_column > p"; //CSS
    private String myHistory = "#center_column > div.row.addresses-lists > div:nth-child(1) > ul > li:nth-child(1) > a"; //CSS
    private String myCredits = "#center_column > div.row.addresses-lists > div:nth-child(1) > ul > li:nth-child(2) > a"; //CSS
    private String myAddresses = "#center_column > div.row.addresses-lists > div:nth-child(1) > ul > li:nth-child(3) > a"; //CSS
    private String personalInfo = "#center_column > div.row.addresses-lists > div:nth-child(1) > ul > li:nth-child(4)"; //CSS
    private String myVouchers = "#center_column > div.row.addresses-lists > div:nth-child(2) > ul > li:nth-child(1) > a"; //CSS
    private String myReviews = "#center_column > div.row.addresses-lists > div:nth-child(2) > ul > li:nth-child(2) > a";//CSS
    private String loyaltyPoints = "#center_column > div.row.addresses-lists > div:nth-child(2) > ul > li.loyalty > a"; //CSS


    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public String getMyAccountText() {
        WebElement myAccountCfrmText = SeleniumUtils.waitForGenericElement(driver, By.cssSelector(myAccountText), 5);
        return myAccountCfrmText.getText();
    }

    public void goToMyAccount(){
        driver.findElement(By.cssSelector(myAccount)).click();
    }
    public void goToMyHistory()
    {
        driver.findElement(By.cssSelector(myHistory)).click();
    }

    public void goToMyCredits(){
        driver.findElement(By.cssSelector(myCredits)).click();
    }

    public void gotToMyAddress(){
        driver.findElement(By.cssSelector(myAddresses)).click();
    }

    public void goToPersonalInfo(){
        driver.findElement(By.cssSelector(personalInfo)).click();
    }

    public void goToMyVouchers() {
        driver.findElement(By.cssSelector(myVouchers)).click();
    }

    public void goToMyReviews() {
        driver.findElement(By.cssSelector(myReviews)).click();
    }

    public void goToLoyaltyPoints() {
        driver.findElement(By.cssSelector(loyaltyPoints)).click();
    }
}
