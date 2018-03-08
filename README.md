# Basic Vertx with event bus example

(Requires Docker to be installed and running)

## Build
 - Build jars: `mvn clean package`
 - Build Docker images: `docker build -t server -f ServerDockerfile . && docker build -t generator -f GeneratorDockerfile . && docker build -t reciever -f RecieverDockerfile .`

## Run
`docker-compose up -d`

This will bring all 3 containers up. Navigating to `<docker machine ip>:8080/bus` on a browser will show messages streaming from the event bus over a websocket.

There are also some basic api examples on `/api/<whatever>` (will return an response back using the url parameter) and `/stuff`

(`docker-compose down` will stop and remove the containers)