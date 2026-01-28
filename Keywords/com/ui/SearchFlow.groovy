package com.ui

import org.openqa.selenium.Keys

import com.common.Context
import com.common.WebElementFactory
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

class SearchFlow {

    void search(String keyword) {
        def el = Context.get(WebElementFactory)
        WebUI.setText(el.css('input[name="q"]'), keyword)
        WebUI.sendKeys(el.css('input[name="q"]'), Keys.chord(Keys.ENTER))
    }

    boolean hasResults() {
        def el = Context.get(WebElementFactory)
        return WebUI.verifyElementPresent(
            el.css('#search'),
            10,
            FailureHandling.OPTIONAL
        )
    }
}
