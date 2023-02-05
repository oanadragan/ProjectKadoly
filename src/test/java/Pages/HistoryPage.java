package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HistoryPage extends BasePage{
    private String mainText = "#center_column > h1"; //CSS
    private String detailsText = "#center_column > p"; // CSS
    private String historyText = "#block-history"; // CSS

    private String goBackBtn = "#center_column > ul > li:nth-child(1) > a";//CSS


    public HistoryPage(WebDriver driver) {
        super(driver);
    }

    public void verifyHistoryPage(){

        Assert.assertEquals(driver.findElement(By.cssSelector(mainText)).getText(), "ISTORIC COMENZI");
        Assert.assertEquals(driver.findElement(By.cssSelector(detailsText)).getText(), "Comenzile pe care le-ai lansat de cand ti-ai creat un cont Kadoly.");
        Assert.assertEquals(driver.findElement(By.cssSelector(historyText)).getText(), "Nu ai lansat nicio comanda.");
    }

    public void clickGoBackBtn() {
        driver.findElement(By.cssSelector(goBackBtn)).click();
    }
}
