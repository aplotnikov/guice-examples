package org.home.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.google.inject.name.Names;
import org.home.guice.instance.provider.ProviderMethodBean;
import org.home.guice.instance.customannotation.AnnotationNamedBeanImplementation;
import org.home.guice.instance.customannotation.AnnotationNamedBeanInterface;
import org.home.guice.instance.customannotation.MyNamedAnnotation;
import org.home.guice.instance.factory.GuiceFactory;
import org.home.guice.instance.named.AnotherNamedBean;
import org.home.guice.instance.named.NamedBeanInterface;
import org.home.guice.instance.named.SingleNamedBean;

public class ApplicationModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(NamedBeanInterface.class).annotatedWith(Names.named("myNamedBean")).to(SingleNamedBean.class);
        bind(AnnotationNamedBeanInterface.class).annotatedWith(MyNamedAnnotation.class).to(AnnotationNamedBeanImplementation.class);
        bind(NamedBeanInterface.class).to(AnotherNamedBean.class).in(Singleton.class);

        install(new FactoryModuleBuilder().build(GuiceFactory.class));
    }

    @Provides
    public ProviderMethodBean myProvidedMethodBean() {
        return new ProviderMethodBean();
    }
}
