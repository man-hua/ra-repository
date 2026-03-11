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

WebUI.setText(username, 'John Doe')
WebUI.setEncryptedText(password, 'g3/DOGG74jY=') // 'ThisIsNotAPassword' is dummy; change if needed
WebUI.click(btnLogin)

WebUI.waitForPageLoad(30)
WebUI.verifyTextPresent('Make Appointment', false, FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()