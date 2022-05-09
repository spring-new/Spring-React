package com.sin.test.jdk;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.ConnectionPoolDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBSUtl {
    private static DruidDataSource dds;
    //��̬�����
    static{
        dds = new DruidDataSource();
        //��ȡurl
        dds.setUrl("jdbc:mysql://localhost:3306/supermarket_sys?useUnicode=true&characterEncoding=utf-8");
        //��ȡ�û���
        dds.setUsername("root");
        //��ȡ����
        dds.setPassword("root");
    }
    public static ConnectionPoolDataSource getDBDS(){
        //����dds
        return dds;
    }
    public static Connection getConn(){
        try {
            return dds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



}