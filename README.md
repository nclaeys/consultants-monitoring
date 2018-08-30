# LOGGING
POST to change the log level for package at runtime:
`http://localhost:8080/actuator/loggers/be.axxes.consultants`

`curl -v -X POST http://localhost:8080/actuator/loggers/be.axxes.consultants -H "Content-Type: application/json" -d '{"configuredLevel":"DEBUG"}'`

`curl -v -X GET http://localhost:8080/actuator/loggers`

Change data service:
`curl -v -X GET http://localhost:8080/consultants`

`curl -v -X POST http://localhost:8080/consultants -H "Content-Type: application/json" -d '{ "firstName":"d", "lastName":"claeys", "department":"JAVA"}'`

# Application metrics

## start prometheus
Local prometheus running (easier to access the local application)

Start grafana
`docker run -d --name=grafana -p 3000:3000 grafana/grafana`

Import dashboard through json file provided in root of the project

