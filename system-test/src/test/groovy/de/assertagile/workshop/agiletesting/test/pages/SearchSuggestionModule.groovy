package de.assertagile.workshop.agiletesting.test.pages

import geb.Module

class SearchSuggestionModule extends Module {

    static content = {
        suggestionText { $(".sbqs_c").text() }
        supplementText { $(".sbqs_c b").text() }
    }

    public String getInputText() {
        return suggestionText - supplementText
    }

    public String toString() {
        return "${getClass().simpleName} at ${browser.currentUrl} with suggestion text \"${suggestionText}\""
    }
}