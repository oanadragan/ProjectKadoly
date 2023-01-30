package Tests;

import Pages.RegistrationPage;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {


        @Test(priority = 1)
        public void registrationTest () {
//            driver.get("https://www.kadoly.ro/autentificare");
            RegistrationPage lp = new RegistrationPage(driver);
//            lp.verifyPage();
//            lp.registrationPage1("test@yahoo.com");
//            lp.registrationPage2("", "", "", "12345678", "",
//                    "", "", "", "123456", "12345678", "sssas", "prenume este obligatoriu.",
//                    "nume este obligatoriu", "email este obligatoriu.", "passwd este obligatoriu.",
//                    "nume este obligatoriu", "prenume este obligatoriu.", "localitate este obligatoriu.",
//                    "adr", "Cod postal invalid. Ar trebui sa fie introdus in modul urmator: 000000",
//                    "Introduceți cel puțin un număr de telefon.", "alias este obligatoriu.");

//          if (lp.getErrors().contains("prenume este obligatoriu.")) {
//            System.out.println("prenume este obligatoriu.");
//            Assert.assertTrue(lp.getErrors().contains("prenume este obligatoriu."));
//        }  if (lp.getErrors().contains("email este obligatoriu.")) {
//            System.out.println("email este obligatoriu.");
//            Assert.assertTrue(lp.getErrors().contains("email este obligatoriu."));
//        }  if (lp.getErrors().contains("passwd este obligatoriu.")) {
//        System.out.println("passwd este obligatoriu.");
//            Assert.assertTrue(lp.getErrors().contains("passwd este obligatoriu."));
//        }  if (lp.getErrors().contains("adresa este obligatoriu.")) {
//            System.out.println("adresa este obligatoriu.");
//            Assert.assertTrue(lp.getErrors().contains("adresa este obligatoriu."));
//
//        }if (lp.getErrors().contains("Cod postal invalid. Ar trebui sa fie introdus in modul urmator: 000000")) {
//            System.out.println("Cod postal invalid. Ar trebui sa fie introdus in modul urmator: 000000");
//            Assert.assertTrue(lp.getErrors().contains("Cod postal invalid. Ar trebui sa fie introdus in modul urmator: 000000"));
//        }  if (lp.getErrors().contains("Introduceți cel puțin un număr de telefon.")) {
//            System.out.println("Introduceți cel puțin un număr de telefon.");
//            Assert.assertTrue(lp.getErrors().contains("Introduceți cel puțin un număr de telefon."));
//        } if (lp.getErrors().contains("localitate este obligatoriu.")) {
//            System.out.println("localitate este obligatoriu.");
//            Assert.assertTrue(lp.getErrors().contains("localitate este obligatoriu."));
//        }  if (lp.getErrors().contains("alias este obligatoriu.")) {
//            System.out.println("alias este obligatoriu.");
//            Assert.assertTrue(lp.getErrors().contains("alias este obligatoriu."));
//        }

            //  System.out.println(lp.getErrors());


//            Assert.assertTrue(lp.checkError(lp.getEmailInfoError(), "email1Error"));
//
//            Assert.assertTrue(lp.checkError(lp.getLastNameErrorInfo(), "lastName1Error"));
//
//
//            Assert.assertTrue(lp.checkError(lp.getFirstNameErrorInfo(), "firstName1Error"));
//
//
//            Assert.assertTrue(lp.checkError(lp.getPasswordError(), "password1Error"));

//            String expectedAliasError = lp.getAliasInfoError();
//            Assert.assertTrue(lp.checkError(lp.getAliasInfoError(), "aliasError"));
//
//           String expectedAddressError = lp.getAddressInfoError();
//            Assert.assertTrue(lp.checkError(lp.getAddressInfoError(), "address1Error"));
//
//            String expectedPhoneNoError = lp.getPhoneNoError();
//            Assert.assertTrue(lp.checkError(lp.getPhoneNoError(), "phoneNoError"));
//
//            String expectedPostalCodeError = lp.getPostalCodeInfoError();
//            Assert.assertTrue(lp.checkError(lp.getPostalCodeInfoError(), "postalCodeError"));
//
//            String expectedCityError = lp.getCityInfoError();
//            Assert.assertTrue(lp.checkError(lp.getCityInfoError(), "city1Error"));


        }


//    @Test
//    public void loginNegativeTest() {
//        driver.get("https://www.kadoly.ro/autentificare");
//        RegistrationPage lp = new RegistrationPage(driver);
//        lp.verifyPage();
//        lp.loginNegative("");
//
//        String expectedEmailError = lp.getEmailErrorText();
//        Assert.assertTrue(lp.checkErr(expectedEmailError, "userErr"));
//    }





}

