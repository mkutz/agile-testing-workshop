package de.assertagile.workshop.agiletesting.test.pages

import geb.Page

class GoogleStartPage extends Page {

    static url = "http://www.google.com"

    static at = { $("#hplogo") }

    static content = {
        // TODO
    }
}