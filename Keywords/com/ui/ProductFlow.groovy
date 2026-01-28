package com.ui

import com.common.Context
import com.common.WebElementFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

class ProductFlow {

    void openProduct(String productName) {
        def el = Context.get(WebElementFactory)
        WebUI.click(el.xpath("//a[text()='${productName}']"))
    }
}
