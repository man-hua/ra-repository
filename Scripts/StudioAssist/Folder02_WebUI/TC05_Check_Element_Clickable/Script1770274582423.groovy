import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.util.KeywordUtil

String url = 'https://katalon-demo-cura.herokuapp.com/'

KeywordUtil.logInfo('Step 1: Open browser and navigate')
WebUI.openBrowser('')
WebUI.navigateToUrl(url)

KeywordUtil.logInfo('Step 2: Verify Make Appointment is clickable')
TestObject btn = new TestObject('btnMakeAppointment')
btn.addProperty('css', ConditionType.EQUALS, '#btn-make-appointment')
WebUI.verifyElementClickable(btn)

KeywordUtil.logInfo('Step 3: Close')
WebUI.closeBrowser()
