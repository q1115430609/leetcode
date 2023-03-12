package com.ssx.study.newTrait;

public class InterfaceDemo implements InterfaceOne,InterfaceTwo {
    /**
     * 由于 method1 是 InterfaceOne 接口里的抽象方法，因此必须实现
     */
    @Override
    public void method1() {
    }

    /**
     * 由于 InterfaceOne InterfaceTwo 都有一个 default 方法 method2，因此也必须重新实现
     */
    @Override
    public void method2() {
        InterfaceOne.super.method2();
    }

    public static void main(String[] args) {
        InterfaceDemo demo = new InterfaceDemo();
        demo.method4();
        InterfaceOne.method3();
    }
}
