package Pages;

import Utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddToCartPage extends BasePage {

    private String filterBtn = "#selectProductSort"; // CSS
    private String sortText = "#productsSortForm > div > label"; //CSS
    private String productSelector = "#center_column > div.hide-color-options.hide-stock-info.hide-quickview > ul > li:nth-child(1)"; //CSS
    private String addToCartSelector = "#add_to_cart > button"; //CSS
    private String productDescription = "#center_column > div:nth-child(2) > div.primary_block.row > div.pb-center-column.col-xs-12.col-sm-7.col-md-7 > h1"; //CSS
    private String confirmSelector = "#layer_cart > div:nth-child(1)"; //CSS

    private String confirmCartSelector= "#sticky_top > div.shopping_cart_right.col-md-3.clearfix > div > a"; //CSS


    public AddToCartPage(WebDriver driver) {
        super(driver);
    }


    public void sortProducts(String filter) {
        Assert.assertEquals(driver.findElement(By.cssSelector(sortText)).getText(), "Sorteaza dupa");
        Select dropdown = new Select(driver.findElement(By.cssSelector(filterBtn)));
        dropdown.selectByVisibleText(filter);
    }

    public void selectProduct(){
        WebElement productEl = SeleniumUtils.waitForGenericElement(driver,
                By.cssSelector(productSelector), 25);
        productEl.click();


    }
    public String productLabel() {
        WebElement productDescriptionText = SeleniumUtils.waitForGenericElement(driver,
                By.cssSelector(productDescription), 5);
        return productDescriptionText.getText();

    }
    public void addToCart() {
        WebElement addToCartBtn = driver.findElement(By.cssSelector(addToCartSelector));
        addToCartBtn.click();
//        WebElement addToCartBtn2 = SeleniumUtils.waitForGenericElement(driver,
//                By.cssSelector("#layer_cart"), 5);
//        JavascriptExecutor executor = (JavascriptExecutor)driver;
//        executor.executeScript("arguments[0].click();", addToCartBtn2);
       // addToCartBtn2.click();
    }

    public String confirmText(){
        WebElement productDescriptionText = SeleniumUtils.waitForGenericElement(driver,
                By.cssSelector("#layer_cart"), 45);
        return productDescriptionText.getText();
    }

//    public String confirmCart(){
//        WebDriverWait wait = new WebDriverWait(driver, 15);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(confirmCartSelector)));
//        return driver.findElement(By.cssSelector(confirmCartSelector)).getText();
//    }



}