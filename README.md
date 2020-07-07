# Run a provider
mvn clean install\
mvn spring-boot:run

# Call provider api
curl -H "Accept: application/json" -H "Content-type: application/json" \
-X POST -d '{"eventName":"event1", "eventData":"this is event1 data"}' http://localhost:8200/api/event/
