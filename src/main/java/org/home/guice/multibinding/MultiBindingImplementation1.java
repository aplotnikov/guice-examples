package org.home.guice.multibinding;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class MultiBindingImplementation1 implements MultiBindingInterface {
    @Inject
    public MultiBindingImplementation1() {}
}
