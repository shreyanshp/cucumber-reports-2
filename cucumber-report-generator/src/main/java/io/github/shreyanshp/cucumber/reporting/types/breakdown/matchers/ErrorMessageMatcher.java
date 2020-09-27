package io.github.shreyanshp.cucumber.reporting.types.breakdown.matchers;

import org.apache.commons.lang3.StringUtils;

import io.github.shreyanshp.cucumber.reporting.types.result.CucumberScenarioResult;
import io.github.shreyanshp.cucumber.reporting.types.result.CucumberStepResult;

public class ErrorMessageMatcher extends SimpleMatcher {

    @Override
    public boolean matches(CucumberScenarioResult result, String expression) {
        if (result.getStatus().equalsIgnoreCase("passed")) {
            return false;
        }
        for (CucumberStepResult step : result.getSteps()) {
            if (step.getResult().getStatus().equalsIgnoreCase("failed")
                && StringUtils.isNotBlank(step.getResult().getErrorMessage())
                && (step.getResult().getErrorMessage().equals(expression)
                        || step.getResult().getErrorMessage().matches(expression))) {
                return true;
            }
        }
        return false;
    }

}
