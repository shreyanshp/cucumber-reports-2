package io.github.shreyanshp.cucumber.reporting.types.breakdown.matchers;

import io.github.shreyanshp.cucumber.reporting.types.result.CucumberScenarioResult;

public class TagMatcher extends SimpleMatcher {

    @Override
    public boolean matches(CucumberScenarioResult result, String expression) {
        String[] tags = result.getAllTags();
        for (String tag : tags) {
            if (tag.equals(expression) || tag.matches(expression)) {
                return true;
            }
        }
        return false;
    }
}
