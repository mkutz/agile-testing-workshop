package de.assertagile.workshop.agiletesting.test.actors

import de.assertagile.workshop.agiletesting.test.pages.GoogleStartPage
import geb.Browser

class GoogleUserActor {

    @Delegate
    final Browser browser

    public GoogleUserActor(final Browser browser) {
        this.browser = browser
    }

    public void searchFor(String query) {
        GoogleStartPage page = browser.at(GoogleStartPage)
        page.searchInput.text = query
    }

    public void doAllSuggestionsBeginWith(final String inputText) {
        GoogleStartPage page = browser.at(GoogleStartPage)
        assert page.searchSuggestions.findAll { it.inputText != inputText }.empty
    }
}