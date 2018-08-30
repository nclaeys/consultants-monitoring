POST to change the log level for package at runtime:
http://localhost:8080/actuator/loggers/be.axxes.consultants
Body:
{
	"configuredLevel":"DEBUG"
}

 curl -v -X POST http://localhost:8080/actuator/loggers/be.axxes.consultants -H "Content-Type: application/json" -d '{"configuredLevel":"DEBUG"}'
 curl -v -X GET http://localhost:8080/actuator/loggers

Change data service:
curl -v -X GET http://localhost:8080/consultants
curl -v -X POST http://localhost:8080/consultants -H "Content-Type: application/json" -d '{ "firstName":"d", "lastName":"claeys", "department":"JAVA"}'

