package patterns.structure.Strategy;

import org.openqa.selenium.WebDriver;
import patterns.BasePageObject;
import utils.IStrategy;

import java.util.Map;

public class CreatePageWebStrategy extends BasePageObject implements IStrategy {
    public CreatePageWebStrategy(WebDriver driver) {
        super(driver);
    }

    @Override
    public void createAccount(Map<String, String> loginData) {

    }
}
