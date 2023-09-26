package duil;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JdbcUtils {
    private static DataSource dataSource = new ComboPooledDataSource();

    //获取连接池
    public static DataSource getDataSource() {
        return dataSource;
    }

    //获取连接
    public static Connection getConn() throws SQLException {
        return dataSource.getConnection();
    }

  public static void main(String[] args) throws SQLException {
        System.out.println(getConn());
    }
}
