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

TestObject username = new TestObject('username')
username.addProperty('css', com.kms.katalon.core.testobject.ConditionType.EQUALS, '#txt-username')
TestObject password = new TestObject('password')
password.addProperty('css', com.kms.katalon.core.testobject.ConditionType.EQUALS, '#txt-password')
TestObject btnLogin = new TestObject('btnLogin')
btnLogin.addProperty('css', com.kms.katalon.core.testobject.ConditionType.EQUALS, '#btn-login')

WebUI.setText(username, 'invalid')
WebUI.setText(password, 'invalid')
WebUI.click(btnLogin)

TestObject error = new TestObject('error')
error.addProperty('css', com.kms.katalon.core.testobject.ConditionType.EQUALS, '.text-danger')
WebUI.verifyElementVisible(error, FailureHandling.STOP_ON_FAILURE)
WebUI.verifyTextPresent('Login failed', false, FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()