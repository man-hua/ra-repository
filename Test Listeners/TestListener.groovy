import com.katalon.KatalonHelper
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

class TestListener {	
	@BeforeTestCase
	def openBrowserBeforeTestCase(TestCaseContext testCaseContext) {
		if(testCaseContext.getTestCaseVariables().containsKey("url"))
			WebUI.openBrowser(testCaseContext.getTestCaseVariables().get("url"))
		else
			WebUI.openBrowser(GlobalVariable.G_SiteURL)
	}
	
	@AfterTestCase
	def closeBrowserAfterTestCase(TestCaseContext testCaseContext) {
		WebUI.closeBrowser()
	}
}