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

    @BeforeTest
    public void testSetUp_po() {
        createPage = new CreatePage(driver);
        profilePage = new ProfilePage(driver);
        createPage.createAccount(LoginData.dataMap);
        profilePage.navigateTo(Urls.editAccountURL);
    }

    @Test()
    public void checkTaxID_po() {
        String actualTaxID = profilePage.getTaxID();
        Assert.assertEquals(actualTaxID, LoginData.dataMap.get("taxID"), "Actual taxID is not like expected");
    }

    @Test
    public void checkFirstName_po() {
        String actualFirstName = profilePage.getFirstName();
        Assert.assertEquals(actualFirstName, LoginData.dataMap.get("firstName"), "Actual first name is not like expected");
    }

    @Test
    public void checkLastName_po() {
        String actualLastName = profilePage.getLastName();
        Assert.assertEquals(actualLastName, LoginData.dataMap.get("lastName"), "Actual last name is not like expected");
    }

    @Test
    public void checkAddress1_po() {
        String actualAddress1 = profilePage.getAddress1();
        Assert.assertEquals(actualAddress1, LoginData.dataMap.get("address1"), "Actual address1 is not like expected");
    }

    @Test
    public void checkPostcode_po() {
        String actualPostcode = profilePage.getPostCode();
        Assert.assertEquals(actualPostcode, LoginData.dataMap.get("postcode"), "Actual postcode is not like expected");
    }

    @Test
    public void checkCity_po() {
        String actualCity = profilePage.getCity();
        Assert.assertEquals(actualCity, LoginData.dataMap.get("city"), "Actual city is not like expected");
    }

    @Test
    public void checkCountry_po() {
        String actualCountry = profilePage.getCountry();
        Assert.assertEquals(actualCountry, LoginData.dataMap.get("country"), "Actual country is not like expected");
    }

    @Test
    public void checkEmail_po() {
        String actualEmail = profilePage.getEmail();
        Assert.assertTrue(actualEmail.contains(LoginData.dataMap.get("email")), "Actual email is not like expected");
    }

    @Test
    public void checkPhone_po() {
        String actualPhone = profilePage.getPhone();
        Assert.assertEquals(actualPhone, LoginData.dataMap.get("phone"), "Actual phone is not like expected");
    }
}