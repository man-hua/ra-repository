import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.model.FailureHandling

KeywordUtil.logInfo('Step 1: Define in-script data set')
def rows = [
  [username: 'user1', password: 'pass1'],
  [username: 'user2', password: 'pass2'],
  [username: 'user3', password: 'pass3']
]

KeywordUtil.logInfo('Step 2: Iterate and validate each row')
rows.eachWithIndex { r, idx ->
    KeywordUtil.logInfo("Row ${idx + 1}: ${r}")
    KeywordUtil.verifyGreaterThan(r.username.size(), 0, FailureHandling.STOP_ON_FAILURE)
    KeywordUtil.verifyGreaterThan(r.password.size(), 0, FailureHandling.STOP_ON_FAILURE)
}

KeywordUtil.logInfo('Step 3: Verify total rows')
KeywordUtil.verifyEqual(rows.size(), 3, FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Step 4: End')
