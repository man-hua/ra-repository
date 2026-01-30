import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// Check element visible
WebUI.openBrowser('')
WebUI.navigateToUrl('https://www.example.com')
WebUI.verifyElementVisible(findTestObject('Page_Example/element1'), 10)
WebUI.closeBrowser()