package patterns.business.Steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import patterns.BaseProfilePageObject;
import utils.LoginData;

public class ProfilePageSteps extends BaseProfilePageObject {
    public ProfilePageSteps(WebDriver driver) {
        super(driver);
    }

    private void verifyData(String field, String actual, String expected) {
        Assert.assertEquals(actual, expected, "Actual " + field + " is not like expected");
    }

    private void verifyDataTrue(String field, String actual, String expected) {
        Assert.assertTrue(actual.contains(expected), "Actual " + field + " is not like expected");
    }

    public void verifyTaxID() {
        verifyData("taxID", getTaxID(), LoginData.dataMap.get("taxID"));
    }

    public void verifyFirstName() {
        verifyData("firstName", getFirstName(), LoginData.dataMap.get("firstName"));
    }

    public void verifyLastName() {
        verifyData("lastName", getLastName(), LoginData.dataMap.get("lastName"));
    }

    public void verifyAddress1() {
        verifyData("address1", getAddress1(), LoginData.dataMap.get("address1"));
    }

    public void verifyPostcode() {
        verifyData("postcode", getPostCode(), LoginData.dataMap.get("postcode"));
    }

    public void verifyCity() {
        verifyData("city", getCity(), LoginData.dataMap.get("city"));
    }

    public void verifyCountry() {
        verifyData("country", getCountry(), LoginData.dataMap.get("country"));
    }

    public void verifyEmail() {
        verifyDataTrue("email", getEmail(), LoginData.dataMap.get("email"));
    }

    public void verifyPhone() {
        verifyData("phone", getPhone(), LoginData.dataMap.get("phone"));
    }


}
