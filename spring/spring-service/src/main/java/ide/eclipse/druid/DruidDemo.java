package ide.eclipse.druid;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;

public class DruidDemo {
    public static void main(String[] args) {
        //1.导入jar包
        //2.定义配置文件
        //3.加载配置文件
        long systime0 = System.currentTimeMillis();//当前系统时间

        Properties pro = new Properties();
        InputStream resourceAsStream = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            pro.load(resourceAsStream);
            DataSource ds = DruidDataSourceFactory.createDataSource(pro);
            connection = ds.getConnection();
            String sql = "Select * from goods";

            Date date1 = new Date();    // 调用无参数构造函数
            long systime = System.currentTimeMillis();//当前系统时间
            preparedStatement = connection.prepareStatement(sql);
            long systime2 = System.currentTimeMillis();//当前系统时间
            long timeCha=systime2-systime;
            System.out.println("timeCha1: "+timeCha);
            Date date2 = new Date();

            resultSet = preparedStatement.executeQuery();

            System.out.println(date1);
            System.out.println(date2);
            while (resultSet.next()){
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String value = resultSet.getString("value");
                System.out.println(id+" "+name+" "+value);
            }
            long systime3 = System.currentTimeMillis();//当前系统时间

            long timeCha2=systime3-systime0;

            System.out.println("timeCha12: "+timeCha2);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

    }

}