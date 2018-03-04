package omniva.assignment;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import org.cassandraunit.CQLDataLoader;
import org.cassandraunit.dataset.cql.ClassPathCQLDataSet;
import org.cassandraunit.utils.EmbeddedCassandraServerHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StandaloneEmbeddedCassandraRunner {
  private static final Logger LOG = LoggerFactory.getLogger(StandaloneEmbeddedCassandraRunner.class);

  public static void main(String[] args) throws Exception {
    LOG.info("Starting embedded cassandra server...");
    EmbeddedCassandraServerHelper.startEmbeddedCassandra("standalone-cassandra.yaml",  "target/standaloneEmbeddedCassandra",60000);
    Cluster cluster = Cluster.builder().addContactPoints(EmbeddedCassandraServerHelper.getHost())
      .withPort(EmbeddedCassandraServerHelper.getNativeTransportPort()).build();
    Session session = cluster.connect();
    CQLDataLoader dataLoader = new CQLDataLoader(session);
    dataLoader.load(new ClassPathCQLDataSet("dataset.cql"));
    session.close();
    cluster.close();
    LOG.info("Embedded cassandra is ready");
  }
}
