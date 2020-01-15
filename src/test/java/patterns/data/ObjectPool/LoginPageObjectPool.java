package patterns.data.ObjectPool;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import patterns.BaseAccountPageObject;
import utils.WebPageElement;

public class LoginPageObjectPool extends BaseAccountPageObject {
    public LoginPageObjectPool(WebDriver driver) {
        super(driver);
    }

    private void clickOnLoginButton() {
        clickOnButton(WebPageElement.loginButton);
    }

    public void loginToAccount(String email, String password) {
        navigateToHomePage();
        enterEmail(email);
        enterPassword(password);
        clickOnLoginButton();
        Assert.assertTrue(driver.findElement(WebPageElement.loginSuccessMsg).isDisplayed(), "Login was not successful!");
    }

}
