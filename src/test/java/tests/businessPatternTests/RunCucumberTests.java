package tests.businessPatternTests;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "./src/main/resources/features",
        glue = {"patterns/business/Behaviour/steps"},
        format = {"pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json"
        })

public class RunCucumberTests {
    private TestNGCucumberRunner runner;

    @BeforeClass(alwaysRun = true)
    public void setUP() {
        runner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(description = "Run Cucumber Feature", dataProvider = "features")
    public void test(CucumberFeatureWrapper feature) {
        runner.runCucumber(feature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return runner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        runner.finish();
    }

}
