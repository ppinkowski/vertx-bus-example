import io.vertx.core.Vertx;

import java.net.UnknownHostException;

public class MainServer {

    public static void main(String[] args) throws UnknownHostException {
        Clustered.setupCluster(vertx -> {
            vertx.deployVerticle(new HttpServer());
        }, 8083);
    }

}
