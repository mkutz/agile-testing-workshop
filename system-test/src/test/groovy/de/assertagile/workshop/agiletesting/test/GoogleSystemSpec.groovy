package de.assertagile.workshop.agiletesting.test

import de.assertagile.workshop.agiletesting.test.actors.GoogleUserActor
import de.assertagile.workshop.agiletesting.test.pages.GoogleStartPage
import geb.spock.GebReportingSpec

class GoogleSystemSpec extends GebReportingSpec {

    final GoogleUserActor user = new GoogleUserActor(browser)

    def "searching should work"() {
        expect:
        user.to(GoogleStartPage)
    }
}