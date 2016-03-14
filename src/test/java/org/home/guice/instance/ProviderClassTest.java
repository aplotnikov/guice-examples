package org.home.guice.instance;

import com.google.inject.Inject;
import com.google.inject.Provider;
import nl.pvanassen.guicejunitrunner.GuiceJUnitRunner;
import nl.pvanassen.guicejunitrunner.GuiceModules;
import org.home.guice.ApplicationModule;
import org.home.guice.instance.provider.MyClassProvider;
import org.home.guice.instance.provider.ProvidedClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(GuiceJUnitRunner.class)
@GuiceModules(ApplicationModule.class)
public class ProviderClassTest {
    @Inject
    private MyClassProvider myClassProvider;
    @Inject
    private Provider<ProvidedClass> providedClassProvider;

    @Test
    public void shouldNewInstanceOfProvidedClassBeCreatedThroughProviderClass() {
        assertThat(providedClassProvider.get()).isNotNull();
        assertThat(
                providedClassProvider.get()
        ).isNotSameAs(
                providedClassProvider.get()
        );
    }

    @Test
    public void shouldNewInstanceOfProvidedClassBeCreatedThroughCustomProviderClass() {
        assertThat(myClassProvider.get()).isNotNull();
        assertThat(
                myClassProvider.get()
        ).isNotSameAs(
                myClassProvider.get()
        );
    }
}
