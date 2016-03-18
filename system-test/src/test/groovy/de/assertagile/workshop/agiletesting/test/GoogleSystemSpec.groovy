package de.assertagile.workshop.agiletesting.test

import de.assertagile.workshop.agiletesting.test.actors.GoogleUserActor
import de.assertagile.workshop.agiletesting.test.pages.GoogleStartPage
import geb.spock.GebReportingSpec

class GoogleSystemSpec extends GebReportingSpec {

    final GoogleUserActor user = new GoogleUserActor(browser)

    def "typing a single letter should make suggestions appear"() {
        given:
        GoogleStartPage page = user.to(GoogleStartPage)

        when:
        page.searchInput.text = "a"

        then:
        page.searchSuggestions.displayed
    }
}