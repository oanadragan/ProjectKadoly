package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HistoryPage extends BasePage{
    private String mainText = "#center_column > h1"; //CSS
    private String detailsText = "#center_column > p"; // CSS
    private String historyText = "#block-history"; // CSS

    private String goBackBtn = "#center_column > ul > li:nth-child(1) > a";//CSS


    public HistoryPage(WebDriver driver) {
        super(driver);
    }

    public String getMainText() {
        return driver.findElement(By.cssSelector(mainText)).getText();
    }

    public String getDetailsText() {
        return driver.findElement(By.cssSelector(detailsText)).getText();
    }

    public String getHistoryText() {
        return driver.findElement(By.cssSelector(historyText)).getText();
    }

    public void clickGoBackBtn() {
        driver.findElement(By.cssSelector(goBackBtn)).click();
    }
}
