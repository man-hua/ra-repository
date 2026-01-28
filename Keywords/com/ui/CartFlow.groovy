package com.ui

import com.common.Context
import com.common.WebElementFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

class CartFlow {

    void addToCart() {
        def el = Context.get(WebElementFactory)
        WebUI.click(el.css('a.btn-success'))
        WebUI.acceptAlert()
    }

    void openCart() {
        def el = Context.get(WebElementFactory)
        WebUI.click(el.css('#cartur'))
    }
}
