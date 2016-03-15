package org.home.guice.aop;

public class AopAppliedBean {
    public void print() {
        System.out.println("Printed message from " + AopAppliedBean.class.getName());
    }
}
