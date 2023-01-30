package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends BasePage{

    private String emailAddress = "email"; //ID
    private String passwordLogin = "passwd"; //ID
    private String loginBtn = "SubmitLogin"; //ID
    private String pageTextSelector = "#login_form > h3"; //CSS

    private String errorText = "//*[@id=\"center_column\"]/div[2]/ol/li"; //XPath


    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void verifyPage() {
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText(), "AUTENTIFICARE");
        Assert.assertEquals(driver.findElement(By.cssSelector(pageTextSelector)).getText(),"AI DEJA UN CONT KADOLY?");
    }

    public void login(String username, String password){
        WebElement usernameInput = driver.findElement(By.id(emailAddress));
        WebElement passwordInput = driver.findElement(By.id(passwordLogin));
        WebElement submitButton = driver.findElement(By.id(loginBtn));

        usernameInput.clear();
        usernameInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(password);

        submitButton.click();

    }

    public boolean checkErr(String expectedError, String errorType) {
        if (errorType.equalsIgnoreCase("userError")) {
            if (expectedError.length() > 0) {
                // System.out.println("Actual user error:" + errorText.getText());
                return expectedError.equalsIgnoreCase(driver.findElement(By.xpath(errorText)).getText());
            } else return true;
        } else if (errorType.equalsIgnoreCase("passwordError")) {
            if (expectedError.length() > 0) {
                //  System.out.println("Actual pass error:" + passwordError.getText());
                return expectedError.equalsIgnoreCase(driver.findElement(By.xpath(errorText)).getText());
            } else return true;
        }
        return false;
    }
    public String getErrorText() {
        return driver.findElement(By.xpath(errorText)).getText();
    }

}
