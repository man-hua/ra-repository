import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// Check element is clickable
WebUI.openBrowser('')
WebUI.navigateToUrl('https://www.example.com')
WebUI.verifyElementClickable(findTestObject('Page_Example/btn_Submit'), 10)
WebUI.closeBrowser()