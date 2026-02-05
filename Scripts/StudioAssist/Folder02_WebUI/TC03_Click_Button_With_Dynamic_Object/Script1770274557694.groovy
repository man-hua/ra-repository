import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.util.KeywordUtil

String url = 'https://katalon-demo-cura.herokuapp.com/'

KeywordUtil.logInfo('Step 1: Open browser and navigate')
WebUI.openBrowser('')
WebUI.navigateToUrl(url)

KeywordUtil.logInfo('Step 2: Click Make Appointment')
TestObject btn = new TestObject('btnMakeAppointment')
btn.addProperty('id', ConditionType.EQUALS, 'btn-make-appointment')
WebUI.click(btn)

KeywordUtil.logInfo('Step 3: Verify login form displayed')
TestObject username = new TestObject('txtUsername')
username.addProperty('id', ConditionType.EQUALS, 'txt-username')
WebUI.verifyElementPresent(username, 10)

KeywordUtil.logInfo('Step 4: Close browser')
WebUI.closeBrowser()
