package tests.structurePatternTests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import patterns.structure.PageElement.TablePageElement;
import tests.BasicTestsSettings;
import utils.Urls;

public class PageElementPatternTests extends BasicTestsSettings {
    private TablePageElement tableElement;
    private int expectedRowCount = 7;
    private int expectedColumnCount = 3;
    private String expectedCellText3_2 = "Francisco Chang";

    @BeforeTest
    public void testSetUp_e() {
        tableElement = new TablePageElement(driver);
        driver.get(Urls.HTMLTableURL.getURL());
    }

    @Test
    public void checkIsTableDisplayed() {
        WebElement table = tableElement.getTable();
        Assert.assertTrue(table.isDisplayed(), "Table wasn't displayed at page");
    }

    @Test
    public void checkRowCount() {
        int rowCount = tableElement.getRowCount();
        Assert.assertEquals(rowCount, expectedRowCount, "Table contains " + rowCount + ".");
    }


    @Test
    public void checkColumnCount() {
        int columnCount = tableElement.getColumnCount();
        Assert.assertEquals(columnCount, expectedColumnCount, "Table contains " + columnCount + ".");
    }

    @Test
    public void checkTextInCell3_2() {
        String cellText3_2 = tableElement.getCellText(3, 2);
        Assert.assertEquals(cellText3_2, expectedCellText3_2, "Table contains " + cellText3_2 + ".");
    }

}