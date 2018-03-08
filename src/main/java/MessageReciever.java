import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;

public class MessageReciever extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        EventBus bus = vertx.eventBus();

        bus.consumer("awesome-messages", message -> {
            System.out.println("Recieved Message: " + message.body());
        });
    }
}
