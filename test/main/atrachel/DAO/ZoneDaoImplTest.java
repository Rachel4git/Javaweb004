package main.atrachel.DAO;

import main.atrachel.DTO.Zone;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by hd48552 on 2018/5/10.
 */
public class ZoneDaoImplTest extends ZoneDao {
    @Test
    public void queryMany() throws Exception {
        List<Zone> ls = new ZoneDaoImpl().queryMany();
        for(Zone z:ls){
            System.out.println(z);
        }

    }

    @Test
    public void update() throws  Exception{
        new ZoneDaoImpl().update();;
    }

}