package io.github.shreyanshp.cucumber.reporting.types.breakdown.matchers;

import io.github.shreyanshp.cucumber.reporting.types.result.CucumberScenarioResult;

public class ScenarioMatcher extends SimpleMatcher {
    @Override
    public boolean matches(CucumberScenarioResult result, String expression) {
        String name = result.getName();
        return name.equals(expression) || name.matches(expression);
    }
}
