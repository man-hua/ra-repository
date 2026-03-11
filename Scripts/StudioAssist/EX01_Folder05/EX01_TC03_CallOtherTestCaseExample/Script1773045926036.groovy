import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling

// Call a simple test case in this demo suite
WebUI.callTestCase(TestCaseFactory.findTestCase('Test Cases/StudioAssist/EX01_Folder01/EX01_TC01_OpenHomeAndVerify'), [:], FailureHandling.STOP_ON_FAILURE)