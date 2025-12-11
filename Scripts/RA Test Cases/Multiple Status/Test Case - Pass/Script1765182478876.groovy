import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
WebUI.delay(60)
KeywordUtil.markFailedAndStop("New Failure for Pass test case")
KeywordUtil.markPassed("Passed")