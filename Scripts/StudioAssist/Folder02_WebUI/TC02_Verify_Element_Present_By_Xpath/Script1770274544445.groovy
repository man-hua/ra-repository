import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.util.KeywordUtil

String url = 'https://katalon-demo-cura.herokuapp.com/'

KeywordUtil.logInfo('Step 1: Open browser')
WebUI.openBrowser('')

KeywordUtil.logInfo('Step 2: Navigate')
WebUI.navigateToUrl(url)

KeywordUtil.logInfo('Step 3: Build TestObject and verify')
TestObject btnMakeAppointment = new TestObject('btnMakeAppointment')
btnMakeAppointment.addProperty('xpath', ConditionType.EQUALS, "//a[@id='btn-make-appointment']")
WebUI.verifyElementPresent(btnMakeAppointment, 10)

KeywordUtil.logInfo('Step 4: Close')
WebUI.closeBrowser()
