package tests.dataPatternTests;

import au.com.bytecode.opencsv.CSVReader;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import patterns.structure.PageObject.CreatePage;
import patterns.structure.PageObject.ProfilePage;
import tests.BasicTestsSettings;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DataProviderPatternTests extends BasicTestsSettings {
    private CreatePage createPage;
    private ProfilePage profilePage;
    private String pathToCSV = "./src/main/resources/Data_CreateAccounts.csv";

    private Map<String, String> getMap(String taxID, String firstName, String lastname, String address1, String postcode, String city, String country, String email, String phone, String password) {
        Map<String, String> result = new TreeMap<>();
        result.put("taxID", taxID);
        result.put("firstName", firstName);
        result.put("lastName", lastname);
        result.put("address1", address1);
        result.put("postcode", postcode);
        result.put("city", city);
        result.put("country", country);
        result.put("email", email);
        result.put("phone", "+" + phone);
        result.put("password", password);
        return result;
    }

    @BeforeTest
    public void testSetUp_dp() {
        createPage = new CreatePage(driver);
        profilePage = new ProfilePage(driver);
    }

    @DataProvider
    public Object[][] dataProvider() {
        Object[][] data = null;
        try {
            CSVReader reader = new CSVReader(new FileReader(pathToCSV), ',', '"', 1);
            List<String[]> rows = reader.readAll();
            int rowsNumber = rows.size();
            int columnsNumber = rows.get(0).length;
            data = new Object[rowsNumber][columnsNumber];
            for (int i = 0; i < rowsNumber; i++) {
                for (int j = 0; j < columnsNumber; j++) {
                    data[i][j] = rows.get(i)[j];
                }
            }
        } catch (IOException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return data;
    }

    @Test(dataProvider = "dataProvider")
    public void create_account(String taxID, String firstName, String lastname, String address1, String postcode, String city,
                               String country, String email, String phone, String password) throws InterruptedException {

        Map<String, String> dataMap = getMap(taxID, firstName, lastname, address1, postcode, city, country, email, phone, password);
        createPage.createAccount(dataMap);
        profilePage.logout();
    }

}
