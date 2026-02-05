import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling

KeywordUtil.logInfo('Step 1: Start test case')
KeywordUtil.logInfo("Project dir: ${RunConfiguration.getProjectDir()}")

KeywordUtil.logInfo('Step 2: Prepare data')
def nums = (1..5).toList()
KeywordUtil.logInfo("Numbers: ${nums}")

KeywordUtil.logInfo('Step 3: Verify expected')
KeywordUtil.verifyEqual(nums.sum(), 15, FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Step 4: End test case')
