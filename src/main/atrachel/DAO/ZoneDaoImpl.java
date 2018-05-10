package main.atrachel.DAO;

import main.atrachel.DTO.Zone;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by hd48552 on 2018/5/9.
 */
public class ZoneDaoImpl extends ZoneDao {


    public List<Zone> queryMany() throws SQLException {
        String sql = "select * from `zone` where id < ?";
        List<Zone> ll = queryMany(sql,10);
        return  ll;

    }


    public void update() throws SQLException {
        String sql = "UPDATE `zone` SET zone_area =  ?  WHERE id = ?";
        update(sql,003,10);
    }
}
