import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl('https://katalon-demo-cura.herokuapp.com/')
WebUI.waitForPageLoad(30)

String title = WebUI.getWindowTitle()
WebUI.verifyMatch(title, '.*CURA.*', true)

WebUI.closeBrowser()