package Pages;

import Utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SelectPage extends BasePage{


    private String menSelector = "#fieldmegamenu-main > ul > li.root.root-17.categorii_cadouri > div > div"; // CSS
    private String menGifts = "#fieldmegamenu-main > ul > li.root.root-17.categorii_cadouri > ul > li.menu-item.menu-item-90.depth-1.category > div > a"; // CSS

    private String resultsMenGifts = "#center_column > h1 > span.cat-name"; // CSS

    public SelectPage(WebDriver driver) {
        super(driver);
    }

    public void hoverButtonInteract() {
        WebElement hoverButton = driver.findElement(By.cssSelector(menSelector));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverButton).build().perform();
        WebElement menGiftsElement = SeleniumUtils.waitForGenericElement(driver,
                By.cssSelector(menGifts), 15);
//        menGiftsElement.click();

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", menGiftsElement);
        WebElement resultsMenGiftsElement = SeleniumUtils.waitForGenericElement(driver,
                By.cssSelector(resultsMenGifts), 15);

        Assert.assertEquals(resultsMenGiftsElement.getText(), "CADOURI BARBATI ");
    }
}
