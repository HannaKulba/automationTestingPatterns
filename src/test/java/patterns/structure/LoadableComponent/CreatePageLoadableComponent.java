package patterns.structure.LoadableComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import patterns.BaseAccountPageObject;
import utils.Urls;

import java.util.Map;

import static org.testng.AssertJUnit.assertTrue;

public class CreatePageLoadableComponent extends LoadableComponent<CreatePageLoadableComponent> {
    private WebDriver driver;
    private String createAccURL = Urls.createAccountURL.getURL();
    private BaseAccountPageObject baseAccPage;
    private LoadableComponent<HomePageLoadableComponent> parent;
    private WebDriverWait wait;

    public CreatePageLoadableComponent(WebDriver driver, LoadableComponent<HomePageLoadableComponent> parent) {
        this.driver = driver;
        baseAccPage = new BaseAccountPageObject(driver);
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

    public void createAccount(Map<String, String> dataMap) {
        baseAccPage.enterTaxID(dataMap.get("taxID"));
        baseAccPage.enterFirstName(dataMap.get("firstName"));
        baseAccPage.enterLastName(dataMap.get("lastName"));
        baseAccPage.enterAddress1(dataMap.get("address1"));
        baseAccPage.enterPostcode(dataMap.get("postcode"));
        baseAccPage.enterCity(dataMap.get("city"));
        baseAccPage.selectCountry(dataMap.get("country"));
        baseAccPage.enterEmail(dataMap.get("email") + Math.random());
        baseAccPage.enterPhone(dataMap.get("phone"));
        baseAccPage.enterPassword(dataMap.get("password"));
        baseAccPage.enterConfirmedPassword(dataMap.get("password"));
        baseAccPage.clickOnCreateAccButton();
    }
}
