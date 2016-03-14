package org.home.guice.injection;

import com.google.inject.Inject;

public class MethodInjectionBean {
    public InjectedBean injectedBean;

    @Inject
    public void injectBean(InjectedBean injectedBean) {
        this.injectedBean = injectedBean;
    }
}
