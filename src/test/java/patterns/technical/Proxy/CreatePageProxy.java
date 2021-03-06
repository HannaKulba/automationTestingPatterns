package patterns.technical.Proxy;

import org.openqa.selenium.WebDriver;
import patterns.BaseAccountPageObject;
import utils.User;

public class CreatePageProxy extends BaseAccountPageObject {
    public CreatePageProxy(WebDriver driver) {
        super(driver);
    }

    public void createAccount(User user) {
        navigateToCreateAccountPage();
        enterTaxID(user.getTaxID());
        enterFirstName(user.getFirstName());
        enterLastName(user.getLastName());
        enterAddress1(user.getAddress1());
        enterPostcode(user.getPostCode());
        enterCity(user.getCity());
        selectCountry(user.getCountry());
        enterEmail(user.getEmail() + Math.random());
        enterPhone(user.getPhone());
        enterPassword(user.getPassword());
        enterConfirmedPassword(user.getPassword());
        clickOnCreateAccButton();
    }
}
