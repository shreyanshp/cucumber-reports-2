package io.github.shreyanshp.cucumber.reporting;

import io.github.shreyanshp.cucumber.reporting.types.breakdown.DataDimension;
import io.github.shreyanshp.cucumber.reporting.types.breakdown.DimensionValue;
import io.github.shreyanshp.cucumber.runner.runtime.ExtendedRuntimeOptions;
import org.junit.Test;

import io.github.shreyanshp.cucumber.reporting.types.knownerrors.KnownErrorOrderBy;
import io.github.shreyanshp.cucumber.reporting.types.knownerrors.KnownErrorPriority;
import io.github.shreyanshp.cucumber.reporting.types.knownerrors.KnownErrorsInfo;
import io.github.shreyanshp.cucumber.reporting.types.knownerrors.KnownErrorsModel;

public class CucumberResultsKETest {
    private KnownErrorsModel model = new KnownErrorsModel(
            new KnownErrorsInfo[] {
               new KnownErrorsInfo(
                   "Unable to reach Select Ticket screen",
                   "Select ticket isn't shown",
                   new DataDimension(DimensionValue.FAILED_STEP, "(.*)see the \"Select Ticket\" screen"),
                   KnownErrorPriority.HIGHEST),
               new KnownErrorsInfo(
                   "Search Fails",
                   "Some search parameters do not bring results",
                   new DataDimension(DimensionValue.FAILED_STEP, "(.*)the \"Out Search Results\" screen"),
                   KnownErrorPriority.HIGH),
               new KnownErrorsInfo(
                   "Unexpected message",
                   "Message box shows unexpected content",
                   new DataDimension(DimensionValue.FAILED_STEP, "(.*)message is shown"),
                   KnownErrorPriority.LOW),
            },
            KnownErrorOrderBy.FREQUENCY);

    @Test
    public void testRunWithKEBatch() throws Exception {
        CucumberResultsOverview results = new CucumberResultsOverview();
        results.setOutputDirectory("target");
        results.setOutputName("cucumber-results-ke01");
        results.setSourceFile("./src/test/resources/cucumber.json");
        results.execute(model);
    }

    @Test
    public void testRunDetailedReportWithKEBatch() throws Exception {
        CucumberDetailedResults results = new CucumberDetailedResults();
        results.setOutputDirectory("target/");
        results.setOutputName("cucumber-results-ke01");
        results.setSourceFile("./src/test/resources/cucumber.json");
        results.setScreenShotLocation("../src/test/resources/");
        results.execute(model, true, new String[] {"pdf"});
    }
    @Test
    public void testRunChartsOverviewKEBatch() throws Exception {
        ExtendedRuntimeOptions options = new ExtendedRuntimeOptions();
        options.setOutputFolder("target/charts");
        options.setReportPrefix("cucumber-reports-ke1");
        options.setJsonReportPaths(new String[] {"src/test/resources/cucumber.json"});
        options.setOverviewReport(true);
        options.setCoverageReport(true);
        CucumberOverviewChartsReport report = new CucumberOverviewChartsReport(options);
        report.execute(model, true, new String[] {"pdf"});
    }
}
