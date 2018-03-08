import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;

import java.util.Date;

public class MessageGenerator extends AbstractVerticle {

    @Override
    public void start() throws Exception {

        EventBus bus = vertx.eventBus();

        vertx.setPeriodic(1000, id -> {
            bus.publish("awesome-messages", new JsonObject().put("data", "Have a message!!").put("time", new Date().toString()));
        });
    }
}
