package main.atrachel.DAO;

import main.atrachel.DTO.CriteriaZone;
import main.atrachel.DTO.Zone;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by hd48552 on 2018/5/9.
 * ZoneDao的子类，提供操作zone数据的特定方法
 */
public class ZoneDaoImpl extends ZoneDao {

    public List<Zone> queryMany(CriteriaZone criteriaZone) throws SQLException {
        String sql = "select * from `zone` where id like ? and zone_name like ? and zone_area like ?";
        List<Zone> ll = queryMany(sql,criteriaZone.getId(),criteriaZone.getZoneName(),criteriaZone.getZoneArea());
        return  ll;

    }

    public List<Zone> queryMany() throws SQLException {
        String sql = "select * from `zone` where id like ? and zone_name like ? and zone_area like ?";
        List<Zone> ll = queryMany(sql,10);
        return  ll;

    }


    public void update() throws SQLException {
        String sql = "UPDATE `zone` SET zone_area =  ?  WHERE id = ?";
        update(sql,003,10);
    }

    public void update(CriteriaZone criteriaZone) throws SQLException {
        System.out.println("delete");
        String sql = "delete from `zone` where id = ? and zone_name=? and zone_area = ?";
        update(sql,criteriaZone.getId(),criteriaZone.getZoneName(),criteriaZone.getZoneArea());
    }

    public void update(CriteriaZone criteriaZone,CriteriaZone criteriaZonenew) throws SQLException {
        System.out.println("update");
        String sql = "UPDATE `zone` SET zone_name =  ? ,  zone_area =  ?  WHERE id = ?";
        System.out.println(sql);
        System.out.println(criteriaZone.getZoneName()+criteriaZone.getZoneArea()+criteriaZonenew.getId());
        update(sql,criteriaZonenew.getZoneName(),criteriaZonenew.getZoneArea(),criteriaZone.getId());
    }

    public void update(CriteriaZone criteriaZone,String ss) throws SQLException {
        System.out.println("add");
        String sql = " INSERT INTO `zone` (id,zone_name,zone_area) VALUES (?,?,?);";
        System.out.println(sql);
        System.out.println(criteriaZone.getZoneName()+criteriaZone.getZoneArea()+criteriaZone.getId());
        update(sql,criteriaZone.getId(),criteriaZone.getZoneName(),criteriaZone.getZoneArea());
    }
}
