package com.ssx.study.newTrait;

public interface InterfaceOne {
    /**
     * 实现类必须要实现的方法
     */
    void method1();

    /**
     * 接口方法，子类可以选择实现也可以选择不实现
     */
    default void method2() {
        System.out.println("this is InterfaceOne#method2");
    }

    /**
     * 静态方法，子类无需实现
     */
    static void method3() {
        System.out.println("this is InterfaceOne#method3");
    }
}