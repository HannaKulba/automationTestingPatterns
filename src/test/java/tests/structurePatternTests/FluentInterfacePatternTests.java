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

    @BeforeTest
    public void testSetUp_fi() {
        createPage = new CreatePageFluentInterface(driver);
        profilePage = new ProfilePageFluentInterface(driver);
        createPage.openPage(Urls.createAccountURL)
                .enterTaxID(LoginData.dataMap.get("taxID"))
                .enterFirstName(LoginData.dataMap.get("firstName"))
                .enterLastName(LoginData.dataMap.get("lastName"))
                .enterAddress1(LoginData.dataMap.get("address1"))
                .enterPostcode(LoginData.dataMap.get("postcode"))
                .enterCity(LoginData.dataMap.get("city"))
                .enterEmail(LoginData.dataMap.get("email") + Math.random())
                .selectCountry(LoginData.dataMap.get("country"))
                .enterPhone(LoginData.dataMap.get("phone"))
                .enterPassword(LoginData.dataMap.get("password"))
                .enterConfirmedPassword(LoginData.dataMap.get("password"))
                .clickOnCreateAccButton();
        profilePage.navigateTo(Urls.editAccountURL);
    }

    @Test()
    public void checkTaxID_fi() {
        profilePage.getTaxID()
                .verifyResults(LoginData.dataMap.get("taxID"));
    }

    @Test
    public void checkFirstName_fi() {
        profilePage.getFirstName()
                .verifyResults(LoginData.dataMap.get("firstName"));
    }

    @Test
    public void checkLastName_fi() {
        profilePage.getLastName()
                .verifyResults(LoginData.dataMap.get("lastName"));
    }

    @Test
    public void checkAddress1_fi() {
        profilePage.getAddress1()
                .verifyResults(LoginData.dataMap.get("address1"));
    }

    @Test
    public void checkPostcode_fi() {
        profilePage.getPostCode()
                .verifyResults(LoginData.dataMap.get("postcode"));
    }

    @Test
    public void checkCity_fi() {
        profilePage.getCity()
                .verifyResults(LoginData.dataMap.get("city"));
    }

    @Test
    public void checkCountry_fi() {
        profilePage.getCountry()
                .verifyResults(LoginData.dataMap.get("country"));
    }

    @Test
    public void checkEmail_fi() {
        profilePage.getEmail()
                .verifyResultIsTrue(LoginData.dataMap.get("email"));
    }

    @Test
    public void checkPhone_fi() {
        profilePage.getPhone()
                .verifyResults(LoginData.dataMap.get("phone"));
    }
}
