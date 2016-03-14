package org.home.guice.instance;

import com.google.inject.Inject;
import nl.pvanassen.guicejunitrunner.GuiceJUnitRunner;
import nl.pvanassen.guicejunitrunner.GuiceModules;
import org.home.guice.ApplicationModule;
import org.home.guice.instance.named.AnotherNamedBean;
import org.home.guice.instance.named.NamedBeanInterface;
import org.home.guice.instance.named.SingleNamedBean;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Named;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(GuiceJUnitRunner.class)
@GuiceModules(ApplicationModule.class)
public class NamedAnnotationTest {
    @Inject
    @Named("myNamedBean")
    private NamedBeanInterface namedBeanInterfaceWithNamedAnnotation;
    @Inject
    private NamedBeanInterface namedBeanInterface;

    @Test
    public void shouldBeanBeInjectedByName() {
        assertThat(namedBeanInterfaceWithNamedAnnotation).isNotSameAs(namedBeanInterface);

        assertThat(namedBeanInterfaceWithNamedAnnotation).isInstanceOf(SingleNamedBean.class);
        assertThat(namedBeanInterface).isInstanceOf(AnotherNamedBean.class);
    }
}
