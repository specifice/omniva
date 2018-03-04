package omniva.assignment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
  private static final Logger LOG = LoggerFactory.getLogger(Application.class);

  @Autowired
  public void logConfiguration(@Value("${spring.data.cassandra.contactpoints}") String contactpoints, @Value("${spring.data.cassandra.port}") int port) {
    LOG.info("Cassandra connection [hosts: {}, port: {}]", contactpoints, port);
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
