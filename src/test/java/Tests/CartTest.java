package Tests;

import ObjectModels.LoginModel;
import Pages.*;
import Utils.ConstantUtils;
import Utils.DataUtils;
import Utils.ExtentTestManager;
import Utils.Tools;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import io.restassured.path.json.JsonPath;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class CartTest extends BaseTest{

    @Test(groups = {"Cart"}, dataProviderClass = DataUtils.class, dataProvider = "cartDataProvider")
    public void addToCartTest(HashMap<String, String> hashMap) throws IOException {
        driver.get("https://www.kadoly.ro/");
        SelectPage select = new SelectPage(driver);
        select.hoverButtonInteract();
        AddToCartPage add = new AddToCartPage(driver);
        add.sortProducts(hashMap.get("Filter Products"));
        add.selectProduct();
        add.productLabel();
        add.addToCart();
        Assert.assertTrue(add.confirmText().contains(hashMap.get("Add to cart text")));
    }

    @Test(groups = {"Cart"}, dependsOnMethods = "addToCartTest", dataProviderClass = DataUtils.class,
            dataProvider = "checkCartDp")
    public void checkCart(HashMap<String, String> hashMap) {
        CheckCartPage chk = new CheckCartPage(driver);
        chk.closeConfirmWin();
        Assert.assertEquals(chk.getCartCount(), hashMap.get("Cart Qty"));
        chk.goToCheckOut();

        Assert.assertEquals(chk.getTotalPriceSelector(), hashMap.get("Total Price"));
        Assert.assertEquals(chk.getTransportPriceSelector(), hashMap.get("Transport Price"));
        Assert.assertEquals(chk.getFinalPriceSelector(),  hashMap.get("Final Price"));
    }


    @Test(groups = {"Cart"}, dependsOnMethods = "addToCartTest", dataProviderClass = DataUtils.class,
            dataProvider = "checkCartDp")
    public void deleteCart(HashMap<String, String> hashMap) {
        CheckCartPage chk = new CheckCartPage(driver);
        chk.deleteProducts();
        try{
            Thread.sleep(10000);
        }
        catch(InterruptedException ie){
        }
        Assert.assertEquals(chk.getDeleteProductsText(), hashMap.get("Delete Cart"));
    }
}
