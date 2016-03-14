package org.home.guice;

import com.google.inject.Inject;
import nl.pvanassen.guicejunitrunner.GuiceJUnitRunner;
import nl.pvanassen.guicejunitrunner.GuiceModules;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(GuiceJUnitRunner.class)
@GuiceModules(ApplicationModule.class)
public class BindingTest {
    @Inject
    private Integer myConstant;

    @Test
    public void shouldConstantBeTenAccordingToValueInGuiceModule() {
        assertThat(myConstant).isEqualTo(10);
    }
}
