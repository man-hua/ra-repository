import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil

String url = 'https://katalon-demo-cura.herokuapp.com/'

KeywordUtil.logInfo('Step 1: Open browser & navigate')
WebUI.openBrowser('')
WebUI.navigateToUrl(url)

KeywordUtil.logInfo('Step 2: Verify text present')
WebUI.verifyTextPresent('CURA Healthcare Service', false)

KeywordUtil.logInfo('Step 3: Close browser')
WebUI.closeBrowser()
