package duil;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class c3p0 {

@Test
    public void a() throws PropertyVetoException, SQLException {
      //创建连接池及技术
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
    //设置基本参数
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/boot?serverTimezone=Asia/Shanghai");
        dataSource.setUser("root");
        dataSource.setPassword("12345678");
        //连接池参数
        dataSource.setInitialPoolSize(10);//初始化连接数
        dataSource.setAcquireIncrement(2);//每次增量
        dataSource.setMaxPoolSize(10);
        dataSource.setMinPoolSize(4);
        dataSource.setMaxIdleTime(2000);
        //获取一个链接
    Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();

    }
}


