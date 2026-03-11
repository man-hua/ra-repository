import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling

WebUI.openBrowser('')
WebUI.maximizeWindow()

WebUI.navigateToUrl('https://katalon-demo-cura.herokuapp.com/')
WebUI.waitForPageLoad(30)

WebUI.verifyTextPresent('CURA Healthcare Service', false, FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()