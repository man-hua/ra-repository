import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.model.FailureHandling

KeywordUtil.logInfo('Step 1: Generate random email')
String email = "user_${System.currentTimeMillis()}@example.com"
KeywordUtil.logInfo("Email: ${email}")

KeywordUtil.logInfo('Step 2: Verify email pattern')
KeywordUtil.verifyMatch(email, /.+@example\.com/, false, FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Step 3: Verify contains user_')
KeywordUtil.verifyEqual(email.contains('user_'), true, FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Step 4: End')
