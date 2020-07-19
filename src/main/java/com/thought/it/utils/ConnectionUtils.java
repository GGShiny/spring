package com.thought.it.utils;

import javafx.scene.chart.PieChart;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author 李亮
 * @date: 2020/7/18
 * @description:
 */
public class ConnectionUtils {
    ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取当前线程上的连接
     * @return
     */
    public Connection getThreadConnection(){
        try {
            // 先从ThreadLocal上获取
            Connection connection = tl.get();
            // 判断当前线程上是否有连接
            if (connection == null) {
                // 从数据源中获取一个连接放入ThreadLocal中
                connection = dataSource.getConnection();
                tl.set(connection);
            }
            // 返回当前线程中的连接
            return connection;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }


    /**
     * 把线程和连接解绑
     */
    public void removeConnection(){
        tl.remove();
    }
}
