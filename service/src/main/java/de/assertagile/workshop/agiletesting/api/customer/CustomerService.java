package de.assertagile.workshop.agiletesting.api.customer;

import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Inject
    public CustomerService(final CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return new ArrayList<Customer>();
    }

    public Optional<Customer> getCustomerById(String customerId) {
        return Optional.ofNullable(Customer.fromEntity(customerRepository.findOne(customerId)));
    }

    public Customer saveCustomer(final Customer customer) {
        return Customer.fromEntity(customerRepository.save(customer.toEntity()));
    }
}
