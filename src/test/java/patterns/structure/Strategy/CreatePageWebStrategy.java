package patterns.structure.Strategy;

import org.openqa.selenium.WebDriver;
import patterns.BasePageObject;
import utils.IStrategy;
import utils.Urls;
import utils.WebPageElement;

import java.util.Map;

public class CreatePageWebStrategy extends BasePageObject implements IStrategy {
    public CreatePageWebStrategy(WebDriver driver) {
        super(driver);
    }

    @Override
    public Map createAccount(Map<String, String> loginData) {
        String email = loginData.get("email") + Math.random();
        navigateTo(Urls.createAccountURL);
        enterTaxID(loginData.get("taxID"));
        enterFirstName(loginData.get("firstName"));
        enterLastName(loginData.get("lastName"));
        enterAddress1(loginData.get("address1"));
        enterPostcode(loginData.get("postcode"));
        enterCity(loginData.get("city"));
        selectCountry(loginData.get("country"));
        enterEmail(email);
        enterPhone(loginData.get("phone"));
        enterPassword(loginData.get("password"));
        enterConfirmedPassword(loginData.get("password"));
        clickOnCreateAccButton();

        loginData.put("email", email);
        return loginData;
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
}
