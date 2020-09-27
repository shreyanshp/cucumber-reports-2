package io.github.shreyanshp.cucumber.reporting.types.breakdown.matchers;

import io.github.shreyanshp.cucumber.reporting.types.result.CucumberScenarioResult;

public class ContainerMatcher extends SimpleMatcher {

    @Override
    public boolean matches(CucumberScenarioResult result, String expression) {
        return true;
    }
}
