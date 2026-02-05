import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.model.FailureHandling

String url = 'https://katalon-demo-cura.herokuapp.com/profile.php#login'

KeywordUtil.logInfo('Step 1: Open browser and navigate to login')
WebUI.openBrowser('')
WebUI.navigateToUrl(url)

KeywordUtil.logInfo('Step 2: Enter username')
TestObject username = new TestObject('txtUsername')
username.addProperty('id', ConditionType.EQUALS, 'txt-username')
WebUI.setText(username, 'John Doe')

KeywordUtil.logInfo('Step 3: Verify username value')
String v = WebUI.getAttribute(username, 'value')
KeywordUtil.verifyEqual(v, 'John Doe', FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Step 4: Close')
WebUI.closeBrowser()
