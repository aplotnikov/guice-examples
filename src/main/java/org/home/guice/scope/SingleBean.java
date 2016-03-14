package org.home.guice.scope;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class SingleBean {
    @Inject
    public SingleBean() {}
}
