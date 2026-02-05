import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.model.FailureHandling

KeywordUtil.logInfo('Step 1: Create map')
def user = [username: 'demo', role: 'admin', active: true]
KeywordUtil.logInfo("User: ${user}")

KeywordUtil.logInfo('Step 2: Verify keys')
KeywordUtil.verifyEqual(user.containsKey('username'), true, FailureHandling.STOP_ON_FAILURE)
KeywordUtil.verifyEqual(user.containsKey('role'), true, FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Step 3: Verify values')
KeywordUtil.verifyEqual(user.username, 'demo', FailureHandling.STOP_ON_FAILURE)
KeywordUtil.verifyEqual(user.active, true, FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Step 4: Update and verify')
user.role = 'editor'
KeywordUtil.verifyEqual(user.role, 'editor', FailureHandling.STOP_ON_FAILURE)
