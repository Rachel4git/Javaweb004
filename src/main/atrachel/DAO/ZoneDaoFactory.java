package main.atrachel.DAO;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hd48552 on 2018/5/9.
 */
public class ZoneDaoFactory {

    private   static  ZoneDaoFactory instance = new ZoneDaoFactory();

    public  static  ZoneDaoFactory getInstance(){
        return  instance;
    }

    private Map<String,ZoneDao> zoneDaoMap = new HashMap<String,ZoneDao>();

    private  ZoneDaoFactory(){
        zoneDaoMap.put("zonedao1",new ZoneDaoImpl());
    }

    private  String key=null;

    public  void setKey(String key){
        this.key=key;
    }
    public ZoneDao getZoneDao(){
        return zoneDaoMap.get(key);
    }
}
