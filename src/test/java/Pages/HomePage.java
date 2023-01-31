package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage extends BasePage{

    private String contactNo = "#header_links > li.tel_top_left > a"; //CSS
    private String homePageText = "#static_home_top > div > div > div > div"; //CSS
    private String searchBar = "search_query_top"; //ID
    private String searchBarBtn = "#searchbox > button"; //CSS
    private String searchResults = "//*[@id=\"center_column\"]/h1/span[1]"; //XPath

    public void verifyPage() {
        Assert.assertEquals(driver.findElement(By.cssSelector(contactNo)).getText(), "AI NEVOIE DE AJUTOR? 0722 514 132 [L-V 09-17:00]");
        Assert.assertEquals(driver.findElement(By.cssSelector(homePageText)).getText(), "CADOURI PERSONALIZATE ȘI HANDMADE\n" +
                "La Kadoly, fiecare cadou are propria sa poveste; te invităm, cu drag, să o descoperi...\n" +
                "Adaugă personalitate și originalitate cadoului tău.");

    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void verifySearchBar(){
        WebElement searchBarInput = driver.findElement(By.id(searchBar));
        WebElement searchBarBtnInput = driver.findElement(By.cssSelector(searchBarBtn));

        searchBarInput.clear();
        searchBarInput.click();
        searchBarInput.sendKeys("cadou");
        searchBarBtnInput.click();

        Assert.assertEquals(driver.findElement(By.xpath(searchResults)).getText(), "\"CADOU\"");

    }
}




