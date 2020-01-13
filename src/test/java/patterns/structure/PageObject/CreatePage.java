package patterns.structure.PageObject;

import org.openqa.selenium.WebDriver;
import patterns.BaseAccountPageObject;

import java.util.Map;

public class CreatePage extends BaseAccountPageObject {

    public CreatePage(WebDriver driver) {
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
        enterEmail(dataMap.get("email") + Math.random());
        enterPhone(dataMap.get("phone"));
        enterPassword(dataMap.get("password"));
        enterConfirmedPassword(dataMap.get("password"));
        clickOnCreateAccButton();
    }

}
