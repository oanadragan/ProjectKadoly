package Tests;

import Pages.RegistrationModel;
import Pages.RegistrationPage;
import Utils.ExtentTestManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class EmailRegistrationTest extends BaseTest {

@Test
    public void emailRegistration1(Method method) {
    test = ExtentTestManager.startTest(method.getName(), "");
        RegistrationPage rp = new RegistrationPage(driver);
        driver.get(baseUrl + "/autentificare");
        rp.verifyPage();
        rp.registrationPage1("test2@gmail.com");
        Assert.assertEquals(rp.getEmailErrorRegPage1(), "Exista deja un cont cu aceeasi adresa de e-mail. Introdu parola sau cere una noua.");

    }
}