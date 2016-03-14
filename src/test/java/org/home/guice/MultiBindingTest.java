package org.home.guice;

import com.google.inject.Inject;
import nl.pvanassen.guicejunitrunner.GuiceJUnitRunner;
import nl.pvanassen.guicejunitrunner.GuiceModules;
import org.home.guice.multibinding.MultiBindingImplementation1;
import org.home.guice.multibinding.MultiBindingImplementation2;
import org.home.guice.multibinding.MultiBindingInterface;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(GuiceJUnitRunner.class)
@GuiceModules(ApplicationModule.class)
public class MultiBindingTest {
    @Inject
    private Set<MultiBindingInterface> multiBindingInterfaces;
    @Inject
    private MultiBindingImplementation1 multiBindingImplementation1;
    @Inject
    private MultiBindingImplementation2 multiBindingImplementation2;

    @Test
    public void shouldMultiBoundClassesBeInjected() {
        assertThat(multiBindingInterfaces).hasSize(2)
                                          .contains(multiBindingImplementation1, multiBindingImplementation2);

    }
}
