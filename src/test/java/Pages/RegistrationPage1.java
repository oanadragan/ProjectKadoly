package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RegistrationPage1 extends BasePage {
    //1st Page

    WebDriverWait wait = new WebDriverWait(driver, 5);
    private String authenticationText = "//*[@id=\"center_column\"]/h1"; //XPath
    private String createAccountText = "//*[@id=\"create-account_form\"]/div/p"; //XPath
    private String createEmail = "email_create"; //I
    private String emailErrorText = "#create_account_error > ol > li"; //CSS
    private String createEmailBtn = "SubmitCreate"; //ID


    public RegistrationPage1(WebDriver driver) {

        super(driver);
    }

    public void verifyPage() {
        Assert.assertEquals(driver.findElement(By.xpath(authenticationText)).getText(), "AUTENTIFICARE");
        Assert.assertEquals(driver.findElement(By.xpath(createAccountText)).getText(), "Te rugam sa introduci adresa de e-mail pentru a crea un cont.");

    }

    public void registrationPage1(String username) {
        WebElement emailInput = driver.findElement(By.id(createEmail));
        WebElement emailInputBtn = driver.findElement(By.id(createEmailBtn));

        emailInput.clear();
        emailInput.sendKeys(username);

        emailInputBtn.submit();

        //  Assert.assertEquals(driver.findElement(By.cssSelector(emailErrorText)).getText(), "Adresa de e-mail este invalida");
    }





    public String getEmailErrorText() {

        return driver.findElement(By.cssSelector(emailErrorText)).getText();
    }
}
