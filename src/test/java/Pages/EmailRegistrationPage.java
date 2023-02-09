package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class EmailRegistrationPage extends BasePage{

    private String authenticationText = "//*[@id=\"center_column\"]/h1"; //XPath
    private String createAccountText = "//*[@id=\"create-account_form\"]/div/p"; //XPath
    private String createEmail = "email_create"; //I
    private String createEmailBtn = "SubmitCreate"; //ID
    private String emailErrorRegPage1 = "#create_account_error > ol > li"; //CSS


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
    }

    public EmailRegistrationPage(WebDriver driver) {
        super(driver);
    }

    public String getEmailErrorRegPage1() {
        return driver.findElement(By.cssSelector(emailErrorRegPage1)).getText();
    }
}
