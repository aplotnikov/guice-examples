package org.home.guice.multibinding;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class MultiBindingImplementation2 implements MultiBindingInterface {
    @Inject
    public MultiBindingImplementation2() {}
}
