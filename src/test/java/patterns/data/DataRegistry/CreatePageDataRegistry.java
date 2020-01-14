package patterns.data.DataRegistry;

import org.openqa.selenium.WebDriver;
import patterns.BaseAccountPageObject;
import utils.EmailRegistry;

import java.util.Map;

public class CreatePageDataRegistry extends BaseAccountPageObject {
    public CreatePageDataRegistry(WebDriver driver) {
        super(driver);
    }

    public void createAccount(Map<String, String> dataMap) {
        navigateToCreateAccountPage();
        enterTaxID(dataMap.get("taxID"));
        enterFirstName(dataMap.get("firstName"));
        enterLastName(dataMap.get("lastName"));
        enterAddress1(dataMap.get("address1"));
        enterPostcode(dataMap.get("postcode"));
        enterCity(dataMap.get("city"));
        selectCountry(dataMap.get("country"));
        enterEmail(EmailRegistry.getUniqEmail(dataMap.get("email")));
        enterPhone(dataMap.get("phone"));
        enterPassword(dataMap.get("password"));
        enterConfirmedPassword(dataMap.get("password"));
        clickOnCreateAccButton();
    }
}
