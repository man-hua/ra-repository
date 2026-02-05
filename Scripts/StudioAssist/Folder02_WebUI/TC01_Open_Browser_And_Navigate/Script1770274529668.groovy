import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.model.FailureHandling

String url = 'https://katalon-demo-cura.herokuapp.com/'

KeywordUtil.logInfo('Step 1: Open browser')
WebUI.openBrowser('')

KeywordUtil.logInfo("Step 2: Navigate to ${url}")
WebUI.navigateToUrl(url)

KeywordUtil.logInfo('Step 3: Verify page title is not empty')
String title = WebUI.getWindowTitle()
KeywordUtil.logInfo("Title: ${title}")
KeywordUtil.verifyGreaterThan(title?.trim()?.size() ?: 0, 0, FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Step 4: Close browser')
WebUI.closeBrowser()
