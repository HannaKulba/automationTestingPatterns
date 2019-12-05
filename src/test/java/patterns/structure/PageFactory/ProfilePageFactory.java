package patterns.structure.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Locator;

public class ProfilePageFactory extends CreatePageFactory {
    @FindBy(className = Locator.chosenCountry)
    private WebElement chosenCountry;

    public ProfilePageFactory(WebDriver driver) {
        super(driver);
        //elements initialization in constructor
        PageFactory.initElements(driver, this);
    }

    private String getValue(WebElement elem) {
        return elem.getAttribute("value");
    }

    public String getTaxID() {
        return getValue(taxID_elem);
    }

    public String getFirstName() {
        return getValue(firstName_elem);
    }

    public String getLastName() {
        return getValue(lastName_elem);
    }

    public String getAddress1() {
        return getValue(address1_elem);
    }

    public String getPostCode() {
        return getValue(postcode_elem);
    }

    public String getCity() {
        return getValue(city_elem);
    }

    public String getCountry() {
        return chosenCountry.getAttribute("title");
    }

    public String getEmail() {
        return getValue(email_elem);
    }

    public String getPhone() {
        return getValue(phone_elem);
    }
}
