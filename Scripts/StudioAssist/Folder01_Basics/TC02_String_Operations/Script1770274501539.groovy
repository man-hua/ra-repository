import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.model.FailureHandling

KeywordUtil.logInfo('Step 1: Define strings')
String a = 'katalon'
String b = 'studio'

KeywordUtil.logInfo('Step 2: Concatenate')
String c = a + '-' + b
KeywordUtil.logInfo("Concatenated: ${c}")

KeywordUtil.logInfo('Step 3: Verify content')
KeywordUtil.verifyMatch(c, /katalon-studio/, false, FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Step 4: Verify length')
KeywordUtil.verifyGreaterThan(c.length(), 5, FailureHandling.STOP_ON_FAILURE)
