import io.vertx.core.Handler;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class StuffHandler implements Handler<RoutingContext> {

    @Override
    public void handle(RoutingContext context) {

        List<JsonObject> response = IntStream
            .range(1, 10)
            .mapToObj(i -> new JsonObject()
                .put("data", new JsonObject()
                    .put("key", i)
                    .put("value", "value " + i)))
            .collect(toList());

        context.response().putHeader("content-type", "application/json")
                .setStatusCode(200)
                .end(Json.encodePrettily(response));
    }
}
