package patterns;

import org.openqa.selenium.WebDriver;
import utils.Urls;
import utils.WebPageElement;

public class BaseProfilePageObject extends BasePageObject {

    public BaseProfilePageObject(WebDriver driver) {
        super(driver);
    }

    public void navigateToProfilePage(){
        navigateTo(Urls.editAccountURL);
    }

    public void logout(){
        navigateTo(Urls.logoutURL);
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


