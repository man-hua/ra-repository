package com.ui

import static com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.sendKeys

import org.openqa.selenium.Keys

import com.common.Context
import com.common.WebElementFactory
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

class ContentFlow {

	void searchArticle(String keyword) {
		def el = Context.get(WebElementFactory)
		WebUI.setText(el.css('input[name="search"]'), keyword)
		WebUI.sendKeys(el.css('input[name="search"]'), Keys.chord(Keys.ENTER))
	}

	boolean isArticleDisplayed(String title) {
		def el = Context.get(WebElementFactory)
		return WebUI.verifyTextPresent(
				title,
				false,
				FailureHandling.OPTIONAL
				)
	}
}
