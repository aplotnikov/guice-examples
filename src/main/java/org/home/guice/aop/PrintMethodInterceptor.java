package org.home.guice.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class PrintMethodInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("Did it before method invocation");

        Object returnedValue = methodInvocation.proceed();

        System.out.println("Did it after method invocation");

        return returnedValue;
    }
}
