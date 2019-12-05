package patterns.structure.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.Locator;
import utils.Urls;

public class CreatePageFactory {
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

    private WebDriver driver;

    public CreatePageFactory(WebDriver driver) {
        this.driver = driver;
        //elements initialization in constructor
        PageFactory.initElements(driver, this);
    }

    public void navigateTo(Urls URL) {
        driver.get(URL.getURL());
    }

    public void selectOptionByName(WebElement elem, String option) {
        Select select = new Select(elem);
        select.selectByVisibleText(option);
    }

    public void createAccount(String taxID, String firstName, String lastName, String address1, String postcode,
                              String city, String countryName, String email, String phone, String password) {
        navigateTo(Urls.createAccountURL);
        taxID_elem.sendKeys(taxID);
        firstName_elem.sendKeys(firstName);
        lastName_elem.sendKeys(lastName);
        address1_elem.sendKeys(address1);
        postcode_elem.sendKeys(postcode);
        city_elem.sendKeys(city);
        selectOptionByName(country_elem, countryName);
        email_elem.sendKeys(email);
        phone_elem.sendKeys(phone);
        password_elem.sendKeys(password);
        confirmedPassword_elem.sendKeys(password);
        createAccButton.click();
    }

}
