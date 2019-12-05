package patterns.structure.PageObject;

import org.openqa.selenium.WebDriver;
import patterns.BasePageObject;
import utils.Urls;
import utils.WebPageElement;

public class CreatePage extends BasePageObject {

    public CreatePage(WebDriver driver) {
        super(driver);
    }

    private void enterTaxID(String text) {
        enterText(WebPageElement.taxID, text);
    }

    private void enterFirstName(String text) {
        enterText(WebPageElement.firstname, text);
    }

    private void enterLastName(String text) {
        enterText(WebPageElement.lastname, text);
    }

    private void enterAddress1(String text) {
        enterText(WebPageElement.address1, text);
    }

    private void enterPostcode(String text) {
        enterText(WebPageElement.postcode, text);
    }

    private void enterCity(String text) {
        enterText(WebPageElement.city, text);
    }

    private void enterEmail(String text) {
        enterText(WebPageElement.email, text);
    }

    private void enterPhone(String text) {
        enterText(WebPageElement.phone, text);
    }

    private void enterPassword(String text) {
        enterText(WebPageElement.password, text);
    }

    private void enterConfirmedPassword(String text) {
        enterText(WebPageElement.confirmedPassword, text);
    }

    private void clickOnCreateAccButton() {
        clickOnButton(WebPageElement.createAccButton);
    }

    private void selectCountry(String countryName) {
        selectOptionByName(WebPageElement.country, countryName);
    }

    public void createAccount(String taxID, String firstName, String lastName, String address1, String postcode,
                              String city, String countryName, String email, String phone, String password) {
        navigateTo(Urls.createAccountURL);
        enterTaxID(taxID);
        enterFirstName(firstName);
        enterLastName(lastName);
        enterAddress1(address1);
        enterPostcode(postcode);
        enterCity(city);
        selectCountry(countryName);
        enterEmail(email);
        enterPhone(phone);
        enterPassword(password);
        enterConfirmedPassword(password);
        clickOnCreateAccButton();
    }

}
