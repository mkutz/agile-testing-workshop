package de.assertagile.workshop.agiletesting.test.pages

import geb.Page
import geb.module.TextInput

class GoogleStartPage extends Page {

    static url = "http://www.google.com"

    static at = { $("#hplogo") }

    static content = {
        searchInput { $("#lst-ib").module(TextInput) }
        searchSuggestions(wait: true) { $("ul.sbsb_b") }
    }
}