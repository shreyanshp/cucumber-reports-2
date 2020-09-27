package io.github.shreyanshp.cucumber.reporting.types.breakdown.matchers;

import io.github.shreyanshp.cucumber.reporting.types.breakdown.DataDimension;
import io.github.shreyanshp.cucumber.reporting.types.result.CucumberScenarioResult;

public class NotMatcher extends ComplexMatcher {

    @Override
    public boolean matches(CucumberScenarioResult result, DataDimension filter) {
        if (filter.getSubElements() == null || filter.getSubElements().length <= 0) {
            return false;
        }
        for (DataDimension item : filter.getSubElements()) {
            Matcher matcher = create(item.getDimensionValue());
            if (matcher.matches(result, item)) {
                return false;
            }
        }
        return true;
    }

}
