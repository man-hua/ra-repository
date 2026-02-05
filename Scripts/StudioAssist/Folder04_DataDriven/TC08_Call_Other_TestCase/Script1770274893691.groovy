import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testcase.TestCaseFactory as TCF
import com.kms.katalon.core.util.KeywordUtil

KeywordUtil.logInfo('Step 1: Call a basic test case')
WebUI.callTestCase(TCF.findTestCase('Test Cases/StudioAssist/Folder01_Basics/TC01_Log_and_Verify'), [:], com.kms.katalon.core.model.FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Step 2: Continue after call')
KeywordUtil.markPassed('Called basic test case successfully')
