package ide.eclipse.druid;



import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DruidUtil {

    private static DataSource ds;

    static {
        //���������ļ��ͽ������ӳ�
        try {
            Properties pro = new Properties();
            InputStream resourceAsStream = DruidUtil.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(resourceAsStream);
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * ��ȡ���ݿ����ӳ�
     * @return
     */
    public static DataSource getDataSource(){
        return ds;
    }


    /**
     * ��ȡ���ӳ��е�һ������
     * @return
     * @throws SQLException
     */
    public Connection getconnection() throws SQLException {
        return ds.getConnection();

    }


    /**
     * �ر����ݿ����Դ  �������󶼴���ʱ
     * @param conn
     * @param res
     * @param pstmt
     */
    public static void close(Connection conn, ResultSet res, PreparedStatement pstmt){
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (res!=null){
            try {
                res.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt!=null){
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * �ر����ݿ�����ӣ�ֻ����Connection��PreparedStatement����ʱ��
     * @param conn
     * @param pstmt
     */
    public void close(Connection conn,PreparedStatement pstmt){
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt!=null){
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}