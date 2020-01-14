package tests.structurePatternTests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import patterns.structure.LoadableComponent.CreatePageLoadableComponent;
import patterns.structure.LoadableComponent.HomePageLoadableComponent;
import patterns.structure.LoadableComponent.ProfilePageLoadableComponent;
import tests.BasicTestsSettings;
import utils.LoginData;

public class LoadableComponentPatternTests extends BasicTestsSettings {
    private HomePageLoadableComponent homePage;
    private CreatePageLoadableComponent createPage;
    private ProfilePageLoadableComponent profilePage;

    @BeforeTest
    public void testSetUp_lc() {
        homePage = new HomePageLoadableComponent(driver);
        createPage = new CreatePageLoadableComponent(driver, homePage);
        profilePage = new ProfilePageLoadableComponent(driver);
        createPage.get();
        createPage.createAccount(LoginData.dataMap);
        profilePage.get();
    }

    @Test()
    public void checkTaxID_lc() {
        String actualTaxID = profilePage.getTaxID();
        Assert.assertEquals(actualTaxID, LoginData.dataMap.get("taxID"), "Actual taxID is not like expected");
    }

    @Test
    public void checkFirstName_lc() {
        String actualFirstName = profilePage.getFirstName();
        Assert.assertEquals(actualFirstName, LoginData.dataMap.get("firstName"), "Actual first name is not like expected");
    }

    @Test
    public void checkLastName_lc() {
        String actualLastName = profilePage.getLastName();
        Assert.assertEquals(actualLastName, LoginData.dataMap.get("lastName"), "Actual last name is not like expected");
    }

    @Test
    public void checkAddress1_lc() {
        String actualAddress1 = profilePage.getAddress1();
        Assert.assertEquals(actualAddress1, LoginData.dataMap.get("address1"), "Actual address1 is not like expected");
    }

    @Test
    public void checkPostcode_lc() {
        String actualPostcode = profilePage.getPostCode();
        Assert.assertEquals(actualPostcode, LoginData.dataMap.get("postcode"), "Actual postcode is not like expected");
    }

    @Test
    public void checkCity_lc() {
        String actualCity = profilePage.getCity();
        Assert.assertEquals(actualCity, LoginData.dataMap.get("city"), "Actual city is not like expected");
    }

    @Test
    public void checkCountry_lc() {
        String actualCountry = profilePage.getCountry();
        Assert.assertEquals(actualCountry, LoginData.dataMap.get("country"), "Actual country is not like expected");
    }

    @Test
    public void checkEmail_lc() {
        String actualEmail = profilePage.getEmail();
        Assert.assertTrue(actualEmail.contains(LoginData.dataMap.get("email").toLowerCase()), "Actual email is not like expected");
    }

    @Test
    public void checkPhone_lc() {
        String actualPhone = profilePage.getPhone();
        Assert.assertEquals(actualPhone, LoginData.dataMap.get("phone"), "Actual phone is not like expected");
    }
}
