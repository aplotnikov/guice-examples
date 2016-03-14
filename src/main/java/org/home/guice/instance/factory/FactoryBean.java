package org.home.guice.instance.factory;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

public class FactoryBean {
    public final AnyInjectedBean anyInjectedBean;
    public final String name;

    @Inject
    public FactoryBean(AnyInjectedBean anyInjectedBean, @Assisted String name) {
        this.anyInjectedBean = anyInjectedBean;
        this.name = name;
    }
}
