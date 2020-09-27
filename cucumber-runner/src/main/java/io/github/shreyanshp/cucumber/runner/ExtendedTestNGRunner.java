package io.github.shreyanshp.cucumber.runner;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import io.github.shreyanshp.cucumber.runner.runtime.ExtendedRuntimeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;


public class ExtendedTestNGRunner extends AbstractTestNGCucumberTests {
    private Class<?> clazz;
    private ExtendedRuntimeOptions[] extendedOptions;

    private void runPredefinedMethods(Class<?> annotation) throws Exception {
        Method[] methodList = this.clazz.getMethods();
        for (Method method : methodList) {
            Annotation[] annotations = method.getAnnotations();
            for (Annotation item : annotations) {
                if (item.annotationType().equals(annotation)) {
                    method.invoke(this);
                    break;
                }
            }
        }
    }

    @Override
    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        super.setUpClass();
        this.clazz = this.getClass();
        try {
            extendedOptions = ExtendedRuntimeOptions.init(clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        clazz = this.getClass();
        try {
            runPredefinedMethods(BeforeSuite.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        super.tearDownClass();
        try {
            runPredefinedMethods(AfterSuite.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (ExtendedRuntimeOptions extendedOption : extendedOptions) {
            ReportRunner.run(extendedOption);
        }
    }

    @Override
    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        try {
            super.feature(cucumberFeature);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
