package ServiceController;


import DataAccessObject.AirCraftDAO;
import DataObject.AirCraft;
import io.javalin.http.Handler;

import java.util.List;
import java.util.Objects;

public class AirCraftServiceController {

    public  static Handler fetchAllAirCrafts = ctx->{
        List<AirCraft> list = AirCraftDAO.getAllAirCrafts();
        ctx.json(list);
    };

    public static Handler fetchAllAirCraftsinaCountryHandler= ctx->{
        String country = Objects.requireNonNull(ctx.pathParam("country"));
        System.out.println(country);
        List<AirCraft> list = AirCraftDAO.getAllAirCrafts(country);
        ctx.json(list);
    };


    public  static  Handler postAirCraftpostAirCraft  = ctx->{
        AirCraft airCraft = ctx.bodyAsClass(AirCraft.class);
        AirCraftDAO.addAirCraft(airCraft);
    };




}
