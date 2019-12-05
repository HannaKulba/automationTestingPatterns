package tests.structurePatternTests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import patterns.structure.FluentInterface.CreatePageFluentInterface;
import patterns.structure.FluentInterface.ProfilePageFluentInterface;
import tests.BasicTestsSettings;
import utils.LoginData;
import utils.Urls;

public class FluentInterfacePatternTests extends BasicTestsSettings {
    private CreatePageFluentInterface createPage;
    private ProfilePageFluentInterface profilePage;
    private String eEmail = LoginData.email + Math.random();

    @BeforeTest
    public void testSetUp_fi() {
        createPage = new CreatePageFluentInterface(driver);
        profilePage = new ProfilePageFluentInterface(driver);
        createPage.openPage(Urls.createAccountURL)
                .enterTaxID(LoginData.taxID)
                .enterFirstName(LoginData.firstName)
                .enterLastName(LoginData.lastName)
                .enterAddress1(LoginData.address1)
                .enterPostcode(LoginData.postcode)
                .enterCity(LoginData.city)
                .enterEmail(eEmail)
                .selectCountry(LoginData.country)
                .enterPhone(LoginData.phone)
                .enterPassword(LoginData.pass)
                .enterConfirmedPassword(LoginData.pass)
                .clickOnCreateAccButton();
        profilePage.navigateTo(Urls.editAccountURL);
    }

    @Test()
    public void checkTaxID_fi() {
        profilePage.getTaxID()
                .verifyResults(LoginData.taxID);
    }

    @Test
    public void checkFirstName_fi() {
        profilePage.getFirstName()
                .verifyResults(LoginData.firstName);
    }

    @Test
    public void checkLastName_fi() {
        profilePage.getLastName()
                .verifyResults(LoginData.lastName);
    }

    @Test
    public void checkAddress1_fi() {
        profilePage.getAddress1()
                .verifyResults(LoginData.address1);
    }

    @Test
    public void checkPostcode_fi() {
        profilePage.getPostCode()
                .verifyResults(LoginData.postcode);
    }

    @Test
    public void checkCity_fi() {
        profilePage.getCity()
                .verifyResults(LoginData.city);
    }

    @Test
    public void checkCountry_fi() {
        profilePage.getCountry()
                .verifyResults(LoginData.country);
    }

    @Test
    public void checkEmail_fi() {
        profilePage.getEmail()
                .verifyResults(eEmail);
    }

    @Test
    public void checkPhone_fi() {
        profilePage.getPhone()
                .verifyResults(LoginData.phone);
    }
}
