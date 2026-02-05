import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory as TDF
import com.kms.katalon.core.model.FailureHandling

KeywordUtil.logInfo('Step 1: Load internal test data')
TestData td = TDF.findTestData('Data Files/StudioAssist/StudioAssist_SampleData')
assert td != null

KeywordUtil.logInfo('Step 2: Verify columns')
KeywordUtil.verifyEqual(td.getColumnNumbers(), 3, FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Step 3: Read first row values')
String username1 = td.getValue('username', 1)
String role1 = td.getValue('role', 1)
KeywordUtil.logInfo("Row1 username=${username1}, role=${role1}")

KeywordUtil.logInfo('Step 4: Verify not empty')
KeywordUtil.verifyGreaterThan(username1.size(), 0, FailureHandling.STOP_ON_FAILURE)
KeywordUtil.verifyGreaterThan(role1.size(), 0, FailureHandling.STOP_ON_FAILURE)
