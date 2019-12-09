package patterns.structure.LoadableComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;
import patterns.BasePageObject;
import utils.Urls;
import utils.WebPageElement;

import static org.testng.AssertJUnit.assertTrue;

public class HomePageLoadableComponent extends LoadableComponent<HomePageLoadableComponent> {
    private WebDriver driver;
    private BasePageObject basePage;
    private String homePageURL = Urls.homePageURL.getURL();

    public HomePageLoadableComponent(WebDriver driver) {
        this.driver = driver;
        basePage = new BasePageObject(driver);
    }

    //go to the page at the load method
    @Override
    protected void load() {
        this.driver.get(homePageURL);
    }

    //to check that the page has been loaded
    @Override
    protected void isLoaded() throws Error {
        assertTrue("HomePage is not loaded!", driver.getCurrentUrl().contains(homePageURL));
    }

    public void goToLoginPage() {
        basePage.clickOnButton(WebPageElement.newCustomer);
    }
}
