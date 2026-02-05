import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.testdata.TestDataFactory as TDF
import com.kms.katalon.core.model.FailureHandling

KeywordUtil.logInfo('Step 1: Load test data')
def td = TDF.findTestData('Data Files/StudioAssist/StudioAssist_SampleData')

KeywordUtil.logInfo('Step 2: Iterate rows')
int rows = td.getRowNumbers()
for (int i = 1; i <= rows; i++) {
    String u = td.getValue('username', i)
    String p = td.getValue('password', i)
    String r = td.getValue('role', i)

    KeywordUtil.logInfo("Row ${i}: ${u} / ${r}")
    KeywordUtil.verifyGreaterThan(u.size(), 0, FailureHandling.STOP_ON_FAILURE)
    KeywordUtil.verifyGreaterThan(p.size(), 0, FailureHandling.STOP_ON_FAILURE)
    KeywordUtil.verifyMatch(r, /(admin|editor|viewer)/, false, FailureHandling.STOP_ON_FAILURE)
}

KeywordUtil.logInfo('Step 3: Verify row count')
KeywordUtil.verifyEqual(rows, 3, FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Step 4: End')
