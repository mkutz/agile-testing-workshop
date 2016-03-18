package de.assertagile.workshop.agiletesting.test.actors

import geb.Browser

class GoogleUserActor {

    @Delegate
    final Browser browser

    public GoogleUserActor(final Browser browser) {
        this.browser = browser
    }

    public void searchFor(String query) {
        // TODO
    }
}