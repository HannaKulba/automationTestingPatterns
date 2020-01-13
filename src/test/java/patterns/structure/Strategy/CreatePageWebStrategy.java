package patterns.structure.Strategy;

import org.openqa.selenium.WebDriver;
import patterns.BaseAccountPageObject;
import utils.IStrategy;
import utils.Urls;

import java.util.Map;

public class CreatePageWebStrategy extends BaseAccountPageObject implements IStrategy {
    public CreatePageWebStrategy(WebDriver driver) {
        super(driver);
    }

    @Override
    public Map createAccount(Map<String, String> loginData) {
        String email = loginData.get("email") + Math.random();
        navigateTo(Urls.createAccountURL);
        enterTaxID(loginData.get("taxID"));
        enterFirstName(loginData.get("firstName"));
        enterLastName(loginData.get("lastName"));
        enterAddress1(loginData.get("address1"));
        enterPostcode(loginData.get("postcode"));
        enterCity(loginData.get("city"));
        selectCountry(loginData.get("country"));
        enterEmail(email);
        enterPhone(loginData.get("phone"));
        enterPassword(loginData.get("password"));
        enterConfirmedPassword(loginData.get("password"));
        clickOnCreateAccButton();

        //loginData.put("email", email);
        return loginData;
    }
}
