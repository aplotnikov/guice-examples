package org.home.guice;

import com.google.inject.Inject;
import nl.pvanassen.guicejunitrunner.GuiceJUnitRunner;
import nl.pvanassen.guicejunitrunner.GuiceModules;
import org.home.guice.aop.AopAppliedBean;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(GuiceJUnitRunner.class)
@GuiceModules(ApplicationModule.class)
public class AopTest {
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    @Inject
    private AopAppliedBean aopAppliedBean;

    @Test
    public void shouldMessagesBeforeAndAfterExecutingMethodBePrinted() {
        aopAppliedBean.print();

        assertThat(
                systemOutRule.getLog()
        ).isEqualTo(
                "Did it before method invocation\nPrinted message from org.home.guice.aop.AopAppliedBean\nDid it after method invocation\n"
        );
    }
}
