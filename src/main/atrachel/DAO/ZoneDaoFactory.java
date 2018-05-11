package main.atrachel.DAO;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hd48552 on 2018/5/9.
 * 工厂方法，内部封装一个存放ZoneDao对象的map，map中可存放ZoneDao的不同子类
 * 工厂对象为单例模式，可通过getinstance方法获取工厂对象
 * 通过getZoneDao方法，并传入特定的KEY，可获取特定的ZoneDao的子类
 */
public class ZoneDaoFactory {

    private   static  ZoneDaoFactory instance = new ZoneDaoFactory();

    public  static  ZoneDaoFactory getInstance(){
        return  instance;
    }

    private Map<String,ZoneDao> zoneDaoMap = new HashMap<String,ZoneDao>();

    private  ZoneDaoFactory(){
        zoneDaoMap.put("zonedaoimpl",new ZoneDaoImpl());
    }

    public ZoneDao getZoneDao(String key ){
        return zoneDaoMap.get(key);
    }
}
