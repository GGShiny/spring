package com.thought.it.proxy;

/**
 * @author 李亮
 * @date: 2020/7/19
 * @description: 对生产厂家要求的接口
 */
public interface IProducer {
    /**
     * 销售
     * @param money
     */
    public void saleProduct(float money);

    /**
     * 售后服务
     * @param money
     */
    public void afterService(float money);
}
