package omniva.assignment.invoice.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import omniva.assignment.invoice.service.InvoiceService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
  @Resource
  private InvoiceService invoiceService;

  @ApiOperation("Checks if invoice with given id is paid")
  @GetMapping(value = "/{invoiceId}/paid", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public boolean isInvoicePaid(@ApiParam(value = "Invoice identifier", defaultValue = "2029999099090") @PathVariable String invoiceId) {
    return invoiceService.isInvoicePaid(invoiceId);
  }
}
