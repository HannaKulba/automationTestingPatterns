package patterns.structure.LoadableComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import patterns.BasePageObject;
import utils.Urls;
import utils.WebPageElement;

import java.util.Map;

import static org.testng.AssertJUnit.assertTrue;

public class CreatePageLoadableComponent extends LoadableComponent<CreatePageLoadableComponent> {
    private WebDriver driver;
    private String createAccURL = Urls.createAccountURL.getURL();
    private BasePageObject basePage;
    private LoadableComponent<HomePageLoadableComponent> parent;
    private WebDriverWait wait;

    public CreatePageLoadableComponent(WebDriver driver, LoadableComponent<HomePageLoadableComponent> parent) {
        this.driver = driver;
        basePage = new BasePageObject(driver);
        this.parent = parent;
        this.wait = new WebDriverWait(driver, 10, 500);
    }

    @Override
    protected void load() {
        parent.get().goToCreatePage();
        wait.until(ExpectedConditions.titleContains("Create Account"));
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

    public void createAccount(Map<String, String> dataMap) {
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
