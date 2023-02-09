package Tests;

import Pages.*;
import Utils.ExtentTestManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class CartTest extends BaseTest{

    @Test(groups = {"Cart"})
    public void addToCartTest(Method method) {
        test = ExtentTestManager.startTest(method.getName(), "add to cart");
        driver.get("https://www.kadoly.ro/");
        SelectPage select = new SelectPage(driver);
        select.hoverButtonInteract();
        AddToCartPage add = new AddToCartPage(driver);
        add.sortProducts("Pret: Cel mai mic primul");
        add.selectProduct();
        add.productLabel();
        add.addToCart();
        Assert.assertTrue(add.confirmText().contains("PRODUS ADĂUGAT CU SUCCES LA COŞUL DVS."));

    }

    @Test(groups = {"Cart"}, dependsOnMethods = "addToCartTest")
    public void checkCart(Method method) {
        test = ExtentTestManager.startTest(method.getName(), "check cart");
        CheckCartPage chk = new CheckCartPage(driver);
        chk.closeConfirmWin();
        Assert.assertEquals(chk.getCartCount(), "1");
        chk.goToCheckOut();

        Assert.assertEquals(chk.getTotalPriceSelector(), "29,00 lei");
        Assert.assertEquals(chk.getTransportPriceSelector(), "20,00 lei");
        Assert.assertEquals(chk.getFinalPriceSelector(), "49,00 lei");
    }


    @Test(groups = {"Cart"}, dependsOnMethods = "addToCartTest")
    public void deleteCart(Method method) {
        test = ExtentTestManager.startTest(method.getName(), "delete products from cart");
        CheckCartPage chk = new CheckCartPage(driver);
        chk.deleteProducts();
        try{
            Thread.sleep(10000);
        }
        catch(InterruptedException ie){
        }
        Assert.assertEquals(chk.getDeleteProductsText(), "Cosul tau este gol.");
    }
}
