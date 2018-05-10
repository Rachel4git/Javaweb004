package main.atrachel.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by hd48552 on 2018/5/9.
 */
public class JdbcUtils {
//    创建连接
//    数据源只加载一次，使用静态
    private static ComboPooledDataSource comboPooledDataSource = null;

    static {
        comboPooledDataSource = new ComboPooledDataSource("mvcapp");
    }

    public Connection creatConnect(){
        Connection conn =null;

        comboPooledDataSource.setUser("TCFlyIntIe");
        comboPooledDataSource.setPassword("ZnD7aJCFm9FvktrsY6RZ");
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://10.100.157.78:3500/TCFlyIntIe");
        comboPooledDataSource.setInitialPoolSize(5);
        comboPooledDataSource.setMinPoolSize(5);
        comboPooledDataSource.setMaxPoolSize(10);

        try {
            comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
            conn = comboPooledDataSource.getConnection();
//            System.out.println(conn);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return  conn;
    }


//    释放连接

    public  void  releaseConnect(Connection conn) {


        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

