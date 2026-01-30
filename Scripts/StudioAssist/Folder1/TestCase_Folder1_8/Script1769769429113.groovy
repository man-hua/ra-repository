import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// Verify element attribute
WebUI.openBrowser('')
WebUI.navigateToUrl('https://www.example.com')
String attr = WebUI.getAttribute(findTestObject('Page_Example/element1'), 'class')
WebUI.verifyMatch(attr, 'expected-class', false)
WebUI.closeBrowser()