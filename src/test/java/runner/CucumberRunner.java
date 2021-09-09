package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = { "steps" },
        plugin = { "io.testproject.sdk.internal.reporting.extensions.cucumber.CucumberReporter" }
)
public class CucumberRunner {

}
