package patterns.structure.LoadableComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;
import patterns.BasePageObject;
import utils.Urls;
import utils.WebPageElement;

import static org.testng.AssertJUnit.assertTrue;

public class CreatePageLoadableComponent extends LoadableComponent<CreatePageLoadableComponent> {
    private WebDriver driver;
    private String createAccURL = Urls.createAccountURL.getURL();
    private BasePageObject basePage;
    private LoadableComponent<HomePageLoadableComponent> parent;

    public CreatePageLoadableComponent(WebDriver driver, LoadableComponent<HomePageLoadableComponent> parent) {
        this.driver = driver;
        basePage = new BasePageObject(driver);
        this.parent = parent;
    }

    @Override
    protected void load() {
        parent.get().goToLoginPage();
    }

    @Override
    protected void isLoaded() throws Error {
        assertTrue("Create account page is not loaded!", this.driver.getCurrentUrl().contains(createAccURL));
    }

    private void enterTaxID(String text) {
        basePage.enterText(WebPageElement.taxID, text);
    }

    private void enterFirstName(String text) {
        basePage.enterText(WebPageElement.firstname, text);
    }

    private void enterLastName(String text) {
        basePage.enterText(WebPageElement.lastname, text);
    }

    private void enterAddress1(String text) {
        basePage.enterText(WebPageElement.address1, text);
    }

    private void enterPostcode(String text) {
        basePage.enterText(WebPageElement.postcode, text);
    }

    private void enterCity(String text) {
        basePage.enterText(WebPageElement.city, text);
    }

    private void enterEmail(String text) {
        basePage.enterText(WebPageElement.email, text);
    }

    private void enterPhone(String text) {
        basePage.enterText(WebPageElement.phone, text);
    }

    private void enterPassword(String text) {
        basePage.enterText(WebPageElement.password, text);
    }

    private void enterConfirmedPassword(String text) {
        basePage.enterText(WebPageElement.confirmedPassword, text);
    }

    private void clickOnCreateAccButton() {
        basePage.clickOnButton(WebPageElement.createAccButton);
    }

    private void selectCountry(String countryName) {
        basePage.selectOptionByName(WebPageElement.country, countryName);
    }

    public void createAccount(String taxID, String firstName, String lastName, String address1, String postcode,
                              String city, String countryName, String email, String phone, String password) {
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
