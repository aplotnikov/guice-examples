package org.home.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.home.guice.scope.PerRequestBean;
import org.home.guice.scope.SingleBean;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ScopeTest {
    private Injector injector;

    @Before
    public void setUp() throws Exception {
        injector = Guice.createInjector(new ApplicationModule());
    }

    @Test
    public void shouldNewBeanBeCreatedAfterEveryCallOfGettingNewInstanceOfObject() {
        PerRequestBean firstInstance = injector.getInstance(PerRequestBean.class);
        PerRequestBean secondInstance = injector.getInstance(PerRequestBean.class);

        assertThat(firstInstance).isNotSameAs(secondInstance);
    }

    @Test
    public void shouldSingleBeanBeCreatedAfterEveryCallOfGettingNewInstanceOfObject() {
        SingleBean firstInstance = injector.getInstance(SingleBean.class);
        SingleBean secondInstance = injector.getInstance(SingleBean.class);

        assertThat(firstInstance).isSameAs(secondInstance);
    }
}