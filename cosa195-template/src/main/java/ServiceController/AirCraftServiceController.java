package ServiceController;


import DataAccessObject.AirCraftDAO;
import DataObject.AirCraft;
import io.javalin.http.Handler;

import java.util.List;

public class AirCraftServiceController {

    public  static Handler fetchAllAirCrafts = ctx->{
        List<AirCraft> list = AirCraftDAO.getAllAirCrafts();
        ctx.json(list);
    };



}
