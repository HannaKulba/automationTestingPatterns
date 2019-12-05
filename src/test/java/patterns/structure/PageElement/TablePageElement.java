package patterns.structure.PageElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Locator;
import utils.WebPageElement;

import java.util.List;

public class TablePageElement {
    private WebDriver driver;

    public TablePageElement(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getTable() {
        return driver.findElement(WebPageElement.table);
    }

    public int getRowCount() {
        List<WebElement> rows = getTable().findElements(WebPageElement.row);
        return rows.size();
    }

    public int getColumnCount() {
        List<WebElement> columns = getTable().findElements(WebPageElement.columnName);
        return columns.size();
    }

    public String getCellText(int rowIndex, int columnIndex) {
        return getTable().findElement(By.cssSelector("#" + Locator.tableID + " " + Locator.rowTag + ":nth-child(" + rowIndex + ") > "
                + Locator.columnTag + ":nth-child(" + columnIndex + ")")).getText();
    }
}
