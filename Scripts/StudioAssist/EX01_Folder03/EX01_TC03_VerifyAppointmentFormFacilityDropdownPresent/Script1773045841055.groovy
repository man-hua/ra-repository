import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject

WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl('https://katalon-demo-cura.herokuapp.com/')
WebUI.waitForPageLoad(30)

// Go to login
TestObject btnMakeAppointment = new TestObject('btnMakeAppointment')
btnMakeAppointment.addProperty('css', com.kms.katalon.core.testobject.ConditionType.EQUALS, '#btn-make-appointment')
WebUI.click(btnMakeAppointment)

// (No login performed) just verify username field is present as prerequisite
TestObject username = new TestObject('username')
username.addProperty('css', com.kms.katalon.core.testobject.ConditionType.EQUALS, '#txt-username')
WebUI.verifyElementPresent(username, 10, FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()