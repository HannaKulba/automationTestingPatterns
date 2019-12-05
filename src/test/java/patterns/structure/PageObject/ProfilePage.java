package patterns.structure.PageObject;

import org.openqa.selenium.WebDriver;
import patterns.BasePageObject;
import utils.WebPageElement;

public class ProfilePage extends BasePageObject {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public String getTaxID() {
        return getValue(WebPageElement.taxID);
    }

    public String getFirstName() {
        return getValue(WebPageElement.firstname);
    }

    public String getLastName() {
        return getValue(WebPageElement.lastname);
    }

    public String getAddress1() {
        return getValue(WebPageElement.address1);
    }

    public String getPostCode() {
        return getValue(WebPageElement.postcode);
    }

    public String getCity() {
        return getValue(WebPageElement.city);
    }

    public String getCountry() {
        return getText(WebPageElement.chosenCountry);
    }

    public String getEmail() {
        return getValue(WebPageElement.email);
    }

    public String getPhone() {
        return getValue(WebPageElement.phone);
    }
}
