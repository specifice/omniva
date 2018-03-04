package omniva.assignment.invoice.repository;

import omniva.assignment.invoice.model.Invoice;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, String> {
  @Query("SELECT paid FROM Invoice WHERE id = :id")
  Boolean findPaidStatus(@Param("id") String id);
}
