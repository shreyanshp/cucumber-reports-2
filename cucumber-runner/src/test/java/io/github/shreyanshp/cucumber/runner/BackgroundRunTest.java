package io.github.shreyanshp.cucumber.runner;

import org.junit.Ignore;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;

@Ignore
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(jsonReport = "target/cucumber-127.json",
    retryCount = 1,
    detailedReport = true,
    detailedAggregatedReport = true,
    overviewReport = false, toPDF = false, outputFolder = "target/127")
@CucumberOptions(
        features = { "./src/test/java/com/github/shreyanshp/cucumber/issue127" },
        glue = { "com/github/shreyanshp/cucumber/steps" },
        plugin = {
        "json:target/cucumber-127.json", "html:target/cucumber-html-report",
        "pretty:target/cucumber-pretty.txt",
        "usage:target/cucumber-usage.json",
        "junit:target/cucumber-junit-results.xml" }, tags = {})
public class BackgroundRunTest {
}
