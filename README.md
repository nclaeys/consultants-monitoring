# LOGGING
POST to change the log level for package at runtime:
`http://localhost:8080/actuator/loggers/be.axxes.pmt`

`curl -v -X POST http://localhost:8080/actuator/loggers/be.axxes.pmt -H "Content-Type: application/json" -d '{"configuredLevel":"DEBUG"}'`

`curl -v -X GET http://localhost:8080/actuator/loggers`

Change data service:
`curl -v -X GET http://localhost:8080/checkin`

`curl -v -X POST http://localhost:8080/checkin -H "Content-Type: application/json" -d '{ "user":"someone@axxes.com", "content":"All is well", "year":2018, "quarter":1}'`

# Application metrics

## start prometheus
Local prometheus running (easier to access the local application)
Use prometheus.yml in prometheus config directory.
`bin/prometheus --config.file=prometheus.yml`

Start grafana
`docker run -d --name=grafana -p 3000:3000 grafana/grafana`

Import dashboard through json file provided in root of the project

# User behavior
Look at the freemarker code to investigate which usage of the UI is being monitored.
All calls are logged to mixpanel on my personal account.
