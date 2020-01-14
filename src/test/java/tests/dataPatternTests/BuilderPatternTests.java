package tests.dataPatternTests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Account;
import patterns.data.Builder.CreatePageBuilder;
import patterns.data.Builder.ProfilePageBuilder;
import tests.BasicTestsSettings;
import utils.LoginData;

public class BuilderPatternTests extends BasicTestsSettings {
    private Account acc;
    private CreatePageBuilder createPage;
    private ProfilePageBuilder profilePage;

    @BeforeTest
    public void testSetUp_b() {
        acc = new Account.Builder()
                .withTaxID(LoginData.dataMap.get("taxID"))
                .withFirstName(LoginData.dataMap.get("firstName"))
                .withLastName(LoginData.dataMap.get("lastName"))
                .withAddress1(LoginData.dataMap.get("address1"))
                .withPostCode(LoginData.dataMap.get("postcode"))
                .withCity(LoginData.dataMap.get("city"))
                .withCountry(LoginData.dataMap.get("country"))
                .withEmail(LoginData.dataMap.get("email")+ Math.random())
                .withPhone(LoginData.dataMap.get("phone"))
                .withPassword(LoginData.dataMap.get("password"))
                .build();
        createPage = new CreatePageBuilder(driver);
        profilePage = new ProfilePageBuilder(driver);
        createPage.createAccount(acc);
        profilePage.navigateToProfilePage();
    }


    @Test()
    public void checkTaxID_b() {
        String actualTaxID = profilePage.getTaxID();
        Assert.assertEquals(actualTaxID, acc.getTaxID(), "Actual taxID is not like expected");
    }

    @Test
    public void checkFirstName_b() {
        String actualFirstName = profilePage.getFirstName();
        Assert.assertEquals(actualFirstName, acc.getFirstName(), "Actual first name is not like expected");
    }

    @Test
    public void checkLastName_b() {
        String actualLastName = profilePage.getLastName();
        Assert.assertEquals(actualLastName, acc.getLastName(), "Actual last name is not like expected");
    }

    @Test
    public void checkAddress1_b() {
        String actualAddress1 = profilePage.getAddress1();
        Assert.assertEquals(actualAddress1, acc.getAddress1(), "Actual address1 is not like expected");
    }

    @Test
    public void checkPostcode_b() {
        String actualPostcode = profilePage.getPostCode();
        Assert.assertEquals(actualPostcode, acc.getPostCode(), "Actual postcode is not like expected");
    }

    @Test
    public void checkCity_b() {
        String actualCity = profilePage.getCity();
        Assert.assertEquals(actualCity, acc.getCity(), "Actual city is not like expected");
    }

    @Test
    public void checkCountry_b() {
        String actualCountry = profilePage.getCountry();
        Assert.assertEquals(actualCountry, acc.getCountry(), "Actual country is not like expected");
    }

    @Test
    public void checkEmail_b() {
        String actualEmail = profilePage.getEmail();
        Assert.assertTrue(actualEmail.contains(acc.getEmail()), "Actual email is not like expected");
    }

    @Test
    public void checkPhone_b() {
        String actualPhone = profilePage.getPhone();
        Assert.assertEquals(actualPhone, acc.getPhone(), "Actual phone is not like expected");
    }
}
