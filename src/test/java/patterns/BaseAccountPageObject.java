package patterns;

import org.openqa.selenium.WebDriver;
import utils.Urls;
import utils.WebPageElement;

public class BaseAccountPageObject extends BasePageObject {

    public BaseAccountPageObject(WebDriver driver) {
        super(driver);
    }

    public void enterTaxID(String text) {
        enterText(WebPageElement.taxID, text);
    }

    public void enterFirstName(String text) {
        enterText(WebPageElement.firstname, text);
    }

    public void enterLastName(String text) {
        enterText(WebPageElement.lastname, text);
    }

    public void enterAddress1(String text) {
        enterText(WebPageElement.address1, text);
    }

    public void enterPostcode(String text) {
        enterText(WebPageElement.postcode, text);
    }

    public void enterCity(String text) {
        enterText(WebPageElement.city, text);
    }

    public void enterEmail(String text) {
        enterText(WebPageElement.email, text);
    }

    public void enterPhone(String text) {
        enterText(WebPageElement.phone, text);
    }

    public void enterPassword(String text) {
        enterText(WebPageElement.password, text);
    }

    public void enterConfirmedPassword(String text) {
        enterText(WebPageElement.confirmedPassword, text);
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
