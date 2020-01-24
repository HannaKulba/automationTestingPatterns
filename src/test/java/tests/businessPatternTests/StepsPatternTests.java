package tests.businessPatternTests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import patterns.business.Steps.CreatePageSteps;
import patterns.business.Steps.ProfilePageSteps;
import utils.DriverUtil;
import utils.LoginData;

public class StepsPatternTests {
    private DriverUtil driver;
    private CreatePageSteps createAccountPage;
    private ProfilePageSteps profilePage;

    @BeforeTest
    public void setup() {
        driver = new DriverUtil();
        //step #1 - initialize and open browser
        driver.initializeChromeDriver();

        createAccountPage = new CreatePageSteps(driver.getChromeDriver());
        profilePage = new ProfilePageSteps(driver.getChromeDriver());

        //step #2 - go to creat new account page
        createAccountPage.navigateToCreateAccountPage();

        //step #3
        createAccountPage.enterTaxID(LoginData.dataMap.get("taxID"));

        //step #4
        createAccountPage.enterFirstName(LoginData.dataMap.get("firstName"));

        //step #5
        createAccountPage.enterLastName(LoginData.dataMap.get("lastName"));

        //step #6
        createAccountPage.enterAddress1(LoginData.dataMap.get("address1"));

        //step #7
        createAccountPage.enterPostcode(LoginData.dataMap.get("postcode"));

        //step #8
        createAccountPage.enterCity(LoginData.dataMap.get("city"));

        //step #9
        createAccountPage.selectCountry(LoginData.dataMap.get("country"));

        //step #10
        createAccountPage.enterEmail(LoginData.dataMap.get("email") + Math.random());

        //step #11
        createAccountPage.enterPhone(LoginData.dataMap.get("phone"));

        //step #12
        createAccountPage.enterPassword(LoginData.dataMap.get("password"));

        //step #13
        createAccountPage.enterConfirmedPassword(LoginData.dataMap.get("password"));

        //step #14
        createAccountPage.clickOnCreateAccButton();

        //step # 15
        profilePage.navigateToProfilePage();
    }

    @Test
    public void checkTaxID_st() {
        //step # 16
        profilePage.verifyTaxID();
    }

    @Test
    public void checkFirstName_st() {
        //step # 17
        profilePage.verifyFirstName();
    }

    @Test
    public void checkLastName_st() {
        //step # 18
        profilePage.verifyLastName();
    }

    @Test
    public void checkAddress1_st() {
        //step # 19
        profilePage.verifyAddress1();
    }

    @Test
    public void checkPostcode_st() {
        //step # 20
        profilePage.verifyPostcode();
    }

    @Test
    public void checkCity_st() {
        //step # 21
        profilePage.verifyCity();
    }

    @Test
    public void checkCountry_st() {
        //step # 22
        profilePage.verifyCountry();
    }

    @Test
    public void checkEmail_st() {
        //step # 23
        profilePage.verifyEmail();
    }

    @Test
    public void checkPhone_st() {
        //step # 24
        profilePage.verifyPhone();
    }

    @AfterTest
    public void tearDown() {
        //step 25 - close browser
        driver.finishChromeDriver();
    }
}
