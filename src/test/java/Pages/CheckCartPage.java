package Pages;

import Utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckCartPage extends BasePage{

    private String goToCart = "#layer_cart > div.layer_cart_cart.col-xs-12 > div > a"; // CSS
    private String closeConfirmWindow = "#layer_cart > div.clearfix > div.layer_cart_product.col-xs-12.col-md-6 > span";//CSS
    private String priceSelector = "#product_price_4183_0_54564"; // CSS
    private String totalPriceSelector = "total_product"; // CSS

    private String totalProductsSelector = "#product_price_4183_0_54564"; // CSS
    private String transportPriceSelector = "total_shipping"; // CSS
    private String finalPriceSelector = "total_price"; // ID

    private String deleteBtnSelector = "4183_0_0_54574"; // ID

    private String cartCount = "#sticky_top > div.shopping_cart_right.col-md-3.clearfix > div > a > span.ajax_cart_quantity"; //CSS
    private String deleteProductsText = "#center_column > div"; // Css

    public CheckCartPage(WebDriver driver) {
        super(driver);
    }


    public String getPriceSelector() {
        return driver.findElement(By.cssSelector(priceSelector)).getText();
    }

    public String getTotalPriceSelector() {
        return driver.findElement(By.id(totalPriceSelector)).getText();
    }

    public String getTotalProductsSelector() {
        return driver.findElement(By.cssSelector(totalProductsSelector)).getText();
    }

    public String getTransportPriceSelector() {
        return driver.findElement(By.id(transportPriceSelector)).getText();
    }

    public String getFinalPriceSelector() {
        return driver.findElement(By.id(finalPriceSelector)).getText();
    }

    public String getCartCount(){
        WebElement cartCountText = SeleniumUtils.waitForGenericElement(driver, By.cssSelector(cartCount), 10);
        return cartCountText.getText();
    }

    public String getDeleteProductsText() {
        WebElement confirmDeletePrd = SeleniumUtils.waitForGenericElement(driver, By.cssSelector(deleteProductsText), 70);
        return confirmDeletePrd.getText();
    }

    public void goToCheckOut(){
        WebElement goToCartBtn = driver.findElement(By.cssSelector(goToCart));
        goToCartBtn.click();
    }

    public void deleteProducts(){
        WebElement baseTable = driver.findElement(By.className("supercheckout-summary"));
        WebElement tableRow = baseTable.findElement(By.xpath("//th[6]")); //should be the third row
        WebElement cellIneed = tableRow.findElement(By.xpath("//td[6]"));
        cellIneed.click();

//       JavascriptExecutor executor = (JavascriptExecutor)driver;
//        WebElement deleteBtn = driver.findElement(By.id(deleteBtnSelector));
//       executor.executeScript("arguments[0].click();", deleteBtn);
//        deleteBtn.click();
    }

    public void closeConfirmWin(){
        WebElement closeCfmWin = driver.findElement(By.cssSelector(closeConfirmWindow));
        closeCfmWin.click();
    }
}
