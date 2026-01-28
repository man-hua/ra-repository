package com.ui

import com.common.Context
import com.common.WebElementFactory
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

class AuthFlow {

	void login(String user, String pass) {
		def el = Context.get(WebElementFactory)
		WebUI.setText(el.css('#username'), user)
		WebUI.setText(el.css('#password'), pass)
		WebUI.click(el.css('button[type="submit"]'))
	}

	void logout() {
		def el = Context.get(WebElementFactory)
		WebUI.click(el.css('.icon-signout'))
	}

	boolean isLoginSuccess() {
		def el = Context.get(WebElementFactory)
		return WebUI.verifyElementPresent(
				el.css('.flash.success'),
				5,
				FailureHandling.OPTIONAL
				)
	}
}
