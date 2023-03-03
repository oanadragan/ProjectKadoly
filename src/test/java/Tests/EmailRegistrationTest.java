package Tests;

import Pages.EmailRegistrationPage;
import Utils.DataUtils;
import Utils.ExtentTestManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

public class EmailRegistrationTest extends BaseTest {

    @Test(dataProviderClass = DataUtils.class, dataProvider = "emailRegistrationDp")
    public void emailRegistration1(HashMap<String, String> hashMap, Method method) {
        test = ExtentTestManager.startTest(method.getName(), "");
        EmailRegistrationPage emailReg = new EmailRegistrationPage(driver);
        driver.get(baseUrl + "/autentificare");
        emailReg.verifyPage();
        emailReg.registrationPage1(hashMap.get("email"));
        Assert.assertEquals(emailReg.getEmailErrorRegPage1(), hashMap.get("error message"));

    }
}