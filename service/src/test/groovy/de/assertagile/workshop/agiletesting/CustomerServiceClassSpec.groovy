package de.assertagile.workshop.agiletesting

import de.assertagile.workshop.agiletesting.api.customer.CustomerRepository
import de.assertagile.workshop.agiletesting.api.customer.CustomerService
import spock.lang.Specification
import spock.lang.Subject

class CustomerServiceClassSpec extends Specification {

    CustomerRepository customerRepositoryMock = Mock()

    @Subject
    CustomerService customerService = new CustomerService(customerRepositoryMock)

    def "should work"() {
    }
}
