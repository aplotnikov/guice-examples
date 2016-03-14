package org.home.guice;

import com.google.inject.Inject;
import nl.pvanassen.guicejunitrunner.GuiceJUnitRunner;
import nl.pvanassen.guicejunitrunner.GuiceModules;
import org.home.guice.instance.ProviderMethodBean;
import org.home.guice.instance.customannotation.AnnotationNamedBeanImplementation;
import org.home.guice.instance.customannotation.AnnotationNamedBeanInterface;
import org.home.guice.instance.customannotation.MyNamedAnnotation;
import org.home.guice.instance.factory.FactoryBean;
import org.home.guice.instance.factory.GuiceFactory;
import org.home.guice.instance.named.AnotherNamedBean;
import org.home.guice.instance.named.NamedBeanInterface;
import org.home.guice.instance.named.SingleNamedBean;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Named;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(GuiceJUnitRunner.class)
@GuiceModules(ApplicationModule.class)
public class InstanceTest {
    @Inject private ProviderMethodBean providerMethodBean;
    @Inject
    @Named("myNamedBean")
    private NamedBeanInterface namedBeanInterfaceWithNamedAnnotation;
    @Inject
    private NamedBeanInterface namedBeanInterface;
    @Inject
    @MyNamedAnnotation
    private AnnotationNamedBeanInterface annotationNamedBeanInterface;
    @Inject private GuiceFactory guiceFactory;

    @Test
    public void shouldBeanBeCreatedThroughMethodProvider() {
        assertThat(providerMethodBean).isNotNull();
    }

    @Test
    public void shouldBeanBeInjectedByName() {
        assertThat(namedBeanInterfaceWithNamedAnnotation).isNotSameAs(namedBeanInterface);

        assertThat(namedBeanInterfaceWithNamedAnnotation).isInstanceOf(SingleNamedBean.class);
        assertThat(namedBeanInterface).isInstanceOf(AnotherNamedBean.class);
    }

    @Test
    public void shouldBeanBeInjectedByNamedAnnotation() {
        assertThat(annotationNamedBeanInterface).isNotNull()
                                                .isInstanceOf(AnnotationNamedBeanImplementation.class);
    }

    @Test
    public void shouldBeanBeCreatedByFactory() {
        String name = "my name";

        FactoryBean factoryBean = guiceFactory.newFactoryBeanInstance(name);

        assertThat(factoryBean.name).isEqualTo(name);
        assertThat(factoryBean.anyInjectedBean).isNotNull();
    }
}
