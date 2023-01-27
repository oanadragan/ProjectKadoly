package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private String emailAddress = "email"; //ID

    private String passwordLogin = "passwd"; //ID
    private String loginBtn = "SubmitLogin"; //ID

    private String pageTextSelector = "#login_form > h3"; //CSS

    private String passwordError = "//*[@id=\"center_column\"]/div[2]/ol/li"; //XPath
    private String errorText = "//*[@id=\"center_column\"]/div[2]/ol/li"; //XPath


    private String userErr;

    public String getUserErr() {
        return userErr;
    }

    public String getPassErr() {
        return passErr;
    }

    public String getAuthErr() {
        return authErr;
    }

    private String passErr;
    private String authErr;
    public void verifyPage() {
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText(), "AUTENTIFICARE");
        Assert.assertEquals(driver.findElement(By.cssSelector(pageTextSelector)).getText(),"AI DEJA UN CONT KADOLY?");
    }

    public void login(String email, String password){

        WebElement emailInput = driver.findElement(By.id(emailAddress));
        WebElement passwordInput = driver.findElement(By.id(passwordLogin));
        WebElement submitButton = driver.findElement(By.id(loginBtn));

        emailInput.clear();
        emailInput.sendKeys(email);
        passwordInput.clear();
        passwordInput.sendKeys(password);

        submitButton.click();

    }

    public boolean checkErr(String expectedErr, String errorType) {
        if (errorType.equalsIgnoreCase("userErr")) {
            if (expectedErr.length() > 0) {
                // System.out.println("Actual user error:" + errorText.getText());
                return expectedErr.equalsIgnoreCase(driver.findElement(By.xpath(errorText)).getText());
            } else return true;
        } else if (errorType.equalsIgnoreCase("passErr")) {
            if (expectedErr.length() > 0) {
                //  System.out.println("Actual pass error:" + passwordError.getText());
                return expectedErr.equalsIgnoreCase(driver.findElement(By.xpath(errorText)).getText());
            } else return true;
        } else if (errorType.equalsIgnoreCase("authErr")) {
            if (expectedErr.length() > 0) {
                //  System.out.println("Actual pass error:" + passwordError.getText());
                return expectedErr.equalsIgnoreCase(driver.findElement(By.xpath(errorText)).getText());
            } else return true;

        }
        return false;
    }
    public String getErrorText() {
        return driver.findElement(By.xpath(errorText)).getText();
    }

    public String getPasswordError() {

        return driver.findElement(By.xpath(passwordError)).getText();
    }
}
