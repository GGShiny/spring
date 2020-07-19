package com.thought.it.proxy;

import com.sun.org.apache.bcel.internal.generic.DLOAD;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 李亮
 * @date: 2020/7/19
 * @description:
 */
public class Client {
    public static void main(String[] args) {
        final Producer producer = new Producer();

        /**
         * 动态代理：
         *  特点：字节码随用随创建，随用随加载
         *  作用：不同修改源码的基础对方法进行增强
         *  分类：
         *      基于接口的动态代理
         *      基于方法的动态代理
         *    基于接口的动态代理：
         *      涉及的类：Proxy
         *      提供者：JDK官方
         *    如何创建代理对象：
         *      使用Proxy类中的newProxyInstance方法
         *    创建代理对象的要求
         *      被代理类对少实现一个接口，如果没有则不能使用
         *    newProxyInstance方法参数：
         *      ClassLoad:类加载器
         *          它是使用于加载代理对象字节码的，和被代理对象使用相同的类加载器
         *      Class[]：字节码数据组
         *          它是用于让代理对象和被代理对象有相同的方法
         *      InvocationHandler：代码增强
         *          它是让我们写如何增强，一般都是写一个该接口的实现类，通常情况下都是匿名内部类，但是不是必须的。
         *          此接口的实现类都是谁用谁写
         *
         */
        IProducer iProducer = (IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(), producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 执行被代理对象的任何接口方法都会经过该方法
                     * @param proxy 代理对象的引用
                     * @param method 当前执行的方法
                     * @param args  当前执行方法所需的参数
                     * @return
                     * @throws Throwable
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 提供增强代码

                        Object returValue = null;
                        // 获取方法执行参数
                        Float money = (Float) args[0];

                        // 判断当前方法是不是销售
                        if ("saleProduct".equals(method.getName())){
                            returValue = method.invoke(producer, money * 0.8f);
                        }
                        return returValue;
                    }
                });
        iProducer.saleProduct(10000f);
    }
}
