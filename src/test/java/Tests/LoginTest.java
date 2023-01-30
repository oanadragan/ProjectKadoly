package Tests;

import Pages.LoginPage;
import Pages.LogoutPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginPositiveTest() {
        driver.get(baseUrl + "/autentificare");
        LoginPage lp = new LoginPage(driver);
        lp.verifyPage();
        lp.login("", "12345678");
    }

    @Test(dependsOnMethods = {"loginPositiveTest"})
    public void logoutTest() {
        LogoutPage lp1 = new LogoutPage(driver);
        lp1.logout();

    }
}
