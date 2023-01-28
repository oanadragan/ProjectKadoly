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

    @Test(dependsOnMethods = {"loginTest"} )
    public void logoutTest() {
        LogoutPage lp1 = new LogoutPage(driver);
        lp1.logout();

//
//       if(lp.getErrorText().contains("Autentificare esuata")){
//           System.out.println("Autentificare esuata" );
//           Assert.assertEquals(lp.getErrorText(), "Autentificare esuata");
//       } else if (lp.getErrorText().contains("Adresa de e-mail este obligatorie")) {
//           System.out.println("Adresa de e-mail este obligatorie");
//           Assert.assertEquals(lp.getErrorText(), "Adresa de e-mail este obligatorie");
//       } else if (lp.getErrorText().contains("Parola este obligatorie")) {
//           System.out.println("Parola este obligatorie");
//           Assert.assertEquals(lp.getPasswordError(), "Parola este obligatorie");
//       }
        //        String expectedUsernameErr = lp.getUserErr();
//        String expectedPassErr = lp.getPassErr();
//        String expectedAuthErr = lp.getAuthErr();
//        Assert.assertTrue(lp.checkErr(expectedUsernameErr, "userErr"));
//        Assert.assertTrue(lp.checkErr(expectedPassErr, "passErr"));
//        Assert.assertTrue(lp.checkErr(expectedAuthErr, "authErr"));
    }

//    @Test
//    public void loginPositiveTest() {
//        driver.get("https://www.kadoly.ro/autentificare");
//        LoginPage lp = new LoginPage(driver);
//        lp.verifyPage();
//        lp.login("test2@gmail.com", "12345678");
//    }
}
