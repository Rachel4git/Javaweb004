package main.atrachel.DTO;

/**
 * Created by hd48552 on 2018/5/9.
 */

public class Zone {
    private  Integer id;
    private  String zone_name;
    private  String zone_area;

    public void setId(Integer id ){
        this.id=id;
    }

    public Integer getId(){
        return  id;
    }


    public void setZone_name(String zoneName) {
        this.zone_name = zoneName;
    }
    public String getZoneName() {
        return zone_name;
    }
    public void setZone_area(String zoneArea) {
        this.zone_area = zoneArea;
    }
    public String getZoneArea() {
        return zone_area;
    }




    public  Zone(){
        //todo
    }

    public  Zone(Integer id,String zoneName,String zoneArea){
        this.id=id;
        this.zone_name=zoneName;
        this.zone_area=zoneArea;
    }

    @Override
    public  String toString(){
        return  ("id = "+id+" zoneName = "+zone_name+" zoneArea = "+zone_area);
    }
}
