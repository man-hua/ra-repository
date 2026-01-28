import com.common.Context
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.ui.AuthFlow

WebUI.navigateToUrl('https://the-internet.herokuapp.com/login')

Context.get(AuthFlow)
       .login('tomsmith', 'SuperSecretPassword!')

WebUI.verifyTextPresent('secure area', false)
