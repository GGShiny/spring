package com.thought.it.cglib;

/**
 * @author 李亮
 * @date: 2020/7/19
 * @description: 生产厂家
 */
public class Producer {

    /**
     * 销售
     * @param money
     */
    public void saleProduct(float money){
        System.out.println("销售产品并拿到钱：" + money);
    }

    /**
     * 售后服务
     * @param money
     */
    public void afterService(float money){
        System.out.println("提供售后服务并拿到钱：" + money);
    }
}
