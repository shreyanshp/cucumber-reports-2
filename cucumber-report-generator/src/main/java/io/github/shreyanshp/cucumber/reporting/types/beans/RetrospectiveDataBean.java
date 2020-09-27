package io.github.shreyanshp.cucumber.reporting.types.beans;

import io.github.shreyanshp.cucumber.reporting.types.breakdown.BreakdownStats;
import io.github.shreyanshp.cucumber.reporting.types.retrospective.RetrospectiveModel;

/**
 * Data structure which is used for the
 * <a href="http://shreyanshp.github.io/cucumber-reports/retrospective-results-report">
 * Retrospective Report</a> generation.
 * @author Mykola Kolisnyk
 */
public class RetrospectiveDataBean extends CommonDataBean {
    /**
     * The data representing particular retrospective report view.
     */
    private RetrospectiveModel model;
    /**
     * Contains the list of statistics for each run participating in the
     * retrospective report.
     */
    private BreakdownStats[] stats;
    public RetrospectiveModel getModel() {
        return model;
    }
    public void setModel(RetrospectiveModel modelValue) {
        this.model = modelValue;
    }
    public BreakdownStats[] getStats() {
        return stats;
    }
    public void setStats(BreakdownStats[] statsValue) {
        this.stats = statsValue;
    }
}
