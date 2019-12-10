package patterns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.Urls;

public class BasePageObject {
    protected WebDriver driver;

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo(String URL) {
        driver.get(URL);
    }

    public void navigateTo(Urls URL) {
        driver.get(URL.getURL());
    }

    public void enterText(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    public void clickOnButton(By locator) {
        driver.findElement(locator).click();
    }

    public void selectOptionByName(By locator, String option) {
        WebElement elem = driver.findElement(locator);
        selectOptionByName(elem, option);
    }

    public void selectOptionByName(WebElement elem, String option) {
        Select select = new Select(elem);
        select.selectByVisibleText(option);
    }

    public String getValue(By locator) {
        return driver.findElement(locator).getAttribute("value");
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

}
