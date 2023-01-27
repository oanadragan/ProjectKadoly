package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SelectPage extends BasePage{


    private String menSelector = "#fieldmegamenu-main > ul > li.root.root-17.categorii_cadouri > div > div"; // CSS
    private String menGifts = "//*[@id=\"fieldmegamenu-main\"]/ul/li[1]/ul/li[1]/div/a"; // XPath

    private String resultsMenGifts = "#center_column > h1 > span.cat-name"; // CSS

    public SelectPage(WebDriver driver) {
        super(driver);
    }

    public void hoverButtonInteract() {
        WebElement hoverButton = driver.findElement(By.cssSelector(menSelector));
//        hoverButton.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverButton).build().perform();
        driver.findElement(By.xpath(menGifts)).click();
        Assert.assertEquals(driver.findElement(By.cssSelector(resultsMenGifts)).getText(), "CADOURI BARBATI ");
    }
}
