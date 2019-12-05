package tests.structurePatternTests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import patterns.structure.PageFactory.CreatePageFactory;
import patterns.structure.PageFactory.ProfilePageFactory;
import tests.BasicTestsSettings;
import utils.LoginData;
import utils.Urls;

public class PageFactoryPatternTests extends BasicTestsSettings {
    private CreatePageFactory createPage;
    private ProfilePageFactory profilePage;
    private String eEmail = LoginData.email + Math.random();

    @BeforeTest
    public void testSetUp_f() {
        createPage = new CreatePageFactory(driver);
        profilePage = new ProfilePageFactory(driver);
        createPage.createAccount(LoginData.taxID, LoginData.firstName, LoginData.lastName, LoginData.address1,
                LoginData.postcode, LoginData.city, LoginData.country, eEmail, LoginData.phone, LoginData.pass);
        profilePage.navigateTo(Urls.editAccountURL);
    }

    @Test()
    public void checkTaxID_f() {
        String actualTaxID = profilePage.getTaxID();
        Assert.assertEquals(actualTaxID, LoginData.taxID, "Actual taxID is not like expected");
    }

    @Test
    public void checkFirstName_f() {
        String actualFirstName = profilePage.getFirstName();
        Assert.assertEquals(actualFirstName, LoginData.firstName, "Actual first name is not like expected");
    }

    @Test
    public void checkLastName_f() {
        String actualLastName = profilePage.getLastName();
        Assert.assertEquals(actualLastName, LoginData.lastName, "Actual last name is not like expected");
    }

    @Test
    public void checkAddress1_f() {
        String actualAddress1 = profilePage.getAddress1();
        Assert.assertEquals(actualAddress1, LoginData.address1, "Actual address1 is not like expected");
    }

    @Test
    public void checkPostcode_f() {
        String actualPostcode = profilePage.getPostCode();
        Assert.assertEquals(actualPostcode, LoginData.postcode, "Actual postcode is not like expected");
    }

    @Test
    public void checkCity_f() {
        String actualCity = profilePage.getCity();
        Assert.assertEquals(actualCity, LoginData.city, "Actual city is not like expected");
    }

    @Test
    public void checkCountry_f() {
        String actualCountry = profilePage.getCountry();
        Assert.assertEquals(actualCountry, LoginData.country, "Actual country is not like expected");
    }

    @Test
    public void checkEmail_f() {
        String actualEmail = profilePage.getEmail();
        Assert.assertEquals(actualEmail, eEmail.toLowerCase(), "Actual email is not like expected");
    }

    @Test
    public void checkPhone_f() {
        String actualPhone = profilePage.getPhone();
        Assert.assertEquals(actualPhone, LoginData.phone, "Actual phone is not like expected");
    }


}
