package io.github.shreyanshp.cucumber.runner;

import org.junit.Ignore;
import org.junit.Test;

public class CLIRunnerTest {

    @Ignore
    @Test
    public void testRunCommand() throws Throwable {
        CLIRunner.main(new String[] {"--help"});
    }
}
