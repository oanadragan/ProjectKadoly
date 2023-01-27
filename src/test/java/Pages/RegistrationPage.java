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
    private String emailErrorText = "#create_account_error > ol > li"; //CSS
    private String createEmailBtn = "SubmitCreate"; //ID

    //2nd Page - personal information

    private String firstNameInfo = "customer_firstname"; //ID
    private String firstNameErrorInfo = "//*[@id=\"center_column\"]/div[2]/ol/li[3]";//XPath
    //"//*[@id=\"center_column\"]/div[2]/ol/li[3]"; //XPath
    private String lastNameInfo = "customer_lastname"; //ID
    private String lastNameErrorInfo = "//*[@id=\"center_column\"]/div[2]/ol/li[2]";
    //"//*[@id=\"account-creation_form\"]/div[1]/div[2]"; //XPath

    private String emailInfo = "email"; //ID
    private String emailInfoError = "//*[@id=\"center_column\"]/div[2]/ol/li[4]";
    //"//*[@id=\"account-creation_form\"]/div[1]/div[3]"; //XPath

    private String passwordInfo = "passwd"; //ID
    private String passwordError = "//*[@id=\"center_column\"]/div[2]/ol/li[5]";

    //"//*[@id=\"account-creation_form\"]/div[1]/div[4]"; //XPath
    private String checkBoxNewsletter = "newsletter"; //ID
    private String checkBoxNewsletterText = "#account-creation_form > div:nth-child(1) > div.checkbox > label"; //CSS

    //address
    private String lastNameAddress = "lastname"; //ID
    private String firstNameAddress = "firstname"; //ID
    private String cityInfo = "city"; //ID
    private String addressInfo = "address1"; //ID
    private String addressText = "#account-creation_form > div:nth-child(2) > p:nth-child(7) > span"; //CSS
    private String addressInfoError = "//*[@id=\"center_column\"]/div[2]/ol/li[7]";
    //"//*[@id=\"account-creation_form\"]/div[2]/p[5]"; //XPath
    //*[@id="center_column"]/div[2]/ol/li[7]
    private String postalCodeInfo = "postcode"; //ID
    private String postalCodeInfoError = "//*[@id=\"center_column\"]/div[2]/ol/li[9]";
    //"//*[@id=\"account-creation_form\"]/div[2]/p[6]"; //XPath

    private String countyInfo = "id_state"; //ID
    private String countryInfo = "id_country"; //ID
    private String phoneInfo = "phone"; //ID
    private String mobilePhoneInfo = "phone_mobile"; //ID
    private String phoneNoError = "//*[@id=\"center_column\"]/div[2]/ol/li[1]";
    //"/html/body/div[1]/div[5]/div/div/div/div[2]/ol/li[1]"; //XPath
    private String aliasInfo = "alias"; //ID
    private String aliasText = "#address_alias > label"; //CSS
    private String aliasInfoError = "//*[@id=\"center_column\"]/div[2]/ol/li[6]";
    //"//*[@id=\"account-creation_form\"]/div[2]/p[13]"; //XPath
    private String errors = "#center_column > div.alert.alert-danger > ol"; //CSS
    private String submitBtn = "submitAccount"; //ID
    private String cityInfoError = "//*[@id=\"center_column\"]/div[2]/ol/li[8]";
    //"/html/body/div[1]/div[5]/div/div/div/div[2]/ol/li[3]"; //XPath



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

        //  Assert.assertEquals(driver.findElement(By.cssSelector(emailErrorText)).getText(), "Adresa de e-mail este invalida");
    }


    public String getEmailErrorText() {

        return driver.findElement(By.cssSelector(emailErrorText)).getText();
    }


    public void registrationPage2(String firstName1, String lastName1, String email1, String password1,
                                  String lastName2, String firstName2, String city1,
                                  String address1, String postalCode, String mobilePhoneNo, String aliasAddress,
                                  String firstName1Error, String lastName1Error, String email1Error, String password1Error,
                                  String lastName2Error, String firstName2Error, String city1Error, String address1Error,
                                  String postalCodeError, String phoneNoError, String aliasError) {


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
//        WebElement countyInput = driver.findElement(By.id(countyInfo));
//        WebElement countryInput = driver.findElement(By.id(countryInfo));
//        WebElement phoneInput = driver.findElement(By.id(phoneInfo));
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



//            if (firstName1Error.length() > 0) {
//                System.out.println("nume este obligatoriu.");
//                Assert.assertTrue(driver.findElement(By.cssSelector(errors)).getText().contains("nume este obligatoriu."));
//            } if (lastName1Error.length() > 0) {
//                System.out.println("prenume este obligatoriu.");
//                Assert.assertTrue(driver.findElement(By.cssSelector(errors)).getText().contains("prenume este obligatoriu."));
//            }  if (email1Error.length() > 0) {
//                System.out.println("email este obligatoriu.");
//                Assert.assertTrue(driver.findElement(By.cssSelector(errors)).getText().contains("email este obligatoriu."));
//            }  if (password1Error.length() > 0) {
//                System.out.println("passwd este obligatoriu.");
//                Assert.assertTrue(driver.findElement(By.cssSelector(errors)).getText().contains("passwd este obligatoriu."));
//            }  if (address1Error.length() > 0) {
//                System.out.println("adresa este obligatoriu.");
//                Assert.assertTrue(driver.findElement(By.cssSelector(errors)).getText().contains("adresa este obligatoriu."));
//
//            }if (postalCodeError.length() > 0) {
//                System.out.println("Cod postal invalid. Ar trebui sa fie introdus in modul urmator: 000000");
//                Assert.assertTrue(driver.findElement(By.cssSelector(errors)).getText().contains("Cod postal invalid. Ar trebui sa fie introdus in modul urmator: 000000"));
//            }  if (phoneNoError.length() > 0) {
//                System.out.println("Introduceți cel puțin un număr de telefon.");
//                Assert.assertTrue(driver.findElement(By.cssSelector(errors)).getText().contains("Introduceți cel puțin un număr de telefon."));
//            } if (city1Error.length() > 0) {
//                System.out.println("localitate este obligatoriu.");
//                Assert.assertTrue(driver.findElement(By.cssSelector(errors)).getText().contains("localitate este obligatoriu."));
//            }  if (aliasError.length() > 0) {
//                System.out.println("alias este obligatoriu.");
//                Assert.assertTrue(driver.findElement(By.cssSelector(errors)).getText().contains("alias este obligatoriu."));
//            }
        }

//    public boolean checkError(String expectedErr, String errorType) {
//        WebElement lastNameInputError = driver.findElement(By.xpath(lastNameErrorInfo));
//        WebElement firstNameInputError = driver.findElement(By.xpath(firstNameErrorInfo));
//        WebElement emailInputError = driver.findElement(By.xpath(emailInfoError));
//        WebElement passwordInputError = driver.findElement(By.xpath(passwordError));
//
//        if (errorType.equalsIgnoreCase("lastName1Error")) {
//            if (expectedErr.length() > 0) {
//                System.out.println("Actual error:" + lastNameInputError.getText());
//                return expectedErr.equals(lastNameInputError.getText());
//            } else return true;
//
//        } else if (errorType.equalsIgnoreCase("firstName1Error")) {
//            if (expectedErr.length() > 0) {
//                System.out.println("Actual error:" + firstNameInputError.getText());
//                return expectedErr.equalsIgnoreCase(firstNameInputError.getText());
//            } else return true;
//
//        } else if (errorType.equalsIgnoreCase("email1Error")) {
//            if (expectedErr.length() > 0) {
//                System.out.println("Actual error:" + emailInputError.getText());
//                return expectedErr.equalsIgnoreCase(emailInputError.getText());
//            } else return true;
//
//        } else if (errorType.equalsIgnoreCase("password1Error")) {
//            if (expectedErr.length() > 0) {
//                System.out.println("Actual error:" + passwordInputError.getText());
//                return expectedErr.equalsIgnoreCase(passwordInputError.getText());
//            } else return true;

//        }else if (errorType.equalsIgnoreCase("aliasError")) {
//            if (expectedErr.length() > 0) {
//                System.out.println("Actual error:" + driver.findElement(By.xpath(aliasInfoError)).getText());
//                return expectedErr.equalsIgnoreCase(driver.findElement(By.xpath(aliasInfoError)).getText());
//            } else return true;
//
//        }else if (errorType.equalsIgnoreCase("address1Error")) {
//            if (expectedErr.length() > 0) {
//                System.out.println("Actual error:" + driver.findElement(By.xpath(addressInfoError)).getText());
//                return expectedErr.equalsIgnoreCase(driver.findElement(By.xpath(addressInfoError)).getText());
//            } else return true;
//        }else if (errorType.equalsIgnoreCase("city1Error")) {
//            if (expectedErr.length() > 0) {
//                System.out.println("Actual error:" + driver.findElement(By.xpath(cityInfoError)).getText());
//                return expectedErr.equalsIgnoreCase(driver.findElement(By.xpath(cityInfoError)).getText());
//            } else return true;
//        }else if (errorType.equalsIgnoreCase("phoneNoError")) {
//            if (expectedErr.length() > 0) {
//                System.out.println("Actual error:" + driver.findElement(By.xpath(phoneNoError)).getText());
//                return expectedErr.equalsIgnoreCase(driver.findElement(By.xpath(phoneNoError)).getText());
//            } else return true;
//
//        }else if (errorType.equalsIgnoreCase("postalCodeError")) {
//            if (expectedErr.length() > 0) {
//                System.out.println("Actual error:" + driver.findElement(By.xpath(postalCodeInfoError)).getText());
//                return expectedErr.equalsIgnoreCase(driver.findElement(By.xpath(postalCodeInfoError)).getText());
//            } else return true;

//        }
//        return false;
//    }


        public String getErrors () {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(errors)));
            return driver.findElement(By.cssSelector(errors)).getText();
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

//    public String getLastNameAddressError() {
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(lastNameAddressError)));
//        return driver.findElement(By.xpath(lastNameAddressError)).getText();
//    }
//
//    public String getFirstNameAddressError() {
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(firstNameAddressError)));
//        return driver.findElement(By.xpath(firstNameAddressError)).getText();
//    }

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