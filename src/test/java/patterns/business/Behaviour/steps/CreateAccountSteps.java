package patterns.business.Behaviour.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import patterns.business.Behaviour.driverSettings.DriverUtil;
import patterns.business.Behaviour.pageObjects.CreatePageCucumber;
import patterns.business.Behaviour.pageObjects.ProfilePageCucumber;

public class CreateAccountSteps {
    private CreatePageCucumber createPage;
    private ProfilePageCucumber profilePage;

    public CreateAccountSteps(DriverUtil driverUtil) {
        WebDriver driver = driverUtil.getDriver();
        createPage = new CreatePageCucumber(driver);
        profilePage = new ProfilePageCucumber(driver);
    }

    @Given("^go to create account page \"([^\"]*)\"$")
    public void go_to_create_account_page(String url) {
        createPage.navigateTo(url);
    }

    @When("^enter \"([^\"]*)\" to Tax ID$")
    public void enter_to_Tax_ID(String taxID) {
        createPage.enterTaxID(taxID);

    }

    @When("^enter \"([^\"]*)\" to First Name$")
    public void enter_to_First_Name(String firstName) {
        createPage.enterFirstName(firstName);
    }

    @When("^enter \"([^\"]*)\" Last Name$")
    public void enter_Last_Name(String lastName) {
        createPage.enterLastName(lastName);

    }

    @When("^enter \"([^\"]*)\" Address_1$")
    public void enter_Address(String address) {
        createPage.enterAddress1(address);
    }

    @When("^enter \"([^\"]*)\" Postcode$")
    public void enter_Postcode(String postcode) {
        createPage.enterPostcode(postcode);
    }

    @When("^enter \"([^\"]*)\" City$")
    public void enter_City(String city) {
        createPage.enterCity(city);
    }

    @When("^select \"([^\"]*)\" Country$")
    public void select_Country(String country) {
        createPage.selectCountry(country);
    }

    @When("^enter \"([^\"]*)\" Email$")
    public void enter_Email(String email) {
        createPage.enterEmail(email + Math.random());
    }

    @When("^enter \"([^\"]*)\" Phone$")
    public void enter_Phone(String phone) {
        createPage.enterPhone(phone);
    }

    @When("^enter \"([^\"]*)\" Desired Password$")
    public void enter_Desired_Password(String password) {
        createPage.enterPassword(password);
    }

    @When("^confirm \"([^\"]*)\" Password$")
    public void confirm_Password(String password) {
        createPage.enterConfirmedPassword(password);
    }

    @When("^click on Create Account button$")
    public void click_on_Create_Account_button() {
        createPage.clickOnCreateAccButton();
    }

    @Then("^should go to edit profile page \"([^\"]*)\"$")
    public void should_go_to_edit_profile_page(String url) {
        profilePage.navigateTo(url);
    }

    @Then("^check Tax ID \"([^\"]*)\"$")
    public void check_Tax_ID(String expected) {
        String actual = profilePage.getTaxID();
        Assert.assertEquals(actual, expected);
    }

    @Then("^check First Name \"([^\"]*)\"$")
    public void check_First_Name(String expected) {
        String actual = profilePage.getFirstName();
        Assert.assertEquals(actual, expected);
    }

    @Then("^check Last Name \"([^\"]*)\"$")
    public void check_Last_Name(String expected) {
        String actual = profilePage.getLastName();
        Assert.assertEquals(actual, expected);
    }

    @Then("^check Address_1 \"([^\"]*)\"$")
    public void check_Address(String expected) {
        String actual = profilePage.getAddress1();
        Assert.assertEquals(actual, expected);
    }

    @Then("^check Postcode \"([^\"]*)\"$")
    public void check_Postcode(String expected) {
        String actual = profilePage.getPostCode();
        Assert.assertEquals(actual, expected);
    }

    @Then("^check City \"([^\"]*)\"$")
    public void check_City(String expected) {
        String actual = profilePage.getCity();
        Assert.assertEquals(actual, expected);
    }

    @Then("^check Country \"([^\"]*)\"$")
    public void check_Country(String expected) {
        String actual = profilePage.getCountry();
        Assert.assertEquals(actual, expected);
    }

    @Then("^check Email \"([^\"]*)\"$")
    public void check_Email(String expected) {
        String actual = profilePage.getEmail();
        Assert.assertTrue(actual.contains(expected), "Actual " + actual + " doesn't contain expected " + expected);
    }

    @Then("^check Phone \"([^\"]*)\"$")
    public void check_Phone(String expected) {
        String actual = profilePage.getPhone();
        Assert.assertEquals(actual, expected);
    }
}
