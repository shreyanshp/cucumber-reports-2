package io.github.shreyanshp.cucumber.runner;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;

import cucumber.runtime.Runtime;
import cucumber.runtime.junit.ExecutionUnitRunner;
import cucumber.runtime.junit.JUnitReporter;
import cucumber.runtime.model.CucumberScenario;

public class ExtendedExecutionUnitRunner extends ExecutionUnitRunner {

    private JUnitReporter jUnitReporter;
    private CucumberScenario cucumberScenario;
    private Runtime runtime;

    public ExtendedExecutionUnitRunner(
            Runtime runtimeValue,
            CucumberScenario cucumberScenarioValue,
            JUnitReporter jUnitReporterValue)
            throws InitializationError {
        super(runtimeValue, cucumberScenarioValue, jUnitReporterValue);
        this.runtime = runtimeValue;
        this.cucumberScenario = cucumberScenarioValue;
        this.jUnitReporter = jUnitReporterValue;
    }

    @Override
    public void run(RunNotifier notifier) {
        jUnitReporter.startExecutionUnit(this, notifier);
        // This causes runChild to never be called, which seems OK.
        cucumberScenario.run(jUnitReporter, jUnitReporter, runtime);
        jUnitReporter.finishExecutionUnit();
    }

    public final CucumberScenario getCucumberScenario() {
        return cucumberScenario;
    }

    public final void setCucumberScenario(CucumberScenario cucumberScenarioValue) {
        this.cucumberScenario = cucumberScenarioValue;
    }
}
