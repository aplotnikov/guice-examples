package org.home.guice.instance;

import com.google.inject.Inject;
import nl.pvanassen.guicejunitrunner.GuiceJUnitRunner;
import nl.pvanassen.guicejunitrunner.GuiceModules;
import org.home.guice.ApplicationModule;
import org.home.guice.instance.customannotation.AnnotationNamedBeanImplementation;
import org.home.guice.instance.customannotation.AnnotationNamedBeanInterface;
import org.home.guice.instance.customannotation.MyNamedAnnotation;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(GuiceJUnitRunner.class)
@GuiceModules(ApplicationModule.class)
public class CustomAnnotationTest {
    @Inject
    @MyNamedAnnotation
    private AnnotationNamedBeanInterface annotationNamedBeanInterface;

    @Test
    public void shouldBeanBeInjectedByNamedAnnotation() {
        assertThat(annotationNamedBeanInterface).isNotNull()
                                                .isInstanceOf(AnnotationNamedBeanImplementation.class);
    }
}
