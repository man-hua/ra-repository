import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.model.FailureHandling

KeywordUtil.logInfo('Step 1: Loop numbers')
for (int i = 1; i <= 5; i++) {
    KeywordUtil.logInfo("Iteration: ${i}")
    KeywordUtil.verifyEqual(i > 0, true, FailureHandling.STOP_ON_FAILURE)
}

KeywordUtil.logInfo('Step 2: Verify loop completed')
KeywordUtil.markPassed('Loop completed')
