import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.model.FailureHandling

KeywordUtil.logInfo('Step 1: Setup values')
int a = 5
int b = 7

KeywordUtil.logInfo('Step 2: Verify not equal')
KeywordUtil.verifyNotEqual(a, b, FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Step 3: Verify sum')
KeywordUtil.verifyEqual(a + b, 12, FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Step 4: Mark passed')
KeywordUtil.markPassed('All assertions passed')
