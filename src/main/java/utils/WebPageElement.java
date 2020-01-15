package utils;

import org.openqa.selenium.By;

public class WebPageElement {
    //for http://litecart.stqa.ru/
    public static By taxID = By.name(Locator.taxID);
    public static By firstname = By.name(Locator.firstName);
    public static By lastname = By.name(Locator.lastName);
    public static By address1 = By.name(Locator.address1);
    public static By postcode = By.name(Locator.postcode);
    public static By city = By.name(Locator.city);
    public static By email = By.name(Locator.email);
    public static By phone = By.name(Locator.phone);
    public static By country = By.name(Locator.country);
    public static By password = By.name(Locator.password);
    public static By confirmedPassword = By.name(Locator.confirmedPassword);
    public static By createAccButton = By.name(Locator.createAccButton);
    public static By chosenCountry = By.className(Locator.chosenCountry);
    public static By newCustomer = By.cssSelector(Locator.newCustomerLinkTag+":nth-child(5)");
    public static By loginButton = By.name(Locator.loginButton);
    public static By loginErrorMsg = By.className(Locator.loginErrorMsg);
    public static By loginSuccessMsg = By.cssSelector(Locator.loginSuccessMsg);

    //for https://www.w3schools.com/html/html_tables.asp
    public static By table = By.id(Locator.tableID);
    public static By row = By.tagName(Locator.rowTag);
    public static By columnName = By.tagName(Locator.columnNameTag);

}
