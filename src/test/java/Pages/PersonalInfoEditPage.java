package Pages;

import Utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PersonalInfoEditPage extends BasePage{


    private String mainTextSelector = "#center_column > div.box > h1"; //CSS
    private String titleMrSelector = "#center_column > div.box > form > fieldset > div.clearfix > div:nth-child(3)"; // CSS
    private String titleMsSelector = "#center_column > div.box > form > fieldset > div.clearfix > div:nth-child(4)"; // CSS
    private String firstNameLabel = "#center_column > div.box > form > fieldset > div:nth-child(2) > label"; // CSS
    private String firstNameInputSelector = "firstname"; //ID

    private String lastNameLabel = "#center_column > div.box > form > fieldset > div:nth-child(3) > label"; //CSS
    private String lastNameInputSelector = "lastname"; //ID

    private String emailLabel = "#center_column > div.box > form > fieldset > div:nth-child(4) > label"; //CSS
    private String emailInputSelector = "email"; //ID

    private String currentPasswordLabel = "#center_column > div.box > form > fieldset > div:nth-child(6) > label"; //CSS
    private String currentPasswordInputSelector = "old_passwd"; //ID

    private String saveBtnSelector = "#center_column > div.box > form > fieldset > div:nth-child(10) > button";//CSS

    private String confirmationTextSelector = "#center_column > div.box > p"; //CSS


    public PersonalInfoEditPage(WebDriver driver) {
        super(driver);
    }

    public void verifyInfoPage() {
        Assert.assertEquals(driver.findElement(By.cssSelector(mainTextSelector)).getText(), "INFORMATILE TALE PERSONALE");
        Assert.assertEquals(driver.findElement(By.cssSelector(firstNameLabel)).getText(), "Prenume");
        Assert.assertEquals(driver.findElement(By.cssSelector(lastNameLabel)).getText(), "Nume");
        Assert.assertEquals(driver.findElement(By.cssSelector(emailLabel)).getText(), "Adresa e-mail");
        Assert.assertEquals(driver.findElement(By.cssSelector(currentPasswordLabel)).getText(), "Parola actuala");
    }

    public void editAccountDetails(String firstName, String lastName, String email, String currentPassword) {
        WebElement titleMsInput = driver.findElement(By.cssSelector(titleMsSelector));
        titleMsInput.click();

        WebElement firstNameElement = driver.findElement(By.id(firstNameInputSelector));
        firstNameElement.clear();
        firstNameElement.sendKeys(firstName);
        WebElement lastNameElement = driver.findElement(By.id(lastNameInputSelector));
        lastNameElement.clear();
        lastNameElement.sendKeys(lastName);
        WebElement emailElement = driver.findElement(By.id(emailInputSelector));
        emailElement.clear();
        emailElement.sendKeys(email);
        WebElement passwordElement = driver.findElement(By.id(currentPasswordInputSelector));
        passwordElement.clear();
        passwordElement.sendKeys(currentPassword);
        WebElement submitButton = driver.findElement(By.cssSelector(saveBtnSelector));
        submitButton.click();

    }

    public String getConfirmationTextSelector() {

        WebElement confirmationText = SeleniumUtils.waitForGenericElement(driver, By.cssSelector(confirmationTextSelector), 10);
        return confirmationText.getText();

    }

}
