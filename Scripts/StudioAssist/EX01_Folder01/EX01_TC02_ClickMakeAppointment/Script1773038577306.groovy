import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import com.kms.katalon.core.testobject.TestObject

WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl('https://katalon-demo-cura.herokuapp.com/')
WebUI.waitForPageLoad(30)

TestObject btnMakeAppointment = new TestObject('btnMakeAppointment')
btnMakeAppointment.addProperty('css', com.kms.katalon.core.testobject.ConditionType.EQUALS, '#btn-make-appointment')

WebUI.click(btnMakeAppointment)
WebUI.waitForPageLoad(30)
WebUI.verifyTextPresent('Login', false, FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()