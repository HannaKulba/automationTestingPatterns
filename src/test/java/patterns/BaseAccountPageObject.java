package patterns;

import org.openqa.selenium.WebDriver;
import utils.Urls;
import utils.WebPageElement;

public class BaseAccountPageObject extends BasePageObject {

    public BaseAccountPageObject(WebDriver driver) {
        super(driver);
    }

    public void enterTaxID(String taxId) {
        enterText(WebPageElement.taxID, taxId);
    }

    public void enterFirstName(String firstName) {
        enterText(WebPageElement.firstname, firstName);
    }

    public void enterLastName(String lastName) {
        enterText(WebPageElement.lastname, lastName);
    }

    public void enterAddress1(String address1) {
        enterText(WebPageElement.address1, address1);
    }

    public void enterPostcode(String postcode) {
        enterText(WebPageElement.postcode, postcode);
    }

    public void enterCity(String city) {
        enterText(WebPageElement.city, city);
    }

    public void enterEmail(String email) {
        enterText(WebPageElement.email, email);
    }

    public void enterPhone(String phone) {
        enterText(WebPageElement.phone, phone);
    }

    public void enterPassword(String password) {
        enterText(WebPageElement.password, password);
    }

    public void enterConfirmedPassword(String password) {
        enterText(WebPageElement.confirmedPassword, password);
    }

    public void clickOnCreateAccButton() {
        clickOnButton(WebPageElement.createAccButton);
    }

    public void selectCountry(String countryName) {
        selectOptionByName(WebPageElement.country, countryName);
    }

    public void navigateToCreateAccountPage() {
        navigateTo(Urls.createAccountURL);
    }

    public void navigateToHomePage() {
        navigateTo(Urls.homePageURL);
    }


}
