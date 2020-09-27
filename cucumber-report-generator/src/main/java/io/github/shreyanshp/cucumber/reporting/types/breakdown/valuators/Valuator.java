package io.github.shreyanshp.cucumber.reporting.types.breakdown.valuators;

import io.github.shreyanshp.cucumber.reporting.types.breakdown.BreakdownStats;
import io.github.shreyanshp.cucumber.reporting.types.breakdown.matchers.Matcher;
import io.github.shreyanshp.cucumber.reporting.types.result.CucumberScenarioResult;

public interface Valuator {
    BreakdownStats valuate(CucumberScenarioResult[] results, String expression, Matcher[] matchers);
}
