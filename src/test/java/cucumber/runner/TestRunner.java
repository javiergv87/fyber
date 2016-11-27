package cucumber.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Javi on 26/11/2016.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.steps"},
        features = "src/test/resources/features/",
        format = {"pretty", "html:target/cucumber", "json:target/cucumber-report.json"}
)
public class TestRunner {

}
