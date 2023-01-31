package Pages;

import Utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class MyAddressPage extends BasePage {

    private String mainTextSelector = "#center_column > h1"; //CSS
    private String detailsTextSelector = "#center_column > p"; // CSS
    private String editAddressBtnSelector = "//*[@id=\"center_column\"]/div[2]/div/div/ul/li[11]/a[1]"; // XPath
    private String citySelector = "city"; //ID
    private String addressSelector = "address1"; //ID
    private String postalCodeSelector = "postcode"; //ID
    private String mobilePhoneSelector = "phone_mobile"; //ID
    private String saveBtnSelector = "#submitAddress"; //CSS
    private String myAddressSelector = "//*[@id=\"center_column\"]/div[2]/div/div/ul/li[5]"; //XPath

    public void verifyPage() {
        Assert.assertEquals(driver.findElement(By.cssSelector(mainTextSelector)).getText(), "ADRESELE MELE");
        Assert.assertEquals(driver.findElement(By.cssSelector(detailsTextSelector)).getText(), "Te rugam sa configurezi adresele implicite pentru livrare si facturare. Poti sa adaugi si adrese aditionale care pot fi utile cand vrei sa trimiti un cadou sau sa primesti coletul la birou.");
    }

    public void updateAddress(String city, String address, String postalCode, String phoneNo){

        WebElement editAddressBtn = driver.findElement(By.xpath(editAddressBtnSelector));
        editAddressBtn.click();

        WebElement cityInput = driver.findElement(By.id(citySelector));
        cityInput.clear();
        cityInput.sendKeys(city);

        WebElement addressInput = driver.findElement(By.id(addressSelector));
        addressInput.clear();
        addressInput.sendKeys(address);

        WebElement postalCodeInput = driver.findElement(By.id(postalCodeSelector));
        postalCodeInput.clear();
        postalCodeInput.sendKeys(postalCode);

        WebElement mobilePhoneInput = driver.findElement(By.id(mobilePhoneSelector));
        mobilePhoneInput.clear();
        mobilePhoneInput.sendKeys(phoneNo);

        WebElement saveBtn = driver.findElement(By.cssSelector(saveBtnSelector));
        saveBtn.click();
    }

    public String getMyAddressSelector() {
        WebElement myAddressCfrmText = SeleniumUtils.waitForGenericElement(driver, By.xpath(myAddressSelector), 15);
        return myAddressCfrmText.getText();
    }

    public MyAddressPage(WebDriver driver) {
        super(driver);
    }
}
