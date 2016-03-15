package org.home.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.google.inject.multibindings.Multibinder;
import com.google.inject.name.Names;
import org.home.guice.aop.AopAppliedBeanClassMatcher;
import org.home.guice.aop.PrintMethodInterceptor;
import org.home.guice.aop.PrintMethodMatcher;
import org.home.guice.instance.customannotation.AnnotationNamedBeanImplementation;
import org.home.guice.instance.customannotation.AnnotationNamedBeanInterface;
import org.home.guice.instance.customannotation.MyNamedAnnotation;
import org.home.guice.instance.factory.GuiceFactory;
import org.home.guice.instance.named.AnotherNamedBean;
import org.home.guice.instance.named.NamedBeanInterface;
import org.home.guice.instance.named.SingleNamedBean;
import org.home.guice.instance.provider.ProviderMethodBean;
import org.home.guice.multibinding.MultiBindingImplementation1;
import org.home.guice.multibinding.MultiBindingImplementation2;
import org.home.guice.multibinding.MultiBindingInterface;

public class ApplicationModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(NamedBeanInterface.class).annotatedWith(Names.named("myNamedBean")).to(SingleNamedBean.class);
        bind(AnnotationNamedBeanInterface.class).annotatedWith(MyNamedAnnotation.class).to(AnnotationNamedBeanImplementation.class);
        bind(NamedBeanInterface.class).to(AnotherNamedBean.class).in(Singleton.class);

        install(new FactoryModuleBuilder().build(GuiceFactory.class));

        bind(Integer.class).toInstance(10);

        Multibinder<MultiBindingInterface> uriBinder = Multibinder.newSetBinder(binder(), MultiBindingInterface.class);
        uriBinder.addBinding().to(MultiBindingImplementation1.class);
        uriBinder.addBinding().to(MultiBindingImplementation2.class);

        bindInterceptor(
                new AopAppliedBeanClassMatcher(),
                new PrintMethodMatcher(),
                new PrintMethodInterceptor()
        );
    }

    @Provides
    public ProviderMethodBean myProvidedMethodBean() {
        return new ProviderMethodBean();
    }
}
