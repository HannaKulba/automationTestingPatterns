package tests.businessPatternTests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import patterns.business.Keyword.KeywordService;
import tests.BasicTestsSettings;

import java.io.BufferedReader;

public class KeywordPatternTests extends BasicTestsSettings {
    private KeywordService service;
    private BufferedReader reader;

    @BeforeTest
    public void setup_keyword() {
        service = new KeywordService(driver);
    }

    @Test
    public void createAccount() {
        String pathCreate = "./src/main/resources/Keywords_testCase_CreateAccount.csv";
        reader = service.readKeywordsFile(pathCreate);
        service.generateCreateAccountTest(reader);

    }

    @Test(dependsOnMethods = "createAccount")
    public void checkTaxID_keyword() {
        String pathVerify = "./src/main/resources/Keywords_testCase_VerifyUserData.csv";
        reader = service.readKeywordsFile(pathVerify);
        service.generateVerifyTests(reader);
    }
}
