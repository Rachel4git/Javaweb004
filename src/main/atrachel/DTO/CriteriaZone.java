package main.atrachel.DTO;

/**
 * Created by hd48552 on 2018/5/11.
 */

/**
 * 用于封装请求参数的实体类，可实现请求参数的模糊查询
 */
public class CriteriaZone {
    private  String   id;
    private  String zone_name;
    private  String zone_area;
    private  Integer type;

    public void setId(String id ){
        this.id=id;
    }

    public String getId(){
        if(type == 0)
            return id;
        else
           return get(id) ;

    }


    public void setZone_name(String zoneName) {
        this.zone_name = zoneName;
    }
    public String getZoneName() {
        if(type == 0)
            return zone_name;
        else
            return get(zone_name) ;
    }
    public void setZone_area(String zoneArea) {
        this.zone_area = zoneArea;
    }
    public String getZoneArea() {
        if(type == 0)
            return zone_area;
        else
            return get(zone_area) ;

    }




    public  CriteriaZone(){
        //todo
    }

    public  CriteriaZone(String id,String zoneName,String zoneArea,Integer type){
        this.id=id;
        this.zone_name=zoneName;
        this.zone_area=zoneArea;
        this.type = type;
    }

    @Override
    public  String toString(){
        return  ("id = "+id+" zoneName = "+zone_name+" zoneArea = "+zone_area);
    }

    public String get(String ss){
        if(ss == null)
            ss = "%%";
        else
            ss = "%"+ ss +"%";
        return ss;
    }

}
