package tests.structurePatternTests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import patterns.BaseProfilePageObject;
import patterns.structure.PageFactory.CreatePageFactory;
import patterns.structure.PageFactory.ProfilePageFactory;
import tests.BasicTestsSettings;
import utils.LoginData;

public class PageFactoryPatternTests extends BasicTestsSettings {
    private CreatePageFactory createPage;
    private ProfilePageFactory profilePage;
    private BaseProfilePageObject baseProfilePage;

    @BeforeTest
    public void testSetUp_f() {
        createPage = new CreatePageFactory(driver);
        profilePage = new ProfilePageFactory(driver);
        baseProfilePage = new BaseProfilePageObject(driver);
        createPage.createAccount(LoginData.dataMap);
        baseProfilePage.navigateToProfilePage();
    }

    @Test()
    public void checkTaxID_f() {
        String actualTaxID = profilePage.getTaxID();
        Assert.assertEquals(actualTaxID, LoginData.dataMap.get("taxID"), "Actual taxID is not like expected");
    }

    @Test
    public void checkFirstName_f() {
        String actualFirstName = profilePage.getFirstName();
        Assert.assertEquals(actualFirstName, LoginData.dataMap.get("firstName"), "Actual first name is not like expected");
    }

    @Test
    public void checkLastName_f() {
        String actualLastName = profilePage.getLastName();
        Assert.assertEquals(actualLastName, LoginData.dataMap.get("lastName"), "Actual last name is not like expected");
    }

    @Test
    public void checkAddress1_f() {
        String actualAddress1 = profilePage.getAddress1();
        Assert.assertEquals(actualAddress1, LoginData.dataMap.get("address1"), "Actual address1 is not like expected");
    }

    @Test
    public void checkPostcode_f() {
        String actualPostcode = profilePage.getPostCode();
        Assert.assertEquals(actualPostcode, LoginData.dataMap.get("postcode"), "Actual postcode is not like expected");
    }

    @Test
    public void checkCity_f() {
        String actualCity = profilePage.getCity();
        Assert.assertEquals(actualCity, LoginData.dataMap.get("city"), "Actual city is not like expected");
    }

    @Test
    public void checkCountry_f() {
        String actualCountry = profilePage.getCountry();
        Assert.assertEquals(actualCountry, LoginData.dataMap.get("country"), "Actual country is not like expected");
    }

    @Test
    public void checkEmail_f() {
        String actualEmail = profilePage.getEmail();
        Assert.assertTrue(actualEmail.contains(LoginData.dataMap.get("email")), "Actual email is not like expected");
    }

    @Test
    public void checkPhone_f() {
        String actualPhone = profilePage.getPhone();
        Assert.assertEquals(actualPhone, LoginData.dataMap.get("phone"), "Actual phone is not like expected");
    }


}
