package Tests;

import Pages.RegistrationModel;
import Pages.RegistrationPage;
import Utils.Tools;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class RegistrationDataTest extends BaseTest {

    @DataProvider(name = "SQLdp")
    public Iterator<Object[]> SQLDpCollection() {
        //        get DB connection settings
        System.out.println("Use dbHostname:" + dbHostname);
        System.out.println("Use dbUser:" + dbUser);
        System.out.println("Use dbPort:" + dbPort);
        System.out.println("Use dbPassword:" + dbPassword);
        System.out.println("Use dbSchema:" + dbSchema);

        Collection<Object[]> dp = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://" + dbHostname + ":" + dbPort
                    + "/" + dbSchema, dbUser, new String(base64.decode(dbPassword.getBytes())));

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM registration");
            while (resultSet.next()) {
                RegistrationModel rm = new RegistrationModel(getEscapedElement(resultSet, "firstName1"),
                        getEscapedElement(resultSet, "lastName1"),
                        getEscapedElement(resultSet, "email1"),
                        getEscapedElement(resultSet, "password1"),
                        getEscapedElement(resultSet, "lastName2"),
                        getEscapedElement(resultSet, "firstName2"),
                        getEscapedElement(resultSet, "city1"),
                        getEscapedElement(resultSet, "address1"),
                        getEscapedElement(resultSet, "postalCode"),
                        getEscapedElement(resultSet, "mobilePhoneNo"),
                        getEscapedElement(resultSet, "aliasAddress"),
                        getEscapedElement(resultSet, "firstName1Error"),
                        getEscapedElement(resultSet, "lastName1Error"),
                        getEscapedElement(resultSet, "email1Error"),
                        getEscapedElement(resultSet, "password1Error"),
                        getEscapedElement(resultSet, "lastName2Error"),
                        getEscapedElement(resultSet, "firstName2Error"),
                        getEscapedElement(resultSet, "city1Error"),
                        getEscapedElement(resultSet, "address1Error"),
                        getEscapedElement(resultSet, "postalCodeError"),
                        getEscapedElement(resultSet, "phoneNoError"),
                        getEscapedElement(resultSet, "aliasError"));
                dp.add(new Object[]{rm});
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dp.iterator();
    }

    private String getEscapedElement(ResultSet resultSet, String element) throws SQLException {
        return Tools.replaceElements(resultSet.getString(element), "''", "");
    }

    @Test(dataProvider = "SQLdp" , groups = {"Smoke"})
    public void registerWithDBTest(RegistrationModel rm) {
        RegistrationPage rp = new RegistrationPage(driver);
        driver.get(baseUrl + "/autentificare");
        rp.verifyPage();
        rp.registrationPage1("test@yahoo.com");

//         registration
        rp.registration(rm.getRegistrationAccountModel().getFirstName1(), rm.getRegistrationAccountModel().getLastName1(),
        rm.getRegistrationAccountModel().getEmail1(), rm.getRegistrationAccountModel().getPassword1(),
        rm.getRegistrationAccountModel().getLastName2(), rm.getRegistrationAccountModel().getFirstName2(),
        rm.getRegistrationAccountModel().getCity1(), rm.getRegistrationAccountModel().getAddress1(),
        rm.getRegistrationAccountModel().getPostalCode(), rm.getRegistrationAccountModel().getMobilePhoneNo(),
        rm.getRegistrationAccountModel().getAliasAddress());

        System.out.println("Login button was pressed");

        String expectedLastNameError = rm.getLastName1Error();
        String expectedFirstNameError = rm.getFirstName1Error();
        String expectedEmailError = rm.getEmail1Error();
        String expectedPasswordError = rm.getPassword1Error();
        String expectedLastName2Error = rm.getLastName2Error();
        String expectedFirstName2Error = rm.getFirstName2Error();
        String expectedCityError = rm.getCity1Error();
        String expectedAddressError = rm.getAddress1Error();
        String expectedPostalCodeError = rm.getPostalCodeError();
        String expectedPhoneNoError = rm.getPhoneNoError();
        String expectedAliasError = rm.getAliasError();

        System.out.println("Verify expected errors present:\n expected userError:" + expectedFirstNameError);
        Assert.assertTrue(rp.checkError(expectedFirstNameError, "firstName1Error"));

        System.out.println("Expected Password Err:" + expectedLastNameError);
        Assert.assertTrue(rp.checkError(expectedLastNameError, "lastName1Error"));

        System.out.println("Verify expected errors present:\n expected userError:" + expectedEmailError);
        Assert.assertTrue(rp.checkError(expectedEmailError, "email1Error"));

        System.out.println("Expected Password Err:" + expectedPasswordError);
        Assert.assertTrue(rp.checkError(expectedPasswordError, "password1Error"));

        System.out.println("Verify expected errors present:\n expected userError:" + expectedLastName2Error);
        Assert.assertTrue(rp.checkError(expectedLastName2Error, "lastName2Error"));

        System.out.println("Expected Password Err:" + expectedFirstName2Error);
        Assert.assertTrue(rp.checkError(expectedFirstName2Error, "firstName2Error"));

        System.out.println("Verify expected errors present:\n expected userError:" + expectedCityError);
        Assert.assertTrue(rp.checkError(expectedCityError, "city1Error"));

        System.out.println("Expected Password Err:" + expectedAddressError);
        Assert.assertTrue(rp.checkError(expectedAddressError, "address1Error"));

        System.out.println("Verify expected errors present:\n expected userError:" + expectedPostalCodeError);
        Assert.assertTrue(rp.checkError(expectedPostalCodeError, "postalCodeError"));

        System.out.println("Verify expected errors present:\n expected userError:" + expectedPhoneNoError);
        Assert.assertTrue(rp.checkError(expectedPhoneNoError, "phoneNoError"));

        System.out.println("Expected Password Err:" + expectedAliasError);
        Assert.assertTrue(rp.checkError(expectedAliasError, "aliasError"));


    }

}
