package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:reports/myreport.html",
                "json:reports/myreport.json"},
        features = "src/test/resources/Features/CheckOut.feature", // path for feature files
        glue = "Steps",
        tags ="@CTC-1",
        dryRun = false

)
public class TestRunner {
}
