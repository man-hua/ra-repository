package ra.common.error

import org.openqa.selenium.Cookie
import org.openqa.selenium.WebDriver

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory

public class TestDataIssue {
	WebDriver driver = DriverFactory.getWebDriver()

	@Keyword
	void causeInvalidCookieDomainException() {
		Cookie invalidDomainCookie = new Cookie.Builder('testCookie', 'testValue')
				.domain('invalid-domain.com')
				.build()
		driver.manage().addCookie(invalidDomainCookie)
	}

	@Keyword
	void causeInvalidTestData() {
		def jsonData = [
			"type": "Json"
		]

		assert jsonData == intText
	}

	@Keyword
	void causeDataMismatch() {
		def jsonData = [
			"glossary": [
				"title": "example glossary",
				"GlossDiv": [
					"title": "S"
				]
			]
		]

		def expectedJsonData =  [
			"glossary": [
				"title": "title",
				"GlossDiv": [
					"title": "S"
				]
			]
		]

		assert jsonData == expectedJsonData
	}

	@Keyword
	void causeMissingTestData() {
		def jsonData =  [
			"glossary": [
				"title": "example glossary",
				"GlossDiv": [
					"title": "S"
				]
			]
		]

		def expectedJsonData =  [
			"glossary": [
				"GlossDiv": [
					"title": "S"
				]
			]
		]

		assert jsonData == expectedJsonData
	}

	@Keyword
	void causeDataFormatIssue() {
		def jsonData = [
			"type": "Json"
		]

		def intText = 1

		assert jsonData == intText
	}

	@Keyword
	void causeCaseSensitivityIssue() {
		assert "Dashboard Overview" == "dashboard overview"
	}
}
