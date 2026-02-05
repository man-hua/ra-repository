import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.model.FailureHandling

String url = 'https://katalon-demo-cura.herokuapp.com/'

KeywordUtil.logInfo('Step 1: Open browser and navigate')
WebUI.openBrowser('')
WebUI.navigateToUrl(url)

KeywordUtil.logInfo('Step 2: Get current URL')
String current = WebUI.getUrl()
KeywordUtil.logInfo("Current URL: ${current}")
KeywordUtil.verifyEqual(current.contains('katalon-demo-cura.herokuapp.com'), true, FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Step 3: Close')
WebUI.closeBrowser()
