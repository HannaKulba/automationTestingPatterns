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
    private String eEmail = LoginData.email + Math.random();

    @BeforeTest
    public void testSetUp_lc() {
        homePage = new HomePageLoadableComponent(driver);
        createPage = new CreatePageLoadableComponent(driver, homePage);
        profilePage = new ProfilePageLoadableComponent(driver);
        createPage.get();
        createPage.createAccount(LoginData.taxID, LoginData.firstName, LoginData.lastName, LoginData.address1,
                LoginData.postcode, LoginData.city, LoginData.country, eEmail, LoginData.phone, LoginData.pass);
        profilePage.get();
    }

    @Test()
    public void checkTaxID_lc() {
        String actualTaxID = profilePage.getTaxID();
        Assert.assertEquals(actualTaxID, LoginData.taxID, "Actual taxID is not like expected");
    }

    @Test
    public void checkFirstName_lc() {
        String actualFirstName = profilePage.getFirstName();
        Assert.assertEquals(actualFirstName, LoginData.firstName, "Actual first name is not like expected");
    }

    @Test
    public void checkLastName_lc() {
        String actualLastName = profilePage.getLastName();
        Assert.assertEquals(actualLastName, LoginData.lastName, "Actual last name is not like expected");
    }

    @Test
    public void checkAddress1_lc() {
        String actualAddress1 = profilePage.getAddress1();
        Assert.assertEquals(actualAddress1, LoginData.address1, "Actual address1 is not like expected");
    }

    @Test
    public void checkPostcode_lc() {
        String actualPostcode = profilePage.getPostCode();
        Assert.assertEquals(actualPostcode, LoginData.postcode, "Actual postcode is not like expected");
    }

    @Test
    public void checkCity_lc() {
        String actualCity = profilePage.getCity();
        Assert.assertEquals(actualCity, LoginData.city, "Actual city is not like expected");
    }

    @Test
    public void checkCountry_lc() {
        String actualCountry = profilePage.getCountry();
        Assert.assertEquals(actualCountry, LoginData.country, "Actual country is not like expected");
    }

    @Test
    public void checkEmail_lc() {
        String actualEmail = profilePage.getEmail();
        Assert.assertEquals(actualEmail, eEmail.toLowerCase(), "Actual email is not like expected");
    }

    @Test
    public void checkPhone_lc() {
        String actualPhone = profilePage.getPhone();
        Assert.assertEquals(actualPhone, LoginData.phone, "Actual phone is not like expected");
    }
}
