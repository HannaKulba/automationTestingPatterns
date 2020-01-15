package tests.dataPatternTests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import patterns.data.ObjectPool.LoginPageObjectPool;
import patterns.data.ObjectPool.ProfilePageObjectPool;
import tests.BasicTestsSettings;
import utils.User;
import utils.UserPool;

public class ObjectPoolPatternTests extends BasicTestsSettings {
    private LoginPageObjectPool loginPage;
    private ProfilePageObjectPool profilePage;
    private User user;
    private String email;
    private String password;

    @BeforeTest
    public void testSetUp_op() {
        loginPage = new LoginPageObjectPool(driver);
        profilePage = new ProfilePageObjectPool(driver);
        user = UserPool.getAvailableUser("Julia", "Sidorova");
        if (user != null){
            email = user.getEmail();
            password = user.getPassword();
        }
    }

    @Test()
    public void checkLogin(){
        loginPage.loginToAccount(email, password);
        profilePage.navigateToProfilePage();
    }

    @Test(dependsOnMethods = "checkLogin")
    public void checkTaxID_op() {
        String actualTaxID = profilePage.getTaxID();
        Assert.assertEquals(actualTaxID, user.getTaxID(), "Actual taxID is not like expected");
    }

    @Test(dependsOnMethods = "checkLogin")
    public void checkFirstName_op() {
        String actualFirstName = profilePage.getFirstName();
        Assert.assertEquals(actualFirstName, user.getFirstName(), "Actual first name is not like expected");
    }

    @Test(dependsOnMethods = "checkLogin")
    public void checkLastName_op() {
        String actualLastName = profilePage.getLastName();
        Assert.assertEquals(actualLastName, user.getLastName(), "Actual last name is not like expected");
    }

    @Test(dependsOnMethods = "checkLogin")
    public void checkAddress1_op() {
        String actualAddress1 = profilePage.getAddress1();
        Assert.assertEquals(actualAddress1, user.getAddress1(), "Actual address1 is not like expected");
    }

    @Test(dependsOnMethods = "checkLogin")
    public void checkPostcode_op() {
        String actualPostcode = profilePage.getPostCode();
        Assert.assertEquals(actualPostcode,user.getPostCode(), "Actual postcode is not like expected");
    }

    @Test(dependsOnMethods = "checkLogin")
    public void checkCity_op() {
        String actualCity = profilePage.getCity();
        Assert.assertEquals(actualCity, user.getCity(), "Actual city is not like expected");
    }

    @Test(dependsOnMethods = "checkLogin")
    public void checkCountry_op() {
        String actualCountry = profilePage.getCountry();
        Assert.assertEquals(actualCountry, user.getCountry(), "Actual country is not like expected");
    }

    @Test(dependsOnMethods = "checkLogin")
    public void checkEmail_op() {
        String actualEmail = profilePage.getEmail();
        Assert.assertTrue(actualEmail.contains(user.getEmail()), "Actual email is not like expected");
    }

    @Test(dependsOnMethods = "checkLogin")
    public void checkPhone_op() {
        String actualPhone = profilePage.getPhone();
        Assert.assertEquals(actualPhone, user.getPhone(), "Actual phone is not like expected");
    }

    @AfterTest
    public void tearDown_op() {
        UserPool.returnUserToPool(email);
    }
}
