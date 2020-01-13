package patterns.structure.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import patterns.BaseAccountPageObject;
import utils.Locator;

import java.util.Map;

public class CreatePageFactory extends BaseAccountPageObject {
    @FindBy(name = Locator.taxID)
    WebElement taxID_elem;

    @FindBy(name = Locator.firstName)
    WebElement firstName_elem;

    @FindBy(name = Locator.lastName)
    WebElement lastName_elem;

    @FindBy(name = Locator.address1)
    WebElement address1_elem;

    @FindBy(name = Locator.postcode)
    WebElement postcode_elem;

    @FindBy(name = Locator.city)
    WebElement city_elem;

    @FindBy(name = Locator.email)
    WebElement email_elem;

    @FindBy(name = Locator.phone)
    WebElement phone_elem;

    @FindBy(name = Locator.country)
    private WebElement country_elem;

    @FindBy(name = Locator.password)
    private WebElement password_elem;

    @FindBy(name = Locator.confirmedPassword)
    private WebElement confirmedPassword_elem;

    @FindBy(name = Locator.createAccButton)
    private WebElement createAccButton;

    public CreatePageFactory(WebDriver driver) {
        super(driver);
        //elements initialization in constructor
        PageFactory.initElements(driver, this);
    }

    public void createAccount(Map<String, String> dataMap) {
        navigateToCreateAccountPage();
        taxID_elem.sendKeys(dataMap.get("taxID"));
        firstName_elem.sendKeys(dataMap.get("firstName"));
        lastName_elem.sendKeys(dataMap.get("lastName"));
        address1_elem.sendKeys(dataMap.get("address1"));
        postcode_elem.sendKeys(dataMap.get("postcode"));
        city_elem.sendKeys(dataMap.get("city"));
        selectOptionByName(country_elem, dataMap.get("country"));
        email_elem.sendKeys(dataMap.get("email") + Math.random());
        phone_elem.sendKeys(dataMap.get("phone"));
        password_elem.sendKeys(dataMap.get("password"));
        confirmedPassword_elem.sendKeys(dataMap.get("password"));
        createAccButton.click();
    }

}
