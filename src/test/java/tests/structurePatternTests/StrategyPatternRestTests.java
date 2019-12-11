package tests.structurePatternTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import patterns.structure.Strategy.CreatePageRestStrategy;
import utils.Locator;
import utils.LoginData;

import java.util.Map;

public class StrategyPatternRestTests {

    @Test
    public void checkTaxID_sr() {
        CreatePageRestStrategy rest = new CreatePageRestStrategy();
        Map cookie = rest.createAccount(LoginData.dataMap);
        Assert.assertEquals(LoginData.dataMap.get("taxID"), rest.getValue(cookie, Locator.taxID));
        //Assert.assertTrue(rest.getValue(cookie, Locator.email).contains(LoginData.dataMap.get("email")));
    }
}
