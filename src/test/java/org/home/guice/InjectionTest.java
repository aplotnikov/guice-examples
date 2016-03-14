package org.home.guice;

import com.google.inject.Inject;
import nl.pvanassen.guicejunitrunner.GuiceJUnitRunner;
import nl.pvanassen.guicejunitrunner.GuiceModules;
import org.home.guice.injection.ConstructorInjectionBean;
import org.home.guice.injection.FieldInjectionBean;
import org.home.guice.injection.MethodInjectionBean;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(GuiceJUnitRunner.class)
@GuiceModules(ApplicationModule.class)
public class InjectionTest {
    @Inject private ConstructorInjectionBean constructorInjectionBean;
    @Inject private MethodInjectionBean methodInjectionBean;
    @Inject private FieldInjectionBean fieldInjectionBean;

    @Test
    public void shouldBeanBeInjectedThroughConstructorInjection() {
        assertThat(constructorInjectionBean.injectedBean).isNotNull();
    }

    @Test
    public void shouldBeanBeInjectedThroughMethodInjection() {
        assertThat(methodInjectionBean.injectedBean).isNotNull();
    }

    @Test
    public void shouldBeanBeInjectedThroughFieldInjection() {
        assertThat(fieldInjectionBean.injectedBean).isNotNull();
    }
}
