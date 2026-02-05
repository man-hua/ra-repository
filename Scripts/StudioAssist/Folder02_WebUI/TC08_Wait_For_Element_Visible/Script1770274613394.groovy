import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.util.KeywordUtil

String url = 'https://katalon-demo-cura.herokuapp.com/'

KeywordUtil.logInfo('Step 1: Open browser and navigate')
WebUI.openBrowser('')
WebUI.navigateToUrl(url)

KeywordUtil.logInfo('Step 2: Wait for Make Appointment visible')
TestObject btn = new TestObject('btnMakeAppointment')
btn.addProperty('xpath', ConditionType.EQUALS, "//a[@id='btn-make-appointment']")
WebUI.waitForElementVisible(btn, 10)

KeywordUtil.logInfo('Step 3: Close browser')
WebUI.closeBrowser()
