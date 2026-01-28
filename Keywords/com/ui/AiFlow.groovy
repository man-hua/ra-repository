package com.ui

import com.common.Context
import com.common.WebElementFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

class AiFlow {

    void submitPrompt(String prompt) {
        def el = Context.get(WebElementFactory)
        WebUI.setText(el.css('#prompt'), prompt)
        WebUI.click(el.css('#submit'))
    }

    String readResponse() {
        def el = Context.get(WebElementFactory)
        return WebUI.getText(el.css('#response'))
    }
}
