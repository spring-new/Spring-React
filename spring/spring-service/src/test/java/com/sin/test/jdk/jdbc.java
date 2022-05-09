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
    // ����main������ʵ�ֳ�����Ҫ�߼�
    public static void main(String[] args) {
        List<Emp> emps = testQuery();
        for (Emp emp : emps) {
            System.out.println(emp);
        }
    }
    public static List<Emp> testQuery(){
        Connection connection = null;
        // Statement statement = null; ֱ��ʹ��Statementִ�в�ѯ�������⵽SQLע�빥��,�Ƽ�ʹ��PreparedStatement
        PreparedStatement preparedstatement = null;
        PreparedStatement statement=null ;
        ResultSet resultSet = null;
        List<Emp> emps = null;

        try {
            // ����ע������
            Class.forName(driver);

            //2.������� Connection
            connection = DriverManager.getConnection(url, user, password);

            // 3.׼��SQL��䲢ִ��
            /*
             * 1ʹ��PreparedStatement�������ֹSQLע�빥��
             * 2PreparedStatement ����ʹ�� ? ��Ϊ������ռλ��
             * 3ʹ��?��Ϊռλ��,��ʹ���ַ�������������,Ҳ��ʹ�õ�������� ''
             * 4connection.createStatement();��õ�����ͨ������ Statement
             * 5connection.prepareStatement(sql);���Ի��һ��Ԥ����������PreparedStatement
             * 6���SQL�������?��Ϊ����ռλ����,��ôҪ��ִ��CURD֮ǰ�����ò���
             * 7ͨ��set***(�ʺŵı��,����) �������ò���
             * */
            String sql = "select * from emp";
            preparedstatement = connection.prepareStatement(sql);
            emps= (List<Emp>) preparedstatement.executeQuery(sql);
           // ResultSet emps=  preparedstatement.executeQuery();// ���ﲻ��Ҫ�ٴ���SQL���

            // �������SQLע��Ļ�Ҳ����ֱ��ʹ��statement.executeQuery(sql)��ѯ���,��������
            /*
            // 3.��ȡ������

            // 4.ִ�����

            String sql = "select * from emp";
            resultSet = statement.executeQuery(sql);
             */

            // 4.��ȡ������Խ�����б�����װ


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            // 5.�ر���Դ
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