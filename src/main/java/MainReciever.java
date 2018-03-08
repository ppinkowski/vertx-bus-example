import java.net.UnknownHostException;

public class MainReciever {

    public static void main(String[] args) throws UnknownHostException {
        Clustered.setupCluster(vertx -> {
            vertx.deployVerticle(new MessageReciever());
        }, 8082);
    }

}
