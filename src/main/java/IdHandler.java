import io.vertx.core.Handler;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;

public class IdHandler implements Handler<RoutingContext> {

    @Override
    public void handle(RoutingContext context) {

        String id = context.request().getParam("id");

        Datas datas = new Datas();
        datas.setId(id);
        datas.setName("Bob");
        datas.setValue("Phteven");

        JsonObject response = new JsonObject();
        response.put("data", JsonObject.mapFrom(datas));

        context.response().putHeader("content-type", "application/json")
                .setStatusCode(200)
                .end(Json.encodePrettily(response));
    }

    private class Datas {

        private String name;

        public String getName() {
            return this.name;
        }

        public void setName(String value) {
            this.name = value;
        }

        private String value;

        public String getValue() {
            return this.value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        private String id;

        public String getId() {
            return this.id;
        }

        public void setId(String value) {
            this.id = value;
        }
    }
}
