import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.ext.web.Router;

public class HttpServer extends AbstractVerticle {

    @Override
    public void start(Future<Void> future) throws Exception {

        Router router = Router.router(vertx);

        router.get("/api/:id").handler(new IdHandler());
        router.get("/stuff").handler(new StuffHandler());
        router.get("/bus").handler(r -> r.response().sendFile("Messages.html"));

        vertx.createHttpServer()
                .requestHandler(router::accept)
                .websocketHandler(new WebSocketHandler(vertx.eventBus()))
                .listen(config().getInteger("http.port", 8080), result -> {
                    if (result.succeeded()) {
                        System.out.println("Listening on port 8080");
                        future.complete();
                    } else {
                        future.fail(result.cause());
                    }
                });
    }

    @Override
    public void stop() throws Exception {
        System.out.println("Stopping verticle my dude");
    }
}
