package omniva.assignment.invoice.service;

import omniva.assignment.common.EntityNotFoundException;
import omniva.assignment.invoice.model.Invoice;
import omniva.assignment.invoice.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class InvoiceService {
  @Resource
  private InvoiceRepository invoiceRepository;

  public boolean isInvoicePaid(String invoiceId) {
    Boolean isPaid = invoiceRepository.findPaidStatus(invoiceId);
    if (isPaid != null) {
      return isPaid;
    }
    throw new EntityNotFoundException(Invoice.class, invoiceId);
  }
}
