package com.thought.it.cglib;

import com.thought.it.proxy.IProducer;
import com.thought.it.proxy.Producer;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

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
        final com.thought.it.proxy.Producer producer = new Producer();

        /**
         * 动态代理：
         *  特点：字节码随用随创建，随用随加载
         *  作用：不同修改源码的基础对方法进行增强
         *  分类：
         *      基于接口的动态代理
         *      基于方法的动态代理
         *    基于接口的动态代理：
         *      涉及的类：EnHancer
         *      提供者：第三方cglib库
         *    如何创建代理对象：
         *      使用EnHancer类中的create方法
         *    创建代理对象的要求
         *      被代理类不能是最终类
         *    create的参数：
         *      Class:字节码
         *          它是用于指定被代理对象的字节码
         *      callback：代码增强
         *          它是让我们写如何增强，一般都是写一个该接口的实现类，通常情况下都是匿名内部类，但是不是必须的。
         *          此接口的实现类都是谁用谁写
         *          一般写的都是该接口的子接口实现类：MethodInterceptor
         *
         */
        Producer cglibProducer = (Producer)Enhancer.create(Producer.class, new MethodInterceptor() {
            /**
             * 执行任何被代理对象的任何方法都经过该方法
             * @param proxy
             * @param method
             * @param args
             * 以上三个参数和基于接口动态代理中invoke方法的参数是一样的
             * @param methodProxy 当前执行方法的代理对象
             * @return
             * @throws Throwable
             */
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                // 提供增强代码

                Object returnValue = null;
                // 获取该方法的执行参数
                Float money = (Float) args[0];
                //判断当前方法是不是销售
                if ("saleProduct".equals(method.getName())) {
                    returnValue = method.invoke(producer, money * 0.8f);
                }
                return returnValue;
            }

        });
        cglibProducer.saleProduct(12000f);
    }
}
