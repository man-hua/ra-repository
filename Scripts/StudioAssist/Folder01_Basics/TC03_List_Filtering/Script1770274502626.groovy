import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.model.FailureHandling

KeywordUtil.logInfo('Step 1: Create list')
def data = [3, 10, 2, 8, 15, 1]
KeywordUtil.logInfo("Data: ${data}")

KeywordUtil.logInfo('Step 2: Filter values > 5')
def filtered = data.findAll { it > 5 }
KeywordUtil.logInfo("Filtered: ${filtered}")

KeywordUtil.logInfo('Step 3: Verify filtered size')
KeywordUtil.verifyEqual(filtered.size(), 3, FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Step 4: Verify all are > 5')
KeywordUtil.verifyEqual(filtered.every { it > 5 }, true, FailureHandling.STOP_ON_FAILURE)
