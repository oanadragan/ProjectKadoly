package Tests;

import Pages.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountTest extends BaseTest{

    @Test
    public void generalHomePage(){
        driver.get("https://www.kadoly.ro/");
        HomePage hp = new HomePage(driver);
        hp.verifyPage();
        hp.verifySearchBar();
    }

    @Test(groups = {"Smoke"})
    public void MyHomePage() {
        driver.get(baseUrl + "/autentificare");
        LoginPage lp = new LoginPage(driver);
        lp.login("test2@gmail.com", "12345678");
        MyAccountPage myPage = new MyAccountPage(driver);
        myPage.goToMyAccount();
        Assert.assertEquals(myPage.getMyAccountText(), "Bine ai venit in contul tau Kadoly. Aici iti poti administra datele personale si comenzile.");
    }

    @Test(groups = {"Smoke"}, dependsOnMethods = "MyHomePage")
    public void HistoryTest() {
        MyAccountPage myPage = new MyAccountPage(driver);
        myPage.goToMyAccount();
        myPage.goToMyHistory();
        HistoryPage historyPage = new HistoryPage(driver);
        Assert.assertEquals(historyPage.getMainText(), "ISTORIC COMENZI");
        Assert.assertEquals(historyPage.getDetailsText(), "Comenzile pe care le-ai lansat de cand ti-ai creat un cont Kadoly.");
        Assert.assertEquals(historyPage.getHistoryText(), "Nu ai lansat nicio comanda.");
        historyPage.clickGoBackBtn();

    }

}


