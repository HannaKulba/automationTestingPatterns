package tests.structurePatternTests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import patterns.structure.Strategy.CreatePageRestStrategy;
import patterns.structure.Strategy.ProfilePageRestStrategy;
import utils.Locator;
import utils.LoginData;

import java.util.Map;

public class StrategyPatternRestTests {
    private Map cookie;
    private CreatePageRestStrategy createPage;
    private ProfilePageRestStrategy profilePage;

    @BeforeTest
    public void testSetUp_sr() {
        createPage = new CreatePageRestStrategy();
        profilePage = new ProfilePageRestStrategy();
        cookie = createPage.createAccount(LoginData.dataMap);
    }

    @Test
    public void checkTaxID_sr() {
        Assert.assertEquals(LoginData.dataMap.get("taxID"), profilePage.getValue(cookie, Locator.taxID));
    }

    @Test
    public void checkFirstName_sr() {
        Assert.assertEquals(LoginData.dataMap.get("firstName"), profilePage.getValue(cookie, Locator.firstName));
    }

    @Test
    public void checkLastName_sr() {
        Assert.assertEquals(LoginData.dataMap.get("lastName"), profilePage.getValue(cookie, Locator.lastName));
    }

    @Test
    public void checkAddress1_sr() {
        Assert.assertEquals(LoginData.dataMap.get("address1"), profilePage.getValue(cookie, Locator.address1));
    }

    @Test
    public void checkPostCode_sr() {
        Assert.assertEquals(LoginData.dataMap.get("postcode"), profilePage.getValue(cookie, Locator.postcode));
    }

    @Test
    public void checkCity_sr() {
        Assert.assertEquals(LoginData.dataMap.get("city"), profilePage.getValue(cookie, Locator.city));
    }

    @Test
    public void checkCountry_sr() {
        Assert.assertEquals(LoginData.dataMap.get("country"), profilePage.getValue(cookie, Locator.country));
    }

    @Test
    public void checkEmail_sr() {
        Assert.assertTrue(profilePage.getValue(cookie, Locator.email).contains(LoginData.dataMap.get("email")));
    }

    @Test
    public void checkPhone_sr() {
        Assert.assertEquals(LoginData.dataMap.get("phone"), profilePage.getValue(cookie, Locator.phone));
    }
}
