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
                .enter_TaxID(LoginData.dataMap.get("taxID"))
                .enter_FirstName(LoginData.dataMap.get("firstName"))
                .enter_LastName(LoginData.dataMap.get("lastName"))
                .enter_Address1(LoginData.dataMap.get("address1"))
                .enter_Postcode(LoginData.dataMap.get("postcode"))
                .enter_City(LoginData.dataMap.get("city"))
                .enter_Email(LoginData.dataMap.get("email") + Math.random())
                .select_Country(LoginData.dataMap.get("country"))
                .enter_Phone(LoginData.dataMap.get("phone"))
                .enter_Password(LoginData.dataMap.get("password"))
                .enter_ConfirmedPassword(LoginData.dataMap.get("password"))
                .click_OnCreateAccButton();
        profilePage.navigateToProfilePage();
    }

    @Test()
    public void checkTaxID_fi() {
        profilePage.get_TaxID()
                .verifyResults(LoginData.dataMap.get("taxID"));
    }

    @Test
    public void checkFirstName_fi() {
        profilePage.get_FirstName()
                .verifyResults(LoginData.dataMap.get("firstName"));
    }

    @Test
    public void checkLastName_fi() {
        profilePage.get_LastName()
                .verifyResults(LoginData.dataMap.get("lastName"));
    }

    @Test
    public void checkAddress1_fi() {
        profilePage.get_Address1()
                .verifyResults(LoginData.dataMap.get("address1"));
    }

    @Test
    public void checkPostcode_fi() {
        profilePage.get_PostCode()
                .verifyResults(LoginData.dataMap.get("postcode"));
    }

    @Test
    public void checkCity_fi() {
        profilePage.get_City()
                .verifyResults(LoginData.dataMap.get("city"));
    }

    @Test
    public void checkCountry_fi() {
        profilePage.get_Country()
                .verifyResults(LoginData.dataMap.get("country"));
    }

    @Test
    public void checkEmail_fi() {
        profilePage.get_Email()
                .verifyResultIsTrue(LoginData.dataMap.get("email"));
    }

    @Test
    public void checkPhone_fi() {
        profilePage.get_Phone()
                .verifyResults(LoginData.dataMap.get("phone"));
    }
}
