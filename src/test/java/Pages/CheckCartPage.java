package Pages;

import Utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckCartPage extends BasePage{

    private String goToCart = "#layer_cart > div.layer_cart_cart.col-xs-12 > div > a"; // CSS
    private String closeConfirmWindow = "#layer_cart > div.layer_cart_cart.col-xs-12 > div > span > span";//CSS
    private String totalPriceSelector = "total_product"; // CSS
    private String transportPriceSelector = "total_shipping"; // CSS
    private String finalPriceSelector = "total_price"; // ID
    private String cartCount = "ajax_cart_quantity"; //class
    private String deleteProductsText = "#center_column > div"; // Css



    public CheckCartPage(WebDriver driver) {
        super(driver);
    }


    public String getTotalPriceSelector() {
        return driver.findElement(By.id(totalPriceSelector)).getText();
    }

    public String getTransportPriceSelector() {
        return driver.findElement(By.id(transportPriceSelector)).getText();
    }

    public String getFinalPriceSelector() {
        return driver.findElement(By.id(finalPriceSelector)).getText();
    }

    public String getCartCount(){
        WebElement cartCountText = SeleniumUtils.waitForGenericElement(driver, By.className(cartCount), 10);
        return cartCountText.getText();
    }

    public String getDeleteProductsText() {

        WebElement confirmDeletePrd = SeleniumUtils.waitForGenericElement(driver, By.cssSelector(deleteProductsText),
                70);
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
    }

    public void closeConfirmWin(){
        WebElement closeCfmWin = driver.findElement(By.cssSelector(closeConfirmWindow));
        closeCfmWin.click();
    }
}
