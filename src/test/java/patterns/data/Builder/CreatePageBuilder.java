package patterns.data.Builder;

import org.openqa.selenium.WebDriver;
import patterns.BaseAccountPageObject;
import utils.Account;

public class CreatePageBuilder extends BaseAccountPageObject {
    public CreatePageBuilder(WebDriver driver) {
        super(driver);
    }

    public void createAccount(Account acc)  {
        navigateToCreateAccountPage();
        enterTaxID(acc.getTaxID());
        enterFirstName(acc.getFirstName());
        enterLastName(acc.getLastName());
        enterAddress1(acc.getAddress1());
        enterPostcode(acc.getPostCode());
        enterCity(acc.getCity());
        selectCountry(acc.getCountry());
        enterEmail(acc.getEmail() + Math.random());
        enterPhone(acc.getPhone());
        enterPassword(acc.getPassword());
        enterConfirmedPassword(acc.getPassword());
        clickOnCreateAccButton();
    }
}
