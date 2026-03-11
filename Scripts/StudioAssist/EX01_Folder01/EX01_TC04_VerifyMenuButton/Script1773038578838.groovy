import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject

WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl('https://katalon-demo-cura.herokuapp.com/')
WebUI.waitForPageLoad(30)

TestObject menuBtn = new TestObject('menuBtn')
menuBtn.addProperty('css', com.kms.katalon.core.testobject.ConditionType.EQUALS, '#menu-toggle')

WebUI.verifyElementPresent(menuBtn, 10, FailureHandling.STOP_ON_FAILURE)
WebUI.closeBrowser()