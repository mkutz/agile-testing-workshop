package de.assertagile.workshop.agiletesting.test.service

import de.assertagile.workshop.agiletesting.Application
import de.assertagile.workshop.agiletesting.CustomerRvo
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.boot.test.WebIntegrationTest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ContextConfiguration
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader)
@WebIntegrationTest(randomPort = true)
@DirtiesContext
class CustomerServiceSpec extends Specification {

    @Value('http://localhost:${local.server.port}')
    String serviceUrl

    RestTemplate rest = new RestTemplate();

    def "GETing all customers should return an empty list"() {
        when:
        ResponseEntity<List<CustomerRvo>> response = rest.getForEntity("${serviceUrl}/customer/", List)

        then:
        response.statusCode == HttpStatus.OK

        and:
        response.body == []
    }
}
