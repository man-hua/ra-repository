import com.common.Context
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.navigateToUrl('https://the-internet.herokuapp.com/login')

def auth = Context.get(com.ui.AuthFlow)
auth.login('tomsmith', 'wrong')

WebUI.verifyTextPresent('invalid', false)

auth.login('tomsmith', 'SuperSecretPassword!')
assert auth.isLoginSuccess()
