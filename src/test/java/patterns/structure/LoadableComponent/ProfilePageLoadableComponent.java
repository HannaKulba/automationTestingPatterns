package patterns.structure.LoadableComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;
import patterns.BasePageObject;
import utils.Urls;
import utils.WebPageElement;

import static org.testng.AssertJUnit.assertTrue;

public class ProfilePageLoadableComponent extends LoadableComponent<ProfilePageLoadableComponent> {
    private WebDriver driver;
    private String profileURL = Urls.editAccountURL.getURL();
    private BasePageObject basePage;

    public ProfilePageLoadableComponent(WebDriver driver) {
        this.driver = driver;
        basePage = new BasePageObject(driver);
    }

    @Override
    protected void load() {
        this.driver.get(profileURL);
    }

    @Override
    protected void isLoaded() throws Error {
        assertTrue("Profile page is not loaded!", this.driver.getCurrentUrl().contains(profileURL));
    }

    public String getTaxID() {
        return basePage.getValue(WebPageElement.taxID);
    }

    public String getFirstName() {
        return basePage.getValue(WebPageElement.firstname);
    }

    public String getLastName() {
        return basePage.getValue(WebPageElement.lastname);
    }

    public String getAddress1() {
        return basePage.getValue(WebPageElement.address1);
    }

    public String getPostCode() {
        return basePage.getValue(WebPageElement.postcode);
    }

    public String getCity() {
        return basePage.getValue(WebPageElement.city);
    }

    public String getCountry() {
        return basePage.getText(WebPageElement.chosenCountry);
    }

    public String getEmail() {
        return basePage.getValue(WebPageElement.email);
    }

    public String getPhone() {
        return basePage.getValue(WebPageElement.phone);
    }
}
