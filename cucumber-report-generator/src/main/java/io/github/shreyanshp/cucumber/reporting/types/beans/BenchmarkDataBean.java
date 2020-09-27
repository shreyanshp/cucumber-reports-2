package io.github.shreyanshp.cucumber.reporting.types.beans;

import io.github.shreyanshp.cucumber.reporting.types.benchmark.BenchmarkRowData;

/**
 * Data structure which is supposed to be passed to
 * <a href="http://mkolisnyk.github.io/cucumber-reports/benchmark">Benchmark Report</a>.
 * Generally it contains run statistics for features and scenarios.
 * @author mykolak
 */
public class BenchmarkDataBean extends CommonDataBean {
    /**
     * The array of benchmark headers. Each header correspond to the specific run
     * which is the part of the benchmark.
     */
    private String[] headers;
    /**
     * Contains run statistics for each specific feature split by different runs.
     */
    private BenchmarkRowData[] featureRows;
    /**
     * Contains run statistics for each specific scenario split by different runs.
     */
    private BenchmarkRowData[] scenarioRows;
    public String[] getHeaders() {
        return headers;
    }
    public void setHeaders(String[] headersValue) {
        this.headers = headersValue;
    }
    public BenchmarkRowData[] getFeatureRows() {
        return featureRows;
    }
    public void setFeatureRows(BenchmarkRowData[] featureRowsValue) {
        this.featureRows = featureRowsValue;
    }
    public BenchmarkRowData[] getScenarioRows() {
        return scenarioRows;
    }
    public void setScenarioRows(BenchmarkRowData[] scenarioRowsValue) {
        this.scenarioRows = scenarioRowsValue;
    }
}
