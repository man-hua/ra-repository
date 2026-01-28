import com.common.Context
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.navigateToUrl('https://the-internet.herokuapp.com/login')

def auth = Context.get(com.ui.AuthFlow)
auth.login('tomsmith', 'SuperSecretPassword!')

WebUI.refresh()
assert auth.isLoginSuccess()
