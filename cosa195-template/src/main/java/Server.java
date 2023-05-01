import ServiceController.AirCraftServiceController;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class Server {
    public static void main(String[] args) {
        var app = Javalin.create(
                config->{
                    config.staticFiles.add("/htdocs", Location.CLASSPATH);
                }
                )
                .get("/",
                        ctx -> ctx.result("Welcome to COSA 195 App Server."))
                .start(7070);
        app.get("/aircrafts",
                AirCraftServiceController.fetchAllAirCrafts);
        app.get("/aircrafts/{country}",
                AirCraftServiceController.fetchAllAirCraftsinaCountryHandler);
        app.post("/aircrafts",AirCraftServiceController.postAirCraftpostAirCraft);
    }
}
