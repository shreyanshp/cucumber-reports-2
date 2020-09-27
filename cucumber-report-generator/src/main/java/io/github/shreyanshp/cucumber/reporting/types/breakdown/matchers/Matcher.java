package io.github.shreyanshp.cucumber.reporting.types.breakdown.matchers;

import io.github.shreyanshp.cucumber.reporting.types.breakdown.DataDimension;
import io.github.shreyanshp.cucumber.reporting.types.result.CucumberScenarioResult;

public interface Matcher {
    boolean isComplex();
    boolean matches(CucumberScenarioResult result, String expression);
    boolean matches(CucumberScenarioResult result, DataDimension filter);
}
