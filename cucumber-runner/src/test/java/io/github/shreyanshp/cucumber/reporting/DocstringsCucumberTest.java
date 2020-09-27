package io.github.shreyanshp.cucumber.reporting;

import io.github.shreyanshp.cucumber.runner.ExtendedCucumberOptions;
import org.junit.runner.RunWith;

import io.github.shreyanshp.cucumber.runner.ExtendedCucumber;

import cucumber.api.CucumberOptions;


@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(jsonReport = "target/cucumber-docstring.json",
    retryCount = 3,
    detailedReport = true,
    detailedAggregatedReport = true,
    overviewReport = true,
    toPDF = true,
    outputFolder = "target",
    reportPrefix = "cucumber-docstring-report")
@CucumberOptions(plugin = { "html:target/cucumber-docstring-html-report",
        "json:target/cucumber-docstring.json", "pretty:target/cucumber-docstring-pretty.txt",
        "usage:target/cucumber-docstring-usage.json", "junit:target/cucumber-docstring-results.xml" },
        features = { "./src/test/java/com/github/mkolisnyk/cucumber/features" },
        glue = { "com/github/mkolisnyk/cucumber/steps" },
        tags = {"@docstring" })
public class DocstringsCucumberTest {
}
