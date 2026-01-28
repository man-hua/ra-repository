

import java.nio.file.Paths

import com.common.Context
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.microsoft.playwright.Browser
import com.microsoft.playwright.Page
import com.microsoft.playwright.Playwright

import internal.GlobalVariable
import pw.common.PlaywrightFactory

class TestListener {
	@BeforeTestCase
	def openBrowserBeforeTestCase(TestCaseContext testCaseContext) {
		String testCaseName = testCaseContext.getTestCaseId().split("/").last()
		if(!testCaseName.contains("WEB_"))
			return

		if(testCaseContext.getTestCaseVariables().containsKey("url"))
			WebUI.openBrowser(testCaseContext.getTestCaseVariables().get("url"))
		else
			WebUI.openBrowser(GlobalVariable.G_SiteURL)
	}

	@AfterTestCase
	def closeBrowserAfterTestCase(TestCaseContext testCaseContext) {
		String[] testCasePath = testCaseContext.getTestCaseId().split("/")
		if(!testCasePath.last().contains("WEB_"))
			return
		WebUI.closeBrowser()
	}

	@BeforeTestCase
	def openPlaywrightBrowserBeforeTestCase(TestCaseContext testCaseContext) {
		String testCaseName = testCaseContext.getTestCaseId().split("/").last()
		if(!testCaseName.contains("PW_"))
			return

		if(testCaseContext.getTestCaseVariables().containsKey("url"))
			Context.get(PlaywrightFactory).openBrowser(testCaseContext.getTestCaseVariables().get("url"))
		else
			Context.get(PlaywrightFactory).openBrowser(GlobalVariable.G_SiteURL)
	}

	@AfterTestCase
	def closePlaywrightBrowserAfterTestCase(TestCaseContext testCaseContext) {
		String[] testCasePath = testCaseContext.getTestCaseId().split("/")
		if(!testCasePath.last().contains("PW_"))
			return
		
//		playwright.close()
		Context.get(PlaywrightFactory).closeBrowser()
	}
}