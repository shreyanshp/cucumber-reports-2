package io.github.shreyanshp.cucumber.reporting.types.breakdown.matchers;

import io.github.shreyanshp.cucumber.reporting.types.breakdown.DataDimension;
import io.github.shreyanshp.cucumber.reporting.types.result.CucumberScenarioResult;

public abstract class ComplexMatcher extends BaseMatcher {

    @Override
    public boolean isComplex() {
        return true;
    }

    @Override
    public boolean matches(CucumberScenarioResult result, String expression) {
        return false;
    }

    public abstract boolean matches(CucumberScenarioResult result, DataDimension filter);
}
