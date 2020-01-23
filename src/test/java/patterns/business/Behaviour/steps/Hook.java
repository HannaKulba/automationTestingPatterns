package patterns.business.Behaviour.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import patterns.business.Behaviour.driverSettings.DriverUtil;

public class Hook {
    private DriverUtil driverUtil;

    public Hook(DriverUtil driverUtil) {
        this.driverUtil = driverUtil;    }

    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("----- Scenario '" + scenario.getName() + "' started... -----");
        driverUtil.initializeDriver();
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("----- Scenario '" + scenario.getName() + "' was failed! -----");
        } else {
            System.out.println("----- Scenario '" + scenario.getName() + "' was successful! -----");
        }
        driverUtil.getDriver().quit();
    }
}
