package org.home.guice.instance;

import com.google.inject.Inject;
import nl.pvanassen.guicejunitrunner.GuiceJUnitRunner;
import nl.pvanassen.guicejunitrunner.GuiceModules;
import org.home.guice.ApplicationModule;
import org.home.guice.instance.provider.ProviderMethodBean;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(GuiceJUnitRunner.class)
@GuiceModules(ApplicationModule.class)
public class ProviderMethodTest {
    @Inject private ProviderMethodBean providerMethodBean;

    @Test
    public void shouldBeanBeCreatedThroughMethodProvider() {
        assertThat(providerMethodBean).isNotNull();
    }
}
