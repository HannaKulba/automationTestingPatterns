package tests.dataPatternTests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import patterns.data.DataRegistry.CreatePageDataRegistry;
import tests.BasicTestsSettings;
import utils.LoginData;

public class DataRegistryPatternTests extends BasicTestsSettings {
    private CreatePageDataRegistry createPage;

    @BeforeTest
    public void testSetUp_dr() {
        createPage = new CreatePageDataRegistry(driver);
    }

    @Test()
    public void createAccount_dr() {
        createPage.createAccount(LoginData.dataMap);
    }

}
