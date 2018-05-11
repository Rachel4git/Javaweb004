package main.atrachel.DAO;

import main.atrachel.DTO.Zone;
import main.atrachel.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hd48552 on 2018/5/9.
 */

/**
 * 操作zone数据的数据库操作类
 */
public class ZoneDao  implements Dao<Zone>{
    QueryRunner queryRunner = new QueryRunner();
    private Class<Zone> clazz;
    @Override
    public Zone queryOne(String sql, Object... args) throws SQLException {
        return null;
    }

    @Override
    public List<Zone> queryMany(String sql, Object... args) throws SQLException {

        Connection conn = null;
        List<Zone> ll = new ArrayList<>();
        JdbcUtils utils = new JdbcUtils();
        conn= utils.creatConnect();
        ll = queryRunner.query(conn,sql,new BeanListHandler<>(Zone.class),args);
        utils.releaseConnect(conn);
        return  ll;
    }

    @Override
    public void update( String sql, Object... args) throws SQLException {
        Connection conn = null;
        JdbcUtils utils = new JdbcUtils();
        conn= utils.creatConnect();
        queryRunner.update(conn,sql,args);
        utils.releaseConnect(conn);

    }
}
