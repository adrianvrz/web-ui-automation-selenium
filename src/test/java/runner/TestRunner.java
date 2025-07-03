package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps",
        plugin = {
                "pretty",
                "html:build/reports/cucumber.html",
                "json:build/reports/cucumber.json",
                "junit:build/test-results/test/cucumber.xml"
        },
        monochrome = true,
        tags = ""
)
public class TestRunner {
}