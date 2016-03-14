package org.home.guice.injection;

import com.google.inject.Inject;

public class ConstructorInjectionBean {
    public final InjectedBean injectedBean;

    @Inject
    public ConstructorInjectionBean(InjectedBean injectedBean) {
        this.injectedBean = injectedBean;
    }
}
