package org.home.guice.instance.provider;

import com.google.inject.Provider;

public class MyClassProvider implements Provider<ProvidedClass> {
    @Override
    public ProvidedClass get() {
        return new ProvidedClass();
    }
}
