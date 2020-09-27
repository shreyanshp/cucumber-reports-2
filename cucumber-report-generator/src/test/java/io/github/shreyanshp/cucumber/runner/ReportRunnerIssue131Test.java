package io.github.shreyanshp.cucumber.runner;

import io.github.shreyanshp.cucumber.runner.runtime.ExtendedRuntimeOptions;
import org.junit.Test;

public class ReportRunnerIssue131Test {

    @Test
    public void testGenerateDetailedReport() {
        ExtendedRuntimeOptions extendedOption = new ExtendedRuntimeOptions();
        extendedOption.setDetailedReport(true);
        extendedOption.setDetailedAggregatedReport(true);
        extendedOption.setFormats(new String[] {"pdf"});
        extendedOption.setOutputFolder("target/runner/i131/");
        extendedOption.setScreenShotLocation("screenshots/");
        extendedOption.setScreenShotSize("300px");
        extendedOption.setReportPrefix("cucumber-results");
        extendedOption.setJsonReportPaths(new String[] {"src/test/resources/131/cucumber.json"});
        extendedOption.setConsolidatedReport(true);
        extendedOption.setConsolidatedReportConfig("src/test/resources/131/consolidated_batch.json");
        extendedOption.setKnownErrorsReport(true);
        extendedOption.setKnownErrorsConfig("src/test/resources/131/known_errors.json");
        extendedOption.setFeatureOverviewChart(true);
        extendedOption.setOverviewChartsReport(true);
        extendedOption.setOverviewReport(true);
        ReportRunner.run(extendedOption);
    }
}
