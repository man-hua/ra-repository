import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// Verify page title
WebUI.openBrowser('')
WebUI.navigateToUrl('https://www.example.com')
WebUI.verifyMatch(WebUI.getWindowTitle(), 'Example Domain', false)
WebUI.closeBrowser()