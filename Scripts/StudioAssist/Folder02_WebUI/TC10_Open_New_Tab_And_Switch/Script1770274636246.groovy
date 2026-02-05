import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil

String url = 'https://katalon-demo-cura.herokuapp.com/'

KeywordUtil.logInfo('Step 1: Open browser')
WebUI.openBrowser('')
WebUI.navigateToUrl(url)

KeywordUtil.logInfo('Step 2: Open new window')
WebUI.executeJavaScript('window.open("https://example.com","_blank");', null)
WebUI.delay(1)

KeywordUtil.logInfo('Step 3: Switch to window index 1 and verify title')
WebUI.switchToWindowIndex(1)
String title2 = WebUI.getWindowTitle()
KeywordUtil.logInfo("Title (tab2): ${title2}")

KeywordUtil.logInfo('Step 4: Switch back and close')
WebUI.switchToWindowIndex(0)
WebUI.closeBrowser()
