package io.github.shreyanshp.cucumber.reporting;

import java.io.File;

import io.github.shreyanshp.cucumber.reporting.types.beans.KnownErrorsDataBean;
import io.github.shreyanshp.cucumber.reporting.types.enums.CucumberReportError;
import io.github.shreyanshp.cucumber.reporting.types.enums.CucumberReportLink;
import io.github.shreyanshp.cucumber.reporting.types.enums.CucumberReportTypes;
import io.github.shreyanshp.cucumber.reporting.types.knownerrors.KnownErrorsResultSet;
import io.github.shreyanshp.cucumber.reporting.types.result.CucumberFeatureResult;
import io.github.shreyanshp.cucumber.reporting.types.result.CucumberScenarioResult;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Assert;

import io.github.shreyanshp.cucumber.reporting.interfaces.KECompatibleReport;
import io.github.shreyanshp.cucumber.reporting.types.knownerrors.KnownErrorsModel;
import io.github.shreyanshp.cucumber.runner.runtime.ExtendedRuntimeOptions;

public class CucumberKnownErrorsReport extends KECompatibleReport {
    public CucumberKnownErrorsReport() {
        super();
    }

    public CucumberKnownErrorsReport(ExtendedRuntimeOptions extendedOptions) {
        super(extendedOptions);
    }

    @Override
    public CucumberReportTypes getReportType() {
        return CucumberReportTypes.KNOWN_ERRORS;
    }

    @Override
    public CucumberReportLink getReportDocLink() {
        return CucumberReportLink.KNOWN_ERRORS_URL;
    }

    @Override
    public void execute(KnownErrorsModel batch, String[] formats) throws Exception {
        validateParameters();
        CucumberFeatureResult[] features = readFileContent(true);
        this.execute(batch, features, formats);
    }
    public void execute(KnownErrorsModel batch, CucumberFeatureResult[] features, String[] formats) throws Exception {
        validateParameters();
        File outFile = getOutputHtmlFile();
        KnownErrorsDataBean data = new KnownErrorsDataBean();
        CucumberScenarioResult[] scenarios = {};
        for (CucumberFeatureResult feature : features) {
            scenarios = ArrayUtils.addAll(scenarios, feature.getElements());
        }
        KnownErrorsResultSet results = new KnownErrorsResultSet();
        results.valuate(scenarios, batch);
        data.setResults(results.getResults());
        generateReportFromTemplate(outFile, this.templateName(), data);
        this.export(outFile, this.reportSuffix(), formats, this.isImageExportable());
    }

    @Deprecated
    @Override
    public void execute(boolean aggregate, String[] formats) throws Exception {
    }

    @Override
    public void validateParameters() {
        Assert.assertNotNull(this.constructErrorMessage(CucumberReportError.NO_OUTPUT_DIRECTORY, ""),
                this.getOutputDirectory());
        Assert.assertNotNull(this.constructErrorMessage(CucumberReportError.NO_OUTPUT_NAME, ""),
                this.getOutputName());
    }

    @Override
    public void execute(KnownErrorsModel batch, boolean aggregate, String[] formats)
            throws Exception {
        execute(batch, formats);
    }

    @Deprecated
    @Override
    public void execute(boolean aggregate, CucumberFeatureResult[] results,
            String[] formats) throws Exception {
    }

    @Override
    public void execute(KnownErrorsModel model,
            CucumberFeatureResult[] results, boolean aggregate, String[] formats)
            throws Exception {
        execute(model, results, formats);
    }
}
