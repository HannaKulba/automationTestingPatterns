package patterns.structure.FluentInterface;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import patterns.BaseAccountPageObject;
import patterns.BasePageObject;
import utils.WebPageElement;

public class ProfilePageFluentInterface extends BaseAccountPageObject {

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

    public ProfilePageFluentInterface getTaxID() {
        actual = getValue(WebPageElement.taxID);
        return this;
    }

    public ProfilePageFluentInterface getFirstName() {
        actual = getValue(WebPageElement.firstname);
        return this;
    }

    public ProfilePageFluentInterface getLastName() {
        actual = getValue(WebPageElement.lastname);
        return this;
    }

    public ProfilePageFluentInterface getAddress1() {
        actual = getValue(WebPageElement.address1);
        return this;
    }

    public ProfilePageFluentInterface getPostCode() {
        actual = getValue(WebPageElement.postcode);
        return this;
    }

    public ProfilePageFluentInterface getCity() {
        actual = getValue(WebPageElement.city);
        return this;
    }

    public ProfilePageFluentInterface getCountry() {
        actual = getText(WebPageElement.chosenCountry);
        return this;
    }

    public ProfilePageFluentInterface getEmail() {
        actual = getValue(WebPageElement.email);
        return this;
    }

    public ProfilePageFluentInterface getPhone() {
        actual = getValue(WebPageElement.phone);
        return this;
    }
}
