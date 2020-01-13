package patterns.structure.FluentInterface;

import org.openqa.selenium.WebDriver;
import patterns.BaseAccountPageObject;
import utils.Urls;

public class CreatePageFluentInterface extends BaseAccountPageObject {

    public CreatePageFluentInterface(WebDriver driver) {
        super(driver);
    }

    public CreatePageFluentInterface openPage(Urls URL) {
        navigateToCreateAccountPage();
        return this;
    }

    public CreatePageFluentInterface enter_TaxID(String text) {
        enterTaxID(text);
        return this;
    }

    public CreatePageFluentInterface enter_FirstName(String text) {
        enterFirstName(text);
        return this;
    }

    public CreatePageFluentInterface enter_LastName(String text) {
        enterLastName(text);
        return this;
    }

    public CreatePageFluentInterface enter_Address1(String text) {
        enterAddress1(text);
        return this;
    }

    public CreatePageFluentInterface enter_Postcode(String text) {
        enterPostcode(text);
        return this;
    }

    public CreatePageFluentInterface enter_City(String text) {
        enterCity(text);
        return this;
    }

    public CreatePageFluentInterface enter_Email(String text) {
        enterEmail(text);
        return this;
    }

    public CreatePageFluentInterface enter_Phone(String text) {
        enterPhone(text);
        return this;
    }

    public CreatePageFluentInterface enter_Password(String text) {
        enterPassword(text);
        return this;
    }

    public CreatePageFluentInterface enter_ConfirmedPassword(String text) {
        enterConfirmedPassword(text);
        return this;
    }

    public CreatePageFluentInterface click_OnCreateAccButton() {
        clickOnCreateAccButton();
        return this;
    }

    public CreatePageFluentInterface select_Country(String countryName) {
        selectCountry(countryName);
        return this;
    }


}
