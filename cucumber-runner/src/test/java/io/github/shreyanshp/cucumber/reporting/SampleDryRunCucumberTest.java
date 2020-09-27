package io.github.shreyanshp.cucumber.reporting;

import io.github.shreyanshp.cucumber.runner.ExtendedCucumberOptions;
import org.junit.runner.RunWith;

import io.github.shreyanshp.cucumber.runner.ExtendedCucumber;

import cucumber.api.CucumberOptions;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(
        jsonReport = "target/cucumber-dry.json",
        retryCount = 0,
        coverageReport = true,
        featureMapReport = true,
        featureMapConfig = "src/test/resources/breakdown-source/simple.json",
        excludeCoverageTags = {"@flaky" },
        includeCoverageTags = {"@passed" },
        reportPrefix = "dry-run",
        outputFolder = "target")
@CucumberOptions(plugin = { "html:target/cucumber-html-report",
        "json:target/cucumber-dry.json", "pretty:target/cucumber-pretty-dry.txt",
        "usage:target/cucumber-usage-dry.json", "junit:target/cucumber-results-dry.xml" },
        features = { "./src/test/java/com/github/mkolisnyk/cucumber/features" },
        glue = { "com/github/mkolisnyk/cucumber/steps" },
        tags = { "~@lazy"},
        dryRun = true)
public class SampleDryRunCucumberTest {

    public SampleDryRunCucumberTest() {
        // TODO Auto-generated constructor stub
    }

}
