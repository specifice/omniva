package omniva.assignment.invoice.model;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;

@Table("invoice")
@Data
public class Invoice implements Serializable {
  private static final long serialVersionUID = 1L;

  @PrimaryKey
  private String id;
  private boolean paid;
}
