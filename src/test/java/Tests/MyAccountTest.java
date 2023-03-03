package Tests;

import Pages.*;

import org.testng.Assert;
import org.testng.annotations.Test;


public class MyAccountTest extends BaseTest{

    @Test(groups = {"Smoke"})
    public void generalHomePage() {
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
        myPage.verifyMyAccountPage();
    }

    @Test(groups = {"Smoke"}, dependsOnMethods = "myHomePage")
    public void historyTest() {
        MyAccountPage myPage = new MyAccountPage(driver);
        myPage.goToMyAccount();
        myPage.goToMyHistory();
        HistoryPage historyPage = new HistoryPage(driver);
        historyPage.verifyHistoryPage();
        historyPage.clickGoBackBtn();
    }

    @Test (groups = {"Smoke"}, dependsOnMethods = "myHomePage")
    public void changePersonalInfoTest() {
        MyAccountPage myPage = new MyAccountPage(driver);
        myPage.goToMyAccount();
        myPage.goToPersonalInfo();
        PersonalInfoEditPage acEditPage = new PersonalInfoEditPage(driver);
        acEditPage.verifyInfoPage();
        acEditPage.editAccountDetails("O", "D", "test2@gmail.com", "12345678");
        Assert.assertEquals(acEditPage.getConfirmationTextSelector(), "Informatile personale au fost actualizate.");
    }

    @Test(groups = {"Smoke"}, dependsOnMethods = "myHomePage")
    public void updateAddressTest() {
        MyAccountPage myPage = new MyAccountPage(driver);
        myPage.goToMyAccount();
        myPage.gotToMyAddress();
        MyAddressPage ap = new MyAddressPage(driver);
        ap.verifyPage();
        ap.updateAddress("Giroc", "Strada 1", "111111", "1234512345" );
        Assert.assertEquals(ap.getMyAddressSelector(), "Giroc, Strada 1");
    }

}


