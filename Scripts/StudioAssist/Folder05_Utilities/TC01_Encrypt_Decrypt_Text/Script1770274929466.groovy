import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.util.internal.Base64
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.internal.PathUtil
import com.kms.katalon.core.util.internal.EncodingUtil

// Note: Katalon provides built-in encryption utility via KeywordUtil.encrypt/decrypt in some versions.
// Use com.kms.katalon.core.util.internal.EncodingUtil for a stable demo.

KeywordUtil.logInfo('Step 1: Define plain text')
String plain = 'StudioAssistSecret'

KeywordUtil.logInfo('Step 2: Base64 encode')
String encoded = Base64.encodeBase64String(plain.getBytes('UTF-8'))
KeywordUtil.logInfo("Encoded: ${encoded}")

KeywordUtil.logInfo('Step 3: Base64 decode')
String decoded = new String(Base64.decodeBase64(encoded), 'UTF-8')

KeywordUtil.logInfo('Step 4: Verify decoded equals original')
KeywordUtil.verifyEqual(decoded, plain, FailureHandling.STOP_ON_FAILURE)
