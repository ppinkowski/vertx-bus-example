import io.vertx.core.*;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Clustered {

    public static void setupCluster(Handler<Vertx> onCompleted, int port) throws UnknownHostException {
        String host = InetAddress.getLocalHost().getHostAddress();

        Vertx.clusteredVertx(new VertxOptions().setClustered(true).setClusterHost(host).setClusterPort(port), res -> {
            if (res.succeeded()) {
                System.out.println("Clustered event bus configured!");
                onCompleted.handle(res.result());
            } else {
                System.out.println("Failed to configure cluster: " + res.cause());
            }
        });
    }

}
