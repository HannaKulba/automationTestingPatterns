package patterns.structure.FluentInterface;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import patterns.BaseProfilePageObject;
import utils.WebPageElement;

public class ProfilePageFluentInterface extends BaseProfilePageObject {

    private String actual;

    public ProfilePageFluentInterface(WebDriver driver) {
        super(driver);
    }

    public ProfilePageFluentInterface verifyResults(String expected) {
        Assert.assertEquals(actual, expected, "Actual and expected values are not match.");
        return this;
    }

    public ProfilePageFluentInterface verifyResultIsTrue(String expected) {
        Assert.assertTrue(actual.contains(expected), "Actual and expected values are not match.");
        return this;
    }

    public ProfilePageFluentInterface get_TaxID() {
        actual = getValue(WebPageElement.taxID);
        return this;
    }

    public ProfilePageFluentInterface get_FirstName() {
        actual = getValue(WebPageElement.firstname);
        return this;
    }

    public ProfilePageFluentInterface get_LastName() {
        actual = getValue(WebPageElement.lastname);
        return this;
    }

    public ProfilePageFluentInterface get_Address1() {
        actual = getValue(WebPageElement.address1);
        return this;
    }

    public ProfilePageFluentInterface get_PostCode() {
        actual = getValue(WebPageElement.postcode);
        return this;
    }

    public ProfilePageFluentInterface get_City() {
        actual = getValue(WebPageElement.city);
        return this;
    }

    public ProfilePageFluentInterface get_Country() {
        actual = getText(WebPageElement.chosenCountry);
        return this;
    }

    public ProfilePageFluentInterface get_Email() {
        actual = getValue(WebPageElement.email);
        return this;
    }

    public ProfilePageFluentInterface get_Phone() {
        actual = getValue(WebPageElement.phone);
        return this;
    }
}
