## This is a very simple example spring boot project with implementation of circuit breaker pattern
<br>

## Dependencies used:
-circutbreaker resilense4j(order-service)<br>
-spring boot starter actuator(order-service)<br>
-spring boot starter data jpa<br>
-spring boot starter data web<br>
-h2 database<br>
-lombok<br>
<br>
## Some version specificated:
-Spring boot 3.2.4<br>
-Java 17<br>
-Maven (compile tool)<br>
<br>

### *How works?*
The address-service handle a collections data of address (code, state and city) this data is charged to 
H2 Dastabase locally through the setupData() method, marked with the $\color{#FFFF00}{@PostConstructor}$ anotation
and these data are retrieved of (address-service) through of call to endpoint (using restTemplate) from order-service
finally in the purchase simulation, the order-service will accessed by the customer when send in the endpoint call the postal code.
<br>
<br>
### *How test the circuit breaker implementation?*
You can access to "http://localhost:9091/actuator/health" and in this point you should can view the circuit breaker status (in order-service)
the circuit breker status "UP" and the service status will be "CLOSED" (order-service) this case is when both services is running normally (ideal scenario), 
but when the address-service failed or this service is down, these values will change to "UNKNOWN" and "OPEN" respectively
this behavior will because the circuit breaker is active and after some second (values configurated in application.yml file 
of service where circuit breaker pattern was configured) in our case these service is order-service .
All time while our order-service will be down or not responding correctly the circuit breaker status will be "HALF_OPEN"
(this means that the called to address-services works apparently fine, but behind the scene our fallback method implemented as a option to 
circuit breaker will be working and responding our data, and in this point you will knows because both object of response implemented the same interface "type" _is basically becausse give a strong type_)
finally when the addres-services will be restablished and works fine (previous pushed to api) the values of circuit breaker in the /actuator/health
endpoint changes once again to "UP" status.
