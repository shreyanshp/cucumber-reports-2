package io.github.shreyanshp.cucumber.reporting.interfaces;

import java.io.File;

import io.github.shreyanshp.cucumber.reporting.types.enums.CucumberReportError;
import io.github.shreyanshp.cucumber.runner.runtime.ExtendedRuntimeOptions;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;

import com.cedarsoftware.util.io.JsonReader;
import io.github.shreyanshp.cucumber.reporting.types.knownerrors.KnownErrorsModel;

public abstract class KECompatibleReport extends ConfigurableReport<KnownErrorsModel> {

    public KECompatibleReport() {
    }

    public KECompatibleReport(ExtendedRuntimeOptions extendedOptions) {
        super(extendedOptions);
    }

    public abstract void execute(KnownErrorsModel batch, boolean aggregate, String[] formats) throws Exception;
    public void execute(KnownErrorsModel batch) throws Exception {
        execute(batch, false, new String[] {});
    }
    public void execute(File config, boolean aggregate, String[] formats) throws Exception {
        Assert.assertNotNull(this.constructErrorMessage(CucumberReportError.NO_CONFIG_FILE, ""),
                config);
        Assert.assertTrue(
                this.constructErrorMessage(CucumberReportError.NON_EXISTING_CONFIG_FILE, ""),
                config.exists());
        String content = FileUtils.readFileToString(config);
        KnownErrorsModel model = null;
        try {
            model = (KnownErrorsModel) JsonReader.jsonToJava(content);
        } catch (Throwable e) {
            Assert.fail(this.constructErrorMessage(CucumberReportError.INVALID_CONFIG_FILE, ""));
        }
        this.execute(model, aggregate, formats);
    }
    public void execute(File config, boolean aggregate) throws Exception {
        execute(config, aggregate, new String[] {});
    }
}
