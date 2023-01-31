package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RegistrationPage extends BasePage {
    //1st Page

    WebDriverWait wait = new WebDriverWait(driver, 5);
    private String authenticationText = "//*[@id=\"center_column\"]/h1"; //XPath
    private String createAccountText = "//*[@id=\"create-account_form\"]/div/p"; //XPath
    private String createEmail = "email_create"; //I
    private String createEmailBtn = "SubmitCreate"; //ID

    //2nd Page - personal information

    private String firstNameInfo = "customer_firstname"; //ID
    private String firstNameErrorInfo = "//*[@id=\"center_column\"]/div[2]/ol/li[3]";//XPath

    private String lastNameInfo = "customer_lastname"; //ID
    private String lastNameErrorInfo = "//*[@id=\"center_column\"]/div[2]/ol/li[2]"; //XPath

    private String emailInfo = "email"; //ID
    private String emailInfoError = "//*[@id=\"center_column\"]/div[2]/ol/li[4]"; //XPath

    private String passwordInfo = "passwd"; //ID
    private String passwordError = "//*[@id=\"center_column\"]/div[2]/ol/li[5]"; //XPath

    private String checkBoxNewsletter = "newsletter"; //ID


    //address
    private String lastNameAddress = "lastname"; //ID
    private String firstNameAddress = "firstname"; //ID
    private String cityInfo = "city"; //ID
    private String cityInfoError = "//*[@id=\"center_column\"]/div[2]/ol/li[8]";
    private String addressInfo = "address1"; //ID
    private String addressText = "#account-creation_form > div:nth-child(2) > p:nth-child(7) > span"; //CSS
    private String addressInfoError = "//*[@id=\"center_column\"]/div[2]/ol/li[7]";
    private String postalCodeInfo = "postcode"; //ID
    private String postalCodeInfoError = "//*[@id=\"center_column\"]/div[2]/ol/li[9]";

    private String countyInfo = "id_state"; //ID

    private String mobilePhoneInfo = "phone_mobile"; //ID
    private String phoneNoError = "//*[@id=\"center_column\"]/div[2]/ol/li[1]";
    private String aliasInfo = "alias"; //ID
    private String aliasInfoError = "//*[@id=\"center_column\"]/div[2]/ol/li[6]";

    private String submitBtn = "submitAccount"; //ID



    public RegistrationPage(WebDriver driver) {
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
    }

    public void registration(String firstName1, String lastName1, String email1, String password1,
                                  String lastName2, String firstName2, String city1,
                                  String address1, String postalCode, String mobilePhoneNo, String aliasAddress) {


        WebElement firstNameInput = driver.findElement(By.id(firstNameInfo));
        WebElement lastNameInput = driver.findElement(By.id(lastNameInfo));
        WebElement emailInput = driver.findElement(By.id(emailInfo));
        WebElement passwordInput = driver.findElement(By.id(passwordInfo));
        WebElement checkboxInput = driver.findElement(By.id(checkBoxNewsletter));
        WebElement lastNameAddressInput = driver.findElement(By.id(lastNameAddress));
        WebElement firstNameAddressInput = driver.findElement(By.id(firstNameAddress));
        WebElement cityInput = driver.findElement(By.id(cityInfo));
        WebElement addressInput = driver.findElement(By.id(addressInfo));
        WebElement postalCodeInput = driver.findElement(By.id(postalCodeInfo));
        WebElement mobilePhoneInput = driver.findElement(By.id(mobilePhoneInfo));
        WebElement aliasInput = driver.findElement(By.id(aliasInfo));
        WebElement submitButton = driver.findElement(By.id(submitBtn));

        Assert.assertEquals(driver.findElement(By.cssSelector(addressText)).getText(), "Strada, cod postal, nume firma etc...");

        firstNameInput.clear();
        firstNameInput.sendKeys(firstName1);
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName1);
        emailInput.clear();
        emailInput.sendKeys(email1);
        passwordInput.clear();
        passwordInput.sendKeys(password1);

        boolean checked = checkboxInput.isSelected();
        if (!checked) {
            checkboxInput.click();
        }

        lastNameAddressInput.clear();
        lastNameAddressInput.sendKeys(lastName2);
        firstNameAddressInput.clear();
        firstNameAddressInput.sendKeys(firstName2);
        cityInput.clear();
        cityInput.sendKeys(city1);
        addressInput.clear();
        addressInput.sendKeys(address1);
        postalCodeInput.clear();
        postalCodeInput.sendKeys(postalCode);

        Select dropdown = new Select(driver.findElement(By.id(countyInfo)));
        dropdown.selectByVisibleText("Timis");

        mobilePhoneInput.clear();
        mobilePhoneInput.sendKeys(mobilePhoneNo);
        aliasInput.clear();
        aliasInput.sendKeys(aliasAddress);

        submitButton.click();
        }

    public boolean checkError(String expectedErr, String errorType) {

        if ((errorType.equalsIgnoreCase("lastName1Error")) || (errorType.equalsIgnoreCase("lastName2Error")))  {
            if (expectedErr.length() > 0) {
                System.out.println("Actual error:" + driver.findElement(By.xpath(lastNameErrorInfo)).getText());
                return expectedErr.equals(driver.findElement(By.xpath(lastNameErrorInfo)).getText());
            } else return true;

        } else if ((errorType.equalsIgnoreCase("firstName1Error")) || (errorType.equalsIgnoreCase("firstName2Error"))) {
            if (expectedErr.length() > 0) {
                System.out.println("Actual error:" + driver.findElement(By.xpath(firstNameErrorInfo)).getText());
                return expectedErr.equalsIgnoreCase(driver.findElement(By.xpath(firstNameErrorInfo)).getText());
            } else return true;

        } else if (errorType.equalsIgnoreCase("email1Error")) {
            if (expectedErr.length() > 0) {
                System.out.println("Actual error:" + driver.findElement(By.xpath(emailInfoError)).getText());
                return expectedErr.equalsIgnoreCase(driver.findElement(By.xpath(emailInfoError)).getText());
            } else return true;

        } else if (errorType.equalsIgnoreCase("password1Error")) {
            if (expectedErr.length() > 0) {
                System.out.println("Actual error:" + driver.findElement(By.xpath(passwordError)).getText());
                return expectedErr.equalsIgnoreCase(driver.findElement(By.xpath(passwordError)).getText());
            } else return true;

        }else if (errorType.equalsIgnoreCase("aliasError")) {
            if (expectedErr.length() > 0) {
                System.out.println("Actual error:" + driver.findElement(By.xpath(aliasInfoError)).getText());
                return expectedErr.equalsIgnoreCase(driver.findElement(By.xpath(aliasInfoError)).getText());
            } else return true;

        }else if (errorType.equalsIgnoreCase("address1Error")) {
            if (expectedErr.length() > 0) {
                System.out.println("Actual error:" + driver.findElement(By.xpath(addressInfoError)).getText());
                return expectedErr.equalsIgnoreCase(driver.findElement(By.xpath(addressInfoError)).getText());
            } else return true;

        }else if (errorType.equalsIgnoreCase("city1Error")) {
            if (expectedErr.length() > 0) {
                System.out.println("Actual error:" + driver.findElement(By.xpath(cityInfoError)).getText());
                return expectedErr.equalsIgnoreCase(driver.findElement(By.xpath(cityInfoError)).getText());
            } else return true;

        }else if (errorType.equalsIgnoreCase("phoneNoError")) {
            if (expectedErr.length() > 0) {
                System.out.println("Actual error:" + driver.findElement(By.xpath(phoneNoError)).getText());
                return expectedErr.equalsIgnoreCase(driver.findElement(By.xpath(phoneNoError)).getText());
            } else return true;

        }else if (errorType.equalsIgnoreCase("postalCodeError")) {
            if (expectedErr.length() > 0) {
                System.out.println("Actual error:" + driver.findElement(By.xpath(postalCodeInfoError)).getText());
                return expectedErr.equalsIgnoreCase(driver.findElement(By.xpath(postalCodeInfoError)).getText());
            } else return true;

        }
        return false;
    }

        public String getLastNameErrorInfo () {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(lastNameErrorInfo)));
            return driver.findElement(By.xpath(lastNameErrorInfo)).getText();
        }

        public String getFirstNameErrorInfo () {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(firstNameErrorInfo)));
            return driver.findElement(By.xpath(firstNameErrorInfo)).getText();
        }

        public String getEmailInfoError () {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(emailInfoError)));
            return driver.findElement(By.xpath(emailInfoError)).getText();
        }

        public String getPasswordError () {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(passwordError)));
            return driver.findElement(By.xpath(passwordError)).getText();
        }

        public String getCityInfoError () {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(cityInfoError)));
            return driver.findElement(By.xpath(cityInfoError)).getText();
        }

        public String getAddressInfoError () {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(addressInfoError)));
            return driver.findElement(By.xpath(addressInfoError)).getText();
        }

        public String getPostalCodeInfoError () {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(postalCodeInfoError)));
            return driver.findElement(By.xpath(postalCodeInfoError)).getText();
        }

        public String getPhoneNoError () {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(phoneNoError)));
            return driver.findElement(By.xpath(phoneNoError)).getText();
        }

        public String getAliasInfoError () {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(aliasInfoError)));
            return driver.findElement(By.xpath(aliasInfoError)).getText();
        }


}