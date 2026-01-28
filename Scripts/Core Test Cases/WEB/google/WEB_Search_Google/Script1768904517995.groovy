import com.common.Context
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.ui.SearchFlow

WebUI.navigateToUrl('https://www.google.com')

def search = Context.get(SearchFlow)
search.search('Katalon Studio')
assert search.hasResults()
