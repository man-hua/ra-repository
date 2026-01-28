import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.navigateToUrl('https://the-internet.herokuapp.com/secure')

WebUI.verifyTextPresent('login', false)
