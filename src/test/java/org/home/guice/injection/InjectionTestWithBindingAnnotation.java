package org.home.guice.injection;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class InjectionTestWithBindingAnnotation {
    @Bind
    @Mock
    public InjectedBean injectedBean;
    @Inject private ConstructorInjectionBean constructorInjectionBean;

    @Before
    public void setUp() throws Exception {
        Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
    }

    @Test
    public void shouldMockedBeanBeInjectedThroughConstructor() {
        assertThat(constructorInjectionBean.injectedBean).isSameAs(injectedBean);
    }
}
