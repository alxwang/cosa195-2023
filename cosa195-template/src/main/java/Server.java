import ServiceController.AirCraftServiceController;
import io.javalin.Javalin;
public class Server {
    public static void main(String[] args) {
        var app = Javalin.create(/*config*/)
                .get("/",
                        ctx -> ctx.result("Welcome to COSA 195 App Server."))
                .start(7070);
        app.get("/aircrafts",
                AirCraftServiceController.fetchAllAirCrafts);
    }
}
