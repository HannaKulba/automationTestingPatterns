package tests.dataPatternTests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import patterns.data.ValueObject.CreatePageValueObject;
import patterns.data.ValueObject.ProfilePageValueObject;
import tests.BasicTestsSettings;
import utils.User;

public class ValueObjectPatternTests extends BasicTestsSettings {
    private CreatePageValueObject createPage;
    private ProfilePageValueObject profilePage;
    private User user;

    @BeforeTest
    public void testSetUp_vo() {
        user = new User(1);
        createPage = new CreatePageValueObject(driver);
        profilePage = new ProfilePageValueObject(driver);
        createPage.createAccount(user);
        profilePage.navigateToProfilePage();
    }

    @Test()
    public void checkTaxID_vo() {
        String actualTaxID = profilePage.getTaxID();
        Assert.assertEquals(actualTaxID, user.getTaxID(), "Actual taxID is not like expected");
    }

    @Test
    public void checkFirstName_vo() {
        String actualFirstName = profilePage.getFirstName();
        Assert.assertEquals(actualFirstName, user.getFirstName(), "Actual first name is not like expected");
    }

    @Test
    public void checkLastName_vo() {
        String actualLastName = profilePage.getLastName();
        Assert.assertEquals(actualLastName, user.getLastName(), "Actual last name is not like expected");
    }

    @Test
    public void checkAddress1_vo() {
        String actualAddress1 = profilePage.getAddress1();
        Assert.assertEquals(actualAddress1, user.getAddress1(), "Actual address1 is not like expected");
    }

    @Test
    public void checkPostcode_vo() {
        String actualPostcode = profilePage.getPostCode();
        Assert.assertEquals(actualPostcode, user.getPostCode(), "Actual postcode is not like expected");
    }

    @Test
    public void checkCity_vo() {
        String actualCity = profilePage.getCity();
        Assert.assertEquals(actualCity, user.getCity(), "Actual city is not like expected");
    }

    @Test
    public void checkCountry_vo() {
        String actualCountry = profilePage.getCountry();
        Assert.assertEquals(actualCountry, user.getCountry(), "Actual country is not like expected");
    }

    @Test
    public void checkEmail_vo() {
        String actualEmail = profilePage.getEmail();
        Assert.assertTrue(actualEmail.contains(user.getEmail()), "Actual email is not like expected");
    }

    @Test
    public void checkPhone_vo() {
        String actualPhone = profilePage.getPhone();
        Assert.assertEquals(actualPhone, user.getPhone(), "Actual phone is not like expected");
    }

}
