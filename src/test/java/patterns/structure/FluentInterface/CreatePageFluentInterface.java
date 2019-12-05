package patterns.structure.FluentInterface;

import org.openqa.selenium.WebDriver;
import patterns.BasePageObject;
import utils.Urls;
import utils.WebPageElement;

public class CreatePageFluentInterface extends BasePageObject {

    public CreatePageFluentInterface(WebDriver driver) {
        super(driver);
    }

    public CreatePageFluentInterface openPage(Urls URL) {
        navigateTo(URL);
        return this;
    }

    public CreatePageFluentInterface enterTaxID(String text) {
        enterText(WebPageElement.taxID, text);
        return this;
    }

    public CreatePageFluentInterface enterFirstName(String text) {
        enterText(WebPageElement.firstname, text);
        return this;
    }

    public CreatePageFluentInterface enterLastName(String text) {
        enterText(WebPageElement.lastname, text);
        return this;
    }

    public CreatePageFluentInterface enterAddress1(String text) {
        enterText(WebPageElement.address1, text);
        return this;
    }

    public CreatePageFluentInterface enterPostcode(String text) {
        enterText(WebPageElement.postcode, text);
        return this;
    }

    public CreatePageFluentInterface enterCity(String text) {
        enterText(WebPageElement.city, text);
        return this;
    }

    public CreatePageFluentInterface enterEmail(String text) {
        enterText(WebPageElement.email, text);
        return this;
    }

    public CreatePageFluentInterface enterPhone(String text) {
        enterText(WebPageElement.phone, text);
        return this;
    }

    public CreatePageFluentInterface enterPassword(String text) {
        enterText(WebPageElement.password, text);
        return this;
    }

    public CreatePageFluentInterface enterConfirmedPassword(String text) {
        enterText(WebPageElement.confirmedPassword, text);
        return this;
    }

    public CreatePageFluentInterface clickOnCreateAccButton() {
        clickOnButton(WebPageElement.createAccButton);
        return this;
    }

    public CreatePageFluentInterface selectCountry(String countryName) {
        selectOptionByName(WebPageElement.country, countryName);
        return this;
    }


}
