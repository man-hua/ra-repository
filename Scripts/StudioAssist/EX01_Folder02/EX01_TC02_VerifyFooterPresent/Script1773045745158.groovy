import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject

WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl('https://katalon-demo-cura.herokuapp.com/')
WebUI.waitForPageLoad(30)

TestObject footer = new TestObject('footer')
footer.addProperty('css', com.kms.katalon.core.testobject.ConditionType.EQUALS, 'footer')
WebUI.verifyElementVisible(footer, FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()