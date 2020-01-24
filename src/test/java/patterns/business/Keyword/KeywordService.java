package patterns.business.Keyword;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.keywordsUtils.Keywords;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class KeywordService {
    private WebDriver driver;
    private CreatePageKeyword createPage;
    private ProfilePageKeyword profilePage;
    private ArrayList<String> userData = new ArrayList<>();

    public KeywordService(WebDriver driver) {
        this.driver = driver;
        createPage = new CreatePageKeyword(driver);
        profilePage = new ProfilePageKeyword(driver);
    }

    public BufferedReader readKeywordsFile(String path) {
        try {
            return new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void generateCreateAccountTest(BufferedReader reader) {
        try {
            String newLine;
            while ((newLine = reader.readLine()) != null) {
                String[] commandLine = newLine.split(",");
                String command = commandLine[0];
                switch (command) {
                    case Keywords.NAVIGATE_TO_CREATE_ACCOUNT_PAGE:
                        String url = commandLine[1];
                        System.out.println("Keyword: " + command + ". Go to '" + url + "'");
                        createPage.navigateTo(url);
                        break;
                    case Keywords.ENTER_TAX_ID:
                        String taxId = commandLine[1];
                        System.out.println("Keyword: " + command + ". Enter '" + taxId + "'");
                        createPage.enterTaxID(taxId);
                        userData.add(taxId);
                        break;
                    case Keywords.ENTER_FIRST_NAME:
                        String fn = commandLine[1];
                        System.out.println("Keyword: " + command + ". Enter '" + fn + "'");
                        createPage.enterFirstName(fn);
                        userData.add(fn);
                        break;
                    case Keywords.ENTER_LAST_NAME:
                        String ln = commandLine[1];
                        System.out.println("Keyword: " + command + ". Enter '" + ln + "'");
                        createPage.enterLastName(ln);
                        userData.add(ln);
                        break;
                    case Keywords.ENTER_ADDRESS1:
                        String addr = commandLine[1];
                        System.out.println("Keyword: " + command + ". Enter '" + addr + "'");
                        createPage.enterAddress1(addr);
                        userData.add(addr);
                        break;
                    case Keywords.ENTER_POSTCODE:
                        String postCode = commandLine[1];
                        System.out.println("Keyword: " + command + ". Enter '" + postCode + "'");
                        createPage.enterPostcode(postCode);
                        userData.add(postCode);
                        break;
                    case Keywords.ENTER_CITY:
                        String city = commandLine[1];
                        System.out.println("Keyword: " + command + ". Enter '" + city + "'");
                        createPage.enterCity(city);
                        userData.add(city);
                        break;
                    case Keywords.SELECT_COUNTRY_FROM_LIST:
                        String country = commandLine[1];
                        System.out.println("Keyword: " + command + ". Enter '" + country + "'");
                        createPage.selectCountry(country);
                        userData.add(country);
                        break;
                    case Keywords.ENTER_EMAIL:
                        String email = commandLine[1];
                        System.out.println("Keyword: " + command + ". Enter '" + email + "'");
                        createPage.enterEmail(email + Math.random());
                        userData.add(email);
                        break;
                    case Keywords.ENTER_PHONE:
                        String phone = commandLine[1];
                        System.out.println("Keyword: " + command + ". Enter '" + phone + "'");
                        createPage.enterPhone(phone);
                        userData.add(phone);
                        break;
                    case Keywords.ENTER_PASSWORD:
                        String pass = commandLine[1];
                        System.out.println("Keyword: " + command + ". Enter '" + pass + "'");
                        createPage.enterPassword(pass);
                        break;
                    case Keywords.ENTER_CONFIRMED_PASSWORD:
                        String confPass = commandLine[1];
                        System.out.println("Keyword: " + command + ". Enter '" + confPass + "'");
                        createPage.enterConfirmedPassword(confPass);
                        break;
                    case Keywords.CLICK_ON_CREATE_ACCOUNT_BUTTON:
                        System.out.println("Keyword: " + command + ". Click on button 'Create Account'");
                        createPage.clickOnCreateAccButton();
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception ex) {
            ex.getMessage();
            ex.printStackTrace();
        }
    }

    public void generateVerifyTests(BufferedReader reader) {
        try {
            String newLine;
            while ((newLine = reader.readLine()) != null) {
                String[] commandLine = newLine.split(",");
                String command = commandLine[0];
                switch (command) {
                    case Keywords.NAVIGATE_TO_PROFILE_PAGE:
                        String url = commandLine[1];
                        System.out.println("Keyword: " + command + ". Go to '" + url + "'");
                        profilePage.navigateTo(url);
                        break;
                    case Keywords.VERIFY_TAX_ID:
                        String actualTaxId = profilePage.getTaxID();
                        String expectedTaxId = userData.get(0);
                        System.out.println("Keyword: " + command + ". Actual ( " + actualTaxId + ") and expected ( " + expectedTaxId + ")");
                        Assert.assertEquals(actualTaxId, expectedTaxId);
                        break;
                    case Keywords.VERIFY_FIRST_NAME:
                        String actualFn = profilePage.getFirstName();
                        String expectedFn = userData.get(1);
                        System.out.println("Keyword: " + command + ". Actual ( " + actualFn + ") and expected ( " + expectedFn + ")");
                        Assert.assertEquals(actualFn, expectedFn);
                        break;
                    case Keywords.VERIFY_LAST_NAME:
                        String actualLn = profilePage.getLastName();
                        String expectedLn = userData.get(2);
                        System.out.println("Keyword: " + command + ". Actual ( " + actualLn + ") and expected ( " + expectedLn + ")");
                        Assert.assertEquals(actualLn, expectedLn);
                        break;
                    case Keywords.VERIFY_ADDRESS1:
                        String actualAddress = profilePage.getAddress1();
                        String expectedAddress = userData.get(3);
                        System.out.println("Keyword: " + command + ". Actual ( " + actualAddress + ") and expected ( " + expectedAddress + ")");
                        Assert.assertEquals(actualAddress, expectedAddress);
                        break;
                    case Keywords.VERIFY_POSTCODE:
                        String actualPostCode = profilePage.getPostCode();
                        String expectedPostCode = userData.get(4);
                        System.out.println("Keyword: " + command + ". Actual ( " + actualPostCode + ") and expected ( " + expectedPostCode + ")");
                        Assert.assertEquals(actualPostCode, expectedPostCode);
                        break;
                    case Keywords.VERIFY_CITY:
                        String actualCity = profilePage.getCity();
                        String expectedCity = userData.get(5);
                        System.out.println("Keyword: " + command + ". Actual ( " + actualCity + ") and expected ( " + expectedCity + ")");
                        Assert.assertEquals(actualCity, expectedCity);
                        break;
                    case Keywords.VERIFY_COUNTRY:
                        String actualCountry = profilePage.getCountry();
                        String expectedCountry = userData.get(6);
                        System.out.println("Keyword: " + command + ". Actual ( " + actualCountry + ") and expected ( " + expectedCountry + ")");
                        Assert.assertEquals(actualCountry, expectedCountry);
                        break;
                    case Keywords.VERIFY_EMAIL:
                        String actualEmail = profilePage.getEmail();
                        String expectedEmail = userData.get(7);
                        System.out.println("Keyword: " + command + ". Actual ( " + actualEmail + ") and expected ( " + expectedEmail + ")");
                        Assert.assertTrue(actualEmail.contains(expectedEmail), "Actual email was " + actualEmail + " . Expected - " + expectedEmail);
                        break;
                    case Keywords.VERIFY_PHONE:
                        String actualPhone = profilePage.getPhone();
                        String expectedPhone = userData.get(8);
                        System.out.println("Keyword: " + command + ". Actual ( " + actualPhone + ") and expected ( " + expectedPhone + ")");
                        Assert.assertEquals(actualPhone, expectedPhone);
                        break;
                }
            }
        } catch (Exception ex) {
            ex.getMessage();
            ex.printStackTrace();
        }
    }
}
