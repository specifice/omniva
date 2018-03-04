Omniva assignment
========================
### Decision points
- Cassandra as database
  - Assignment recommendation for in-memory database usage is interpreted primarily for standalone execution purposes
  - Cassandra 
    - supports embedded mode and matches standalone execution expectation
    - is highly efficient for read on large data sets
    - uses bloom filters internally
- Testing strategy
    - No dedicated unit tests written for effort saving purposes
    - Single integration test which covers all the functional cases written for regression and coverage purposes
- API documentation
    - Swagger <http://localhost:8080/swagger-ui.html>
- Frameworks
    - Lastest available versions of frameworks used
    - No bicycles reinvented
- DB structure
    - Minimalistic strusture with _"invoice"_ table identified by `text` PK and `boolean` _"paid"_ attribute
- API method
    - minimalistic REST-style method taking invoice ID as input path param and returning boolean application/json text result 

### Build
1. Requires JDK 1.8
1.
   ```
   gradlew build
   ```

### Run embedded
1. Run embedded database (defaults to 127.0.0.1:9042)
   ```
   gradlew runStandaloneEmbeddedCassandra
   ```
1. Run application as separate process
   ```
   cd build/lib
   java -jar assignment-1.0-SNAPSHOT.jar
   ```

### Run external
1. Execute `src/test/resources/dataset.cql` on your external Cassandra instance
1. In directory with _jar_ create file `application-<profile>.yml` with connection config:
   
   ```yaml
   spring.data.cassandra:
     contactpoints: <host1>[, host2,..., hostN]
     port: <port>
   ```
1. Run application with profile
   ```
      cd build/lib
      java -jar -Dspring.profiles.active=<profile> assignment-1.0-SNAPSHOT.jar
   ```

### Testing
1. Test via SwaggerUI <http://localhost:8080/swagger-ui.html>