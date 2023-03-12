package com.ssx.study.newTrait;

public interface InterfaceTwo {
    /**
     * 接口方法，子类可以选择实现也可以选择不实现
     */
    default void method2() {
        System.out.println("this is InterfaceTwo#method2");
    }

    /**
     * 接口方法，子类可以选择实现也可以选择不实现
     */
    default void method3() {
        System.out.println("this is InterfaceTwo#method3");
    }

    default void method4() {
        System.out.println("this is InterfaceTwo#method4");
    }
}
