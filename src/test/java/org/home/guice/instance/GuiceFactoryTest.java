package org.home.guice.instance;

import com.google.inject.Inject;
import nl.pvanassen.guicejunitrunner.GuiceJUnitRunner;
import nl.pvanassen.guicejunitrunner.GuiceModules;
import org.home.guice.ApplicationModule;
import org.home.guice.instance.factory.FactoryBean;
import org.home.guice.instance.factory.GuiceFactory;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(GuiceJUnitRunner.class)
@GuiceModules(ApplicationModule.class)
public class GuiceFactoryTest {
    @Inject private GuiceFactory guiceFactory;

    @Test
    public void shouldBeanBeCreatedByFactory() {
        String name = "my name";

        FactoryBean factoryBean = guiceFactory.newFactoryBeanInstance(name);

        assertThat(factoryBean.name).isEqualTo(name);
        assertThat(factoryBean.anyInjectedBean).isNotNull();
    }
}
