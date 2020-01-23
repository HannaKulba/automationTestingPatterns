package patterns.business.Behaviour.driverSettings;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverUtil {
    private WebDriver driver;

    public void initializeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("start-maximized");
        driver = new ChromeDriver(option);
    }

    public WebDriver getDriver() {
        return driver;
    }
}
