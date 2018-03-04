CREATE KEYSPACE IF NOT EXISTS assignment WITH REPLICATION = {  'class' : 'SimpleStrategy', 'replication_factor' : 1  };

CREATE TABLE IF NOT EXISTS assignment.invoice(
  id text PRIMARY KEY,
  paid boolean
);

INSERT INTO assignment.invoice(id, paid) VALUES ('2029999099090', true) IF NOT EXISTS;
INSERT INTO assignment.invoice(id, paid) VALUES ('2029999099091', false) IF NOT EXISTS;
