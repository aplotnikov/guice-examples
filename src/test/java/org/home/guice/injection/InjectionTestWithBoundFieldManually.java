package org.home.guice.injection;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class InjectionTestWithBoundFieldManually {
    @Mock public InjectedBean injectedBean;
    @Inject private ConstructorInjectionBean constructorInjectionBean;

    @Before
    public void setUp() throws Exception {
        Guice.createInjector(new TestGuiceModule()).injectMembers(this);
    }

    @Test
    public void shouldMockedBeanBeInjectedThroughConstructor() {
        assertThat(constructorInjectionBean.injectedBean).isSameAs(injectedBean);
    }

    private class TestGuiceModule extends AbstractModule {
        @Override
        protected void configure() {
            bind(InjectedBean.class).toInstance(injectedBean);
        }
    }
}
