package Tests;

import Pages.PageObjectModel.LoginModel;
import Pages.LoginPage;
import Pages.LogoutPage;
import Utils.AllureTestListener;
import Utils.ConstantUtils;
import Utils.ExtentTestManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
@Listeners ( {AllureTestListener.class})

public class LoginDataTest extends BaseTest{

    @DataProvider(name = "jsonDp")
    public Iterator<Object[]> jsonDpCollection() throws IOException {
        Collection<Object[]> dp = new ArrayList<>();
//      here is starting deserialization of json into LoginModel object
        ObjectMapper objectMapper = new ObjectMapper();

        File f = new File(ConstantUtils.LOGIN_FILE);
        LoginModel[] lms = objectMapper.readValue(f, LoginModel[].class);

        for (LoginModel lm : lms)
            dp.add(new Object[]{lm});

        return dp.iterator();
    }

    @Test(dataProvider = "jsonDp")
    public void loginWithJsonTest(LoginModel lm, Method method) {
        test = ExtentTestManager.startTest(method.getName(), "");
        System.out.println(lm);
        LoginPage loginPage = new LoginPage(driver);

//       open login page
        System.out.println("Open Login page");
        driver.get(baseUrl + "/autentificare");

        loginPage.verifyPage();
        loginPage.login(lm.getAccount().getUsername(), lm.getAccount().getPassword());
        System.out.println("Login button was pressed");

        String expectedUsernameError = lm.getUserError();
        String expectedPasswordErr = lm.getPasswordError();


        System.out.println("Verify expected errors present:\n expected username Error:" + expectedUsernameError);
        Assert.assertTrue(loginPage.checkErr(expectedUsernameError, "userError"));

        System.out.println("Expected Password Error:" + expectedPasswordErr);
        Assert.assertTrue(loginPage.checkErr(expectedPasswordErr, "passwordError"));
    }

    @Test(dependsOnMethods = {"loginWithJsonTest"})
    public void logoutTest(Method method) {
        test = ExtentTestManager.startTest(method.getName(), "");
        LogoutPage logoutP = new LogoutPage(driver);
        logoutP.logout();
        Assert.assertEquals(logoutP.getLogoutBtnTextSelector(), "LOGIN / CREAZĂ CONT");
    }
}
