import io.vertx.core.Handler;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.MessageConsumer;
import io.vertx.core.http.ServerWebSocket;
import io.vertx.core.json.JsonObject;

public class WebSocketHandler implements Handler<ServerWebSocket> {

    EventBus bus;

    public WebSocketHandler(EventBus bus)  {
        this.bus = bus;
    }

    @Override
    public void handle(ServerWebSocket socket) {
        System.out.println("Websocket Open");
        MessageConsumer<Object> consumer = bus.consumer("awesome-messages", m -> {
            JsonObject message = (JsonObject)m.body();
            socket.writeTextMessage(message.encodePrettily());
        });
        socket.closeHandler(e -> consumer.unregister());
    }
}
