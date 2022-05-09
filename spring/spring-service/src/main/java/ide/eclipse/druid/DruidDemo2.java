package ide.eclipse.druid;



import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DruidDemo2 {
    public static void main(String[] args) throws SQLException {
        DataSource ds = DruidUtil.getDataSource();
        Connection connection = ds.getConnection();
        String sql = "select * from goods";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Integer id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String value = resultSet.getString("value");
            System.out.println(id+" "+name+" "+value);
        }
        DruidUtil.close(connection,resultSet,preparedStatement);
    }
}