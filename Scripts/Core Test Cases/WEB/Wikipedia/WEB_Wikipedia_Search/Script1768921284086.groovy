import com.common.Context
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.ui.ContentFlow

WebUI.navigateToUrl('https://en.wikipedia.org')

def c = Context.get(ContentFlow)
c.searchArticle('Software testing')
assert c.isArticleDisplayed('Software testing')
