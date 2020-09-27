package io.github.shreyanshp.cucumber.reporting;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

import io.github.shreyanshp.cucumber.reporting.types.beans.ConsolidatedDataBean;
import io.github.shreyanshp.cucumber.reporting.types.enums.CucumberReportLink;
import io.github.shreyanshp.cucumber.reporting.types.enums.CucumberReportTypes;
import io.github.shreyanshp.cucumber.reporting.types.result.CucumberFeatureResult;
import org.apache.commons.io.FileUtils;

import io.github.shreyanshp.cucumber.reporting.interfaces.ConfigurableReport;
import io.github.shreyanshp.cucumber.reporting.types.consolidated.ConsolidatedItemInfo;
import io.github.shreyanshp.cucumber.reporting.types.consolidated.ConsolidatedReportBatch;
import io.github.shreyanshp.cucumber.reporting.types.consolidated.ConsolidatedReportModel;
import io.github.shreyanshp.cucumber.reporting.utils.helpers.StringConversionUtils;
import io.github.shreyanshp.cucumber.runner.runtime.ExtendedRuntimeOptions;

public class CucumberConsolidatedReport extends ConfigurableReport<ConsolidatedReportBatch> {
    public CucumberConsolidatedReport() {
        super();
    }
    public CucumberConsolidatedReport(ExtendedRuntimeOptions extendedOptions) {
        super(extendedOptions);
    }
    private String retrieveBody(String content) {
        return content.split("<body>")[1].split("</body>")[0];
    }
    private String amendHtmlHeaders(String content) {
        final int totalHeadingTypes = 6;
        for (int i = totalHeadingTypes; i > 0; i--) {
            content = content.replaceAll("<h" + i + ">", "<h" + (i + 1) + ">");
            content = content.replaceAll("</h" + i + ">", "</h" + (i + 1) + ">");
        }
        return content;
    }
    public void executeConsolidatedReport(ConsolidatedReportModel model, String[] formats) throws Exception {
        File outFile = new File(
                this.getOutputDirectory() + File.separator + this.getOutputName()
                + "-" + model.getReportSuffix() + ".html");
        ConsolidatedDataBean data = new ConsolidatedDataBean();
        data.setTitle(model.getTitle());
        data.setRefreshData("");
        data.setColumns(model.getCols());
        data.setUseTableOfContents(model.isUseTableOfContents());
        Map<String, String> contentsMap = new LinkedHashMap<String, String>();
        for (ConsolidatedItemInfo item : model.getItems()) {
            File source = new File(item.getPath());
            String content = "<html><body>N/A</body></html>";
            if (source.exists()) {
                content = FileUtils.readFileToString(source);
            }
            content = this.amendHtmlHeaders(content);
            content = this.retrieveBody(content);
            content = StringConversionUtils.replaceHtmlEntitiesWithCodes(content);
            contentsMap.put(item.getTitle(), content);
        }
        data.setContents(contentsMap);
        generateReportFromTemplate(outFile, this.templateName(), data);
        this.export(outFile, model.getReportSuffix(), formats, this.isImageExportable());
    }
    public void executeConsolidatedReport(ConsolidatedReportModel model) throws Exception {
        executeConsolidatedReport(model, new String[] {});
    }
    @Override
    public CucumberReportTypes getReportType() {
        return CucumberReportTypes.CONSOLIDATED_REPORT;
    }
    @Override
    public void validateParameters() {
    }
    @Override
    public CucumberReportLink getReportDocLink() {
        return CucumberReportLink.CONSOLIDATED_URL;
    }
    @Override
    public void execute(ConsolidatedReportBatch batch, String[] formats)
            throws Exception {
        for (ConsolidatedReportModel model : batch.getModels()) {
            executeConsolidatedReport(model, formats);
        }
    }

    @Override
    public void execute(boolean aggregate, String[] formats) throws Exception {
    }
    @Override
    public void execute(ConsolidatedReportBatch batch, boolean aggregate,
            String[] formats) throws Exception {
        execute(batch, formats);
    }
    @Override
    public void execute(File config, boolean aggregate, String[] formats)
            throws Exception {
        execute(config, formats);
    }
    @Override
    public void execute(boolean aggregate, CucumberFeatureResult[] results,
            String[] formats) throws Exception {
    }
    @Override
    public void execute(ConsolidatedReportBatch model,
            CucumberFeatureResult[] results, boolean aggregate, String[] formats)
            throws Exception {
        execute(model, formats);
    }
}
