package patterns.structure.LoadableComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;
import patterns.BaseProfilePageObject;
import utils.Urls;

import static org.testng.AssertJUnit.assertTrue;

public class ProfilePageLoadableComponent extends LoadableComponent<ProfilePageLoadableComponent> {
    private WebDriver driver;
    private String profileURL = Urls.editAccountURL.getURL();
    private BaseProfilePageObject baseProfilePage;

    public ProfilePageLoadableComponent(WebDriver driver) {
        this.driver = driver;
        baseProfilePage = new BaseProfilePageObject(driver);
    }

    @Override
    protected void load() {
        this.driver.get(profileURL);
    }

    @Override
    protected void isLoaded() throws Error {
        assertTrue("ProfilePageBuilder page is not loaded!", this.driver.getCurrentUrl().contains(profileURL));
    }

    public String getTaxID() {
        return baseProfilePage.getTaxID();
    }

    public String getFirstName() {
        return baseProfilePage.getFirstName();
    }

    public String getLastName() {
        return baseProfilePage.getLastName();
    }

    public String getAddress1() {
        return baseProfilePage.getAddress1();
    }

    public String getPostCode() {
        return baseProfilePage.getPostCode();
    }

    public String getCity() {
        return baseProfilePage.getCity();
    }

    public String getCountry() {
        return baseProfilePage.getCountry();
    }

    public String getEmail() {
        return baseProfilePage.getEmail();
    }

    public String getPhone() {
        return baseProfilePage.getPhone();
    }
}
