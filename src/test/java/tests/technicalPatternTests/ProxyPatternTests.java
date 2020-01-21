/*Шаблон проектирования Proxy позволяет нам создавать класс-оболочку / прокси поверх реального объекта.
Затем этот прокси-класс используется для обеспечения контролируемого доступа к реальному объекту.
*/
package tests.technicalPatternTests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import patterns.technical.Proxy.CreatePageProxy;
import patterns.technical.Proxy.ProfilePageProxy;
import tests.BasicTestsSettings;
import utils.User;
import utils.proxyUtils.UserUtil;
import utils.proxyUtils.UserUtilProxy;

public class ProxyPatternTests extends BasicTestsSettings {
    private UserUtil userUtil;
    private CreatePageProxy createPage;
    private ProfilePageProxy profilePage;
    private String[] data = "768966,Martin,Markowski,ul. Petrova 34-7,563560,Brest,Belarus,martinn@gmail.com,375297453734,BrestBelarus".split(",");

    @BeforeTest
    public void setup_proxy() {
        userUtil = new UserUtilProxy(data);
        userUtil.createUser();
        createPage = new CreatePageProxy(driver);
        profilePage = new ProfilePageProxy(driver);
        createPage.createAccount(User.getUser(data[1] + " " + data[2]));
        profilePage.navigateToProfilePage();
    }

    @Test()
    public void checkTaxID_proxy() {
        String actualTaxID = profilePage.getTaxID();
        Assert.assertEquals(actualTaxID, data[0], "Actual taxID is not like expected");
    }

    @Test
    public void checkFirstName_proxy() {
        String actualFirstName = profilePage.getFirstName();
        Assert.assertEquals(actualFirstName, data[1], "Actual first name is not like expected");
    }

    @Test
    public void checkLastName_proxy() {
        String actualLastName = profilePage.getLastName();
        Assert.assertEquals(actualLastName, data[2], "Actual last name is not like expected");
    }

    @Test
    public void checkAddress1_proxy() {
        String actualAddress1 = profilePage.getAddress1();
        Assert.assertEquals(actualAddress1, data[3], "Actual address1 is not like expected");
    }

    @Test
    public void checkPostcode_proxy() {
        String actualPostcode = profilePage.getPostCode();
        Assert.assertEquals(actualPostcode, data[4], "Actual postcode is not like expected");
    }

    @Test
    public void checkCity_proxy() {
        String actualCity = profilePage.getCity();
        Assert.assertEquals(actualCity, data[5], "Actual city is not like expected");
    }

    @Test
    public void checkCountry_proxy() {
        String actualCountry = profilePage.getCountry();
        Assert.assertEquals(actualCountry, data[6], "Actual country is not like expected");
    }

    @Test
    public void checkEmail_proxy() {
        String actualEmail = profilePage.getEmail();
        Assert.assertTrue(actualEmail.contains(data[7]), "Actual email is not like expected");
    }

    @Test
    public void checkPhone_proxy() {
        String actualPhone = profilePage.getPhone();
        Assert.assertEquals(actualPhone, "+" + data[8], "Actual phone is not like expected");
    }

    @AfterTest
    public void tearDown_proxy() {
        userUtil.deleteUser();
    }
}
