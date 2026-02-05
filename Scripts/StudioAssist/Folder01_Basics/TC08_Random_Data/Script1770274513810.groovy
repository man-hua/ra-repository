import com.kms.katalon.core.util.KeywordUtil
import java.util.UUID
import com.kms.katalon.core.model.FailureHandling

KeywordUtil.logInfo('Step 1: Generate UUID')
String id = UUID.randomUUID().toString()
KeywordUtil.logInfo("UUID: ${id}")

KeywordUtil.logInfo('Step 2: Verify UUID format contains 4 hyphens')
KeywordUtil.verifyEqual(id.count('-'), 4, FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Step 3: Generate random number')
int n = new Random().nextInt(100)
KeywordUtil.logInfo("Random number: ${n}")

KeywordUtil.logInfo('Step 4: Verify range')
KeywordUtil.verifyEqual(n >= 0 && n < 100, true, FailureHandling.STOP_ON_FAILURE)
