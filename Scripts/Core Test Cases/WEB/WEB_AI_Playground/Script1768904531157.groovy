import com.common.Context
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.ui.AiFlow

WebUI.navigateToUrl('https://example-ai.com')

def ai = Context.get(AiFlow)
ai.submitPrompt('Explain singleton pattern')
assert ai.readResponse().length() > 0
