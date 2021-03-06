package main.atrachel.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by hd48552 on 2018/5/9.
 */

/**
 * dao接口，提供数据库操作的一般方法
 * @param <T>
 */
public interface Dao<T> {

//  query
    public T queryOne(String sql,Object ... args) throws SQLException;

    public List<T> queryMany(String sql,Object ... args) throws SQLException;

//  update
    public  void update(String sql,Object ... args) throws SQLException;


}
