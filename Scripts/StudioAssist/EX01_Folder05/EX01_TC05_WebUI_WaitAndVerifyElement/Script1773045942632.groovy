import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject

WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl('https://katalon-demo-cura.herokuapp.com/')
WebUI.waitForPageLoad(30)

TestObject btn = new TestObject('makeAppt')
btn.addProperty('css', com.kms.katalon.core.testobject.ConditionType.EQUALS, '#btn-make-appointment')

WebUI.waitForElementVisible(btn, 10)
WebUI.verifyElementClickable(btn, FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()