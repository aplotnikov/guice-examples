package org.home.guice.aop;

import com.google.inject.matcher.Matcher;

import java.lang.reflect.Method;

public class PrintMethodMatcher implements Matcher<Method> {
    @Override
    public boolean matches(Method method) {
        return "print".equals(method.getName());
    }

    @Override
    public Matcher<Method> and(Matcher<? super Method> other) {
        return null;
    }

    @Override
    public Matcher<Method> or(Matcher<? super Method> other) {
        return null;
    }
}
