import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.configuration.RunConfiguration

String url = 'https://katalon-demo-cura.herokuapp.com/'

KeywordUtil.logInfo('Step 1: Open browser and navigate')
WebUI.openBrowser('')
WebUI.navigateToUrl(url)

KeywordUtil.logInfo('Step 2: Take screenshot')
String out = RunConfiguration.getProjectDir() + '/Reports/studioassist_home.png'
WebUI.takeScreenshot(out)
KeywordUtil.logInfo("Saved screenshot: ${out}")

KeywordUtil.logInfo('Step 3: Close')
WebUI.closeBrowser()
