package org.home.guice.aop;

import com.google.inject.matcher.Matcher;

public class AopAppliedBeanClassMatcher implements Matcher<Class<?>> {
    @Override
    public boolean matches(Class<?> aClass) {
        return AopAppliedBean.class.equals(aClass);
    }

    @Override
    public Matcher<Class<?>> and(Matcher<? super Class<?>> other) {
        return null;
    }

    @Override
    public Matcher<Class<?>> or(Matcher<? super Class<?>> other) {
        return null;
    }
}
