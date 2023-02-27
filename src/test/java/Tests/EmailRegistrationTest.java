package Tests;

import Pages.EmailRegistrationPage;
import Utils.ExtentTestManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class EmailRegistrationTest extends BaseTest {

    @Test
    public void emailRegistration1(Method method) {
        test = ExtentTestManager.startTest(method.getName(), "");
        EmailRegistrationPage emailReg = new EmailRegistrationPage(driver);
        driver.get(baseUrl + "/autentificare");
        emailReg.verifyPage();
        emailReg.registrationPage1("test2@gmail.com");
        Assert.assertEquals(emailReg.getEmailErrorRegPage1(), "Exista deja un cont cu aceeasi adresa de e-mail. Introdu parola sau cere una noua.");

    }
}