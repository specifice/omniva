package omniva.assignment.invoice.controller;

import org.cassandraunit.spring.CassandraDataSet;
import org.cassandraunit.spring.CassandraUnit;
import org.cassandraunit.spring.CassandraUnitDependencyInjectionTestExecutionListener;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
@TestExecutionListeners({ CassandraUnitDependencyInjectionTestExecutionListener.class, DependencyInjectionTestExecutionListener.class })
@CassandraDataSet(value = { "dataset.cql" })
@CassandraUnit
public class InvoiceControllerIntegrationTest {
  @Autowired
  private MockMvc mockMvc;

  @Test
  public void shouldReturnTrueIfInvoicePaid() throws Exception {
    mockMvc.perform(get("/invoice/2029999099090/paid")
      .contentType(MediaType.APPLICATION_JSON_VALUE)
    )
      .andExpect(status().isOk())
      .andExpect(content().string("true"));
  }

  @Test
  public void shouldReturnFalseIfInvoiceUnpaid() throws Exception {
    mockMvc.perform(get("/invoice/2029999099091/paid")
      .contentType(MediaType.APPLICATION_JSON_VALUE)
    )
      .andExpect(status().isOk())
      .andExpect(content().string("false"));
  }

  @Test
  public void shouldReturnNotFoundIfInvoiceNotFound() throws Exception {
    mockMvc.perform(get("/invoice/2029999099092/paid")
      .contentType(MediaType.APPLICATION_JSON_VALUE)
    )
      .andExpect(status().isNotFound());
  }
}
