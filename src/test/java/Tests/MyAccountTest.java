package Tests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountTest extends BaseTest{

    @Test
    public void generalHomePage(){
        driver.get(baseUrl);
        HomePage hp = new HomePage(driver);
        hp.verifyPage();
        hp.verifySearchBar();
    }

    @Test(groups = {"Smoke"})
    public void myHomePage() {
        driver.get(baseUrl + "/autentificare");
        LoginPage lp = new LoginPage(driver);
        lp.login("test2@gmail.com", "12345678");
        MyAccountPage myPage = new MyAccountPage(driver);
        myPage.goToMyAccount();
        Assert.assertEquals(myPage.getMyAccountText(), "Bine ai venit in contul tau Kadoly. Aici iti poti administra datele personale si comenzile.");
    }

    @Test(groups = {"Smoke"}, dependsOnMethods = "myHomePage")
    public void historyTest() {
        MyAccountPage myPage = new MyAccountPage(driver);
        myPage.goToMyAccount();
        myPage.goToMyHistory();
        HistoryPage historyPage = new HistoryPage(driver);
        Assert.assertEquals(historyPage.getMainText(), "ISTORIC COMENZI");
        Assert.assertEquals(historyPage.getDetailsText(), "Comenzile pe care le-ai lansat de cand ti-ai creat un cont Kadoly.");
        Assert.assertEquals(historyPage.getHistoryText(), "Nu ai lansat nicio comanda.");
        historyPage.clickGoBackBtn();
    }

    @Test (groups = {"Smoke"}, dependsOnMethods = "myHomePage")
    public void changePersonalInfoTest(){
        MyAccountPage myPage = new MyAccountPage(driver);
        myPage.goToMyAccount();
        myPage.goToPersonalInfo();
        PersonalInfoEditPage acEditPage = new PersonalInfoEditPage(driver);
        acEditPage.verifyInfoPage();
        acEditPage.editAccountDetails("Oana", "Dragan", "test2@gmail.com", "12345678");

        Assert.assertEquals(acEditPage.getConfirmationTextSelector(), "Informatile personale au fost actualizate.");
    }

    @Test
    public void updateAddressTest(){
        driver.get(baseUrl + "/autentificare");
        LoginPage lp = new LoginPage(driver);
        lp.login("test2@gmail.com", "12345678");
        MyAccountPage myPage = new MyAccountPage(driver);
        myPage.goToMyAccount();
        myPage.gotToMyAddress();
        MyAddressPage ap = new MyAddressPage(driver);
        ap.verifyPage();
        ap.updateAddress("Giroc", "Strada", "111111", "1234512345" );
        Assert.assertEquals(ap.getMyAddressSelector(), "Giroc, Strada");
    }

}


