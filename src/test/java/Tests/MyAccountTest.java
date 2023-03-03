package Tests;

import Pages.*;

import Utils.DataUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;


public class MyAccountTest extends BaseTest{

    @Test(groups = {"Smoke"})
    public void generalHomePage() {
        driver.get(baseUrl);
        HomePage hp = new HomePage(driver);
        hp.verifyPage();
        hp.verifySearchBar();
    }

    @Test(groups = {"Smoke"}, dataProviderClass = DataUtils.class,
            dataProvider = "accountTestDp")
    public void myHomePage(HashMap<String, String> hashMap) {
        driver.get(baseUrl + "/autentificare");
        LoginPage lp = new LoginPage(driver);
        lp.login(hashMap.get("email"), hashMap.get("password"));
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

    @Test (groups = {"Smoke"}, dependsOnMethods = "myHomePage", dataProviderClass = DataUtils.class,
            dataProvider = "accountTestDp")
    public void changePersonalInfoTest(HashMap<String, String> hashMap) {
        MyAccountPage myPage = new MyAccountPage(driver);
        myPage.goToMyAccount();
        myPage.goToPersonalInfo();
        PersonalInfoEditPage acEditPage = new PersonalInfoEditPage(driver);
        acEditPage.verifyInfoPage();
        acEditPage.editAccountDetails(hashMap.get("first name"), hashMap.get("last name"),
                hashMap.get("email"), hashMap.get("password"));
        Assert.assertEquals(acEditPage.getConfirmationTextSelector(), hashMap.get("conf text"));
    }

    @Test(groups = {"Smoke"}, dependsOnMethods = "myHomePage", dataProviderClass = DataUtils.class,
            dataProvider = "accountTestDp")
    public void updateAddressTest(HashMap<String, String> hashMap) {
        MyAccountPage myPage = new MyAccountPage(driver);
        myPage.goToMyAccount();
        myPage.gotToMyAddress();
        MyAddressPage ap = new MyAddressPage(driver);
        ap.verifyPage();
        ap.updateAddress(hashMap.get("city"), hashMap.get("address"), hashMap.get("postal code"), hashMap.get("phone no") );
        Assert.assertEquals(ap.getMyAddressSelector(), hashMap.get("full address"));
    }

}


