package runner;

import io.cucumber.junit.platform.engine.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps",
        plugin = {
                "pretty",
                "html:build/reports/cucumber.html",
                "json:build/reports/cucumber.json"
        },
        monochrome = true,
        tags = ""
)
public class TestRunner {
}