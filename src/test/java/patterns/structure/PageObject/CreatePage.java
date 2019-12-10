package patterns.structure.PageObject;

import org.openqa.selenium.WebDriver;
import patterns.BasePageObject;
import utils.Urls;
import utils.WebPageElement;

import java.util.Map;

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

    public void createAccount(Map<String, String> dataMap) {
        navigateTo(Urls.createAccountURL);
        enterTaxID(dataMap.get("taxID"));
        enterFirstName(dataMap.get("firstName"));
        enterLastName(dataMap.get("lastName"));
        enterAddress1(dataMap.get("address1"));
        enterPostcode(dataMap.get("postcode"));
        enterCity(dataMap.get("city"));
        selectCountry(dataMap.get("country"));
        enterEmail(dataMap.get("email") + Math.random());
        enterPhone(dataMap.get("phone"));
        enterPassword(dataMap.get("password"));
        enterConfirmedPassword(dataMap.get("password"));
        clickOnCreateAccButton();
    }

}
