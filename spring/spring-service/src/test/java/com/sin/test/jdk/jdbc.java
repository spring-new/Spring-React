package com.sin.test.jdk;



import ide.eclipse.entity.Emp;

import java.sql.*;
import java.util.List;

/**
 * @author: shanlei
 * @version: 1.0
 */
public class jdbc {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://127.0.0.1/test??useUnicode=true&characterEncoding=utf-8&useSSL=false";
    private static String user = "root", password = "root";
    // 这是main方法，实现程序主要逻辑
    public static void main(String[] args) {
        List<Emp> emps = testQuery();
        for (Emp emp : emps) {
            System.out.println(emp);
        }
    }
    public static List<Emp> testQuery(){
        Connection connection = null;
        // Statement statement = null; 直接使用Statement执行查询语句可能遭到SQL注入攻击,推荐使用PreparedStatement
        PreparedStatement preparedstatement = null;
        PreparedStatement statement=null ;
        ResultSet resultSet = null;
        List<Emp> emps = null;

        try {
            // 加载注册驱动
            Class.forName(driver);

            //2.获得链接 Connection
            connection = DriverManager.getConnection(url, user, password);

            // 3.准备SQL语句并执行
            /*
             * 1使用PreparedStatement语句对象防止SQL注入攻击
             * 2PreparedStatement 可以使用 ? 作为参数的占位符
             * 3使用?作为占位符,即使是字符串和日期类型,也不使用单独再添加 ''
             * 4connection.createStatement();获得的是普通语句对象 Statement
             * 5connection.prepareStatement(sql);可以获得一个预编译语句对象PreparedStatement
             * 6如果SQL语句中有?作为参数占位符号,那么要在执行CURD之前先设置参数
             * 7通过set***(问号的编号,数据) 方法设置参数
             * */
            String sql = "select * from emp";
            preparedstatement = connection.prepareStatement(sql);
            emps= (List<Emp>) preparedstatement.executeQuery(sql);
           // ResultSet emps=  preparedstatement.executeQuery();// 这里不需要再传入SQL语句

            // 如果不怕SQL注入的话也可以直接使用statement.executeQuery(sql)查询语句,代码如下
            /*
            // 3.获取语句对象

            // 4.执行语句

            String sql = "select * from emp";
            resultSet = statement.executeQuery(sql);
             */

            // 4.获取结果并对结果进行遍历封装


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            // 5.关闭资源
            if(null != resultSet){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(null != preparedstatement){
                try {
                    preparedstatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(null != connection){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return emps;
    }
}