import java.net.UnknownHostException;

public class MainGenerator {

    public static void main(String[] args) throws UnknownHostException {
        Clustered.setupCluster(vertx -> {
            vertx.deployVerticle(new MessageGenerator());
        }, 8081);
    }

}
