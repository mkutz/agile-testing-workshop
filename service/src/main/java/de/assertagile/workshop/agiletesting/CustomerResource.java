package de.assertagile.workshop.agiletesting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.inject.Inject;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class CustomerResource {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final CustomerService customerService;

    @Inject
    public CustomerResource(final CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(method = GET, path = "/customer", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CustomerRvo>> getAllCustomers() {
        log.debug("Git request for all customers.");
        return ResponseEntity.ok().body(
                customerService.getAllCustomers().stream().map(Customer::toRvo)
                        .collect(Collectors.toList()));
    }

    @RequestMapping(method = GET, path = "/customer/{customerId}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerRvo> getCustomer(@PathVariable("customerId") final String customerId) {
        log.info("Got request for id '{}'.", customerId);
        Customer customer = customerService.getCustomerById(customerId).orElseThrow(CustomerNotFoundException::new);
        return ResponseEntity.ok().body(customer.toRvo());
    }

    @RequestMapping(method = POST, path = "/customer/", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> getCustomer(@RequestBody CustomerRvo customerRvo) {
        Customer customer = customerService.saveCustomer(Customer.fromRvo(customerRvo));
        return ResponseEntity.created(getCustomerLocation(customer)).body(null);
    }

    private URI getCustomerLocation(Customer customer) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(customer.getId()).toUri();
    }
}
