package io.github.shreyanshp.cucumber.reporting;

import io.github.shreyanshp.cucumber.runner.runtime.ExtendedRuntimeOptions;
import org.junit.Test;

public class CucumberOverviewChartsReportTest {

    @Test
    public void testGenerateBasicOverviewChartReport() throws Exception {
        ExtendedRuntimeOptions options = new ExtendedRuntimeOptions();
        options.setOutputFolder("target/charts");
        options.setReportPrefix("cucumber-reports");
        options.setJsonReportPaths(new String[] {"src/test/resources/cucumber.json"});
        options.setOverviewReport(true);
        options.setCoverageReport(true);
        CucumberOverviewChartsReport report = new CucumberOverviewChartsReport(options);
        report.execute(true);
    }
    @Test
    public void testGenerateBasicOverviewChartReportNoCoverage() throws Exception {
        ExtendedRuntimeOptions options = new ExtendedRuntimeOptions();
        options.setOutputFolder("target/charts");
        options.setReportPrefix("cucumber-reports-no-cov");
        options.setJsonReportPaths(new String[] {"src/test/resources/cucumber.json"});
        options.setOverviewReport(true);
        CucumberOverviewChartsReport report = new CucumberOverviewChartsReport(options);
        report.execute(true);
    }
}
