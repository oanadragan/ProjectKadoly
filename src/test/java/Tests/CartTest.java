package Tests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest{

    @Test (groups = {"Regression"})
    public void loginTest() {
        driver.get(baseUrl + "/autentificare");
        LoginPage lp = new LoginPage(driver);
        lp.login("test2@gmail.com", "12345678");

    }

    @Test(groups = {"Regression"}, dependsOnMethods = "loginTest")
    public void addToCartTest() {
    //    driver.get(baseUrl);
        SelectPage select = new SelectPage(driver);
        select.hoverButtonInteract();
        AddToCartPage add = new AddToCartPage(driver);
        add.sortProducts("Pret: Cel mai mic primul");
        add.selectProduct();
        Assert.assertEquals(add.productLabel(), "PIX PERSONALIZAT IN CUTIE CILINDRICA");
        add.addToCart();
        Assert.assertTrue(add.confirmText().contains("PRODUS ADĂUGAT CU SUCCES LA COŞUL DVS."));
//        CheckCartPage chk = new CheckCartPage(driver);
//        chk.closeConfirmWin();
//        Assert.assertEquals(chk.getCartCount(), "1");
    }

    @Test(groups = {"Regression"}, dependsOnMethods = "addToCartTest")
    public void checkCart(){
        CheckCartPage chk = new CheckCartPage(driver);
        chk.closeConfirmWin();
        Assert.assertEquals(chk.getCartCount(), "1");
        chk.goToCheckOut();

        Assert.assertEquals(chk.getTotalPriceSelector(), "29,00 lei");
        Assert.assertEquals(chk.getTransportPriceSelector(), "20,00 lei");
        Assert.assertEquals(chk.getFinalPriceSelector(), "49,00 lei");
    }


    @Test(groups = {"Regression"}, dependsOnMethods = "addToCartTest")
    public void deleteCart(){
//        driver.get(baseUrl);
//        SelectPage select = new SelectPage(driver);
//        select.hoverButtonInteract();
//        AddToCartPage add = new AddToCartPage(driver);
//        add.sortProducts("Pret: Cel mai mic primul");
//        add.selectProduct();
//        add.addToCart();
        CheckCartPage chk = new CheckCartPage(driver);
//        chk.closeConfirmWin();
//        chk.goToCheckOut();
//        Assert.assertEquals(chk.getQuantitySelector(), "1");
//        Assert.assertEquals(chk.getTotalPriceSelector(), "29,00");
//        Assert.assertEquals(chk.getTransportPriceSelector(), "20");
//        Assert.assertEquals(chk.getFinalPriceSelector(), "49,00");
        chk.deleteProducts();
        try{
            Thread.sleep(10000);
        }
        catch(InterruptedException ie){
        }

        Assert.assertEquals(chk.getDeleteProductsText(), "Cosul tau este gol.");
    }
}
