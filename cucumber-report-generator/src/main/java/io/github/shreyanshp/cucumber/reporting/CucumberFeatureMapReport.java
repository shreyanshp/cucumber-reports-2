package io.github.shreyanshp.cucumber.reporting;

import java.io.File;
import java.util.Locale;

import io.github.shreyanshp.cucumber.reporting.types.beans.FeatureMapDataBean;
import io.github.shreyanshp.cucumber.reporting.types.breakdown.BreakdownReportInfo;
import io.github.shreyanshp.cucumber.reporting.types.breakdown.BreakdownTable;
import io.github.shreyanshp.cucumber.reporting.types.enums.CucumberReportTypes;
import io.github.shreyanshp.cucumber.reporting.types.result.CucumberFeatureResult;
import io.github.shreyanshp.cucumber.reporting.types.result.CucumberScenarioResult;
import org.apache.commons.lang3.ArrayUtils;
import org.codehaus.plexus.util.StringUtils;

import io.github.shreyanshp.cucumber.runner.runtime.ExtendedRuntimeOptions;

public class CucumberFeatureMapReport extends CucumberBreakdownReport {

    public CucumberFeatureMapReport() {
        super();
    }
    public CucumberFeatureMapReport(ExtendedRuntimeOptions extendedOptions) {
        super(extendedOptions);
    }
    @Override
    public void executeReport(BreakdownReportInfo info, BreakdownTable table, String[] formats) throws Exception {
        CucumberFeatureResult[] features = readFileContent(true);
        File outFile = new File(
                this.getOutputDirectory() + File.separator + this.getOutputName()
                + "-" + info.getReportSuffix() + ".html");
        CucumberScenarioResult[] scenarios = new CucumberScenarioResult[] {};
        for (int j = 0; j < features.length; j++) {
            CucumberScenarioResult[] elements = features[j].getElements();
            for (int i = 0; i < elements.length; i++) {
                elements[i].setFeature(features[j]);
            }
            scenarios = ArrayUtils.addAll(scenarios, elements);
        }
        CucumberScenarioResult[][][] results = table.valuateScenarios(scenarios);
        FeatureMapDataBean data = new FeatureMapDataBean();
        data.setTitle(info.getTitle());
        if (info.getRefreshTimeout() > 0 && StringUtils.isNotBlank(info.getNextFile())) {
            data.setRefreshData(String.format(Locale.US,
                    "<meta http-equiv=\"Refresh\" content=\"%d; url=%s\" />",
                        info.getRefreshTimeout(), info.getNextFile()));
        }
        data.setScenarios(results);
        data.setTable(table);
        generateReportFromTemplate(outFile, this.templateName(), data);
        this.export(outFile, info.getReportSuffix(), formats, this.isImageExportable());
    }

    @Override
    public CucumberReportTypes getReportType() {
        return CucumberReportTypes.FEATURE_MAP_REPORT;
    }
}
