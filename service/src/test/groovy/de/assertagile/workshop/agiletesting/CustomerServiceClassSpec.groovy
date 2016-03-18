package de.assertagile.workshop.agiletesting

import de.assertagile.workshop.agiletesting.api.customer.Customer
import de.assertagile.workshop.agiletesting.api.customer.CustomerEntity
import de.assertagile.workshop.agiletesting.api.customer.CustomerRepository
import de.assertagile.workshop.agiletesting.api.customer.CustomerService
import spock.lang.Specification
import spock.lang.Subject

class CustomerServiceClassSpec extends Specification {

    CustomerRepository customerRepositoryMock = Mock()

    @Subject
    CustomerService customerService = new CustomerService(customerRepositoryMock)

    String someId = "some id"

    def "getCustomerById should return null in Optional if the id is unknown"() {
        given:
        customerRepositoryMock.findOne(someId) >> null

        when:
        Optional<Customer> customerOptional = customerService.getCustomerById(someId)

        then:
        !customerOptional.isPresent()
    }

    def "getCustomerById should return not null in Optional if the id is known"() {
        given:
        customerRepositoryMock.findOne(someId) >> Mock(CustomerEntity)

        when:
        Optional<Customer> customerOptional = customerService.getCustomerById(someId)

        then:
        customerOptional.isPresent()
    }
}
