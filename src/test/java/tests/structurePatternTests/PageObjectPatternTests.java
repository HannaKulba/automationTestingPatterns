package tests.structurePatternTests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import patterns.structure.PageObject.CreatePage;
import patterns.structure.PageObject.ProfilePage;
import tests.BasicTestsSettings;
import utils.LoginData;
import utils.Urls;


public class PageObjectPatternTests extends BasicTestsSettings {
    private CreatePage createPage;
    private ProfilePage profilePage;

    private String eTaxID = LoginData.taxID;
    private String eFirstName = LoginData.firstName;
    private String eLastName = LoginData.lastName;
    private String eAddress1 = LoginData.address1;
    private String ePostcode = LoginData.postcode;
    private String eCity = LoginData.city;
    private String eCountry = LoginData.country;
    private String eEmail = LoginData.email + Math.random();
    private String ePhone = LoginData.phone;
    private String pass = LoginData.pass;

    @BeforeTest
    public void testSetUp_po() {
        createPage = new CreatePage(driver);
        profilePage = new ProfilePage(driver);
        createPage.createAccount(eTaxID, eFirstName, eLastName, eAddress1, ePostcode, eCity, eCountry, eEmail, ePhone, pass);
        profilePage.navigateTo(Urls.editAccountURL);
    }

    @Test()
    public void checkTaxID_po() {
        String actualTaxID = profilePage.getTaxID();
        Assert.assertEquals(actualTaxID, eTaxID, "Actual taxID is not like expected");
    }

    @Test
    public void checkFirstName_po() {
        String actualFirstName = profilePage.getFirstName();
        Assert.assertEquals(actualFirstName, eFirstName, "Actual first name is not like expected");
    }

    @Test
    public void checkLastName_po() {
        String actualLastName = profilePage.getLastName();
        Assert.assertEquals(actualLastName, eLastName, "Actual last name is not like expected");
    }

    @Test
    public void checkAddress1_po() {
        String actualAddress1 = profilePage.getAddress1();
        Assert.assertEquals(actualAddress1, eAddress1, "Actual address1 is not like expected");
    }

    @Test
    public void checkPostcode_po() {
        String actualPostcode = profilePage.getPostCode();
        Assert.assertEquals(actualPostcode, ePostcode, "Actual postcode is not like expected");
    }

    @Test
    public void checkCity_po() {
        String actualCity = profilePage.getCity();
        Assert.assertEquals(actualCity, eCity, "Actual city is not like expected");
    }

    @Test
    public void checkCountry_po() {
        String actualCountry = profilePage.getCountry();
        Assert.assertEquals(actualCountry, eCountry, "Actual country is not like expected");
    }

    @Test
    public void checkEmail_po() {
        String actualEmail = profilePage.getEmail();
        Assert.assertEquals(actualEmail, eEmail.toLowerCase(), "Actual email is not like expected");
    }

    @Test
    public void checkPhone_po() {
        String actualPhone = profilePage.getPhone();
        Assert.assertEquals(actualPhone, ePhone, "Actual phone is not like expected");
    }
}