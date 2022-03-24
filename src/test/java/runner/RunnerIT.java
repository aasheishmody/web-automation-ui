package runner;


import ch.qos.logback.classic.Logger;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import utilities.ConfigFileReader;




@CucumberOptions
        (
                glue = {"stepDefinitions"},
                features = "src/test/resources/features/",
                plugin = {"pretty", "json:target/json-files/cucumber.json" + "", "timeline:target"},
                tags = {"@ui"},
                monochrome = true
        )

public class RunnerIT extends AbstractTestNGCucumberTests {


    @BeforeClass
    public void setUp() throws Exception {
        //set logging level before everything starts..
        Logger root = (Logger) LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
        root.setLevel(ConfigFileReader.getInstance().getLogLevel());
    }

    @AfterClass
    public void cleanUp() throws Exception {

    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}