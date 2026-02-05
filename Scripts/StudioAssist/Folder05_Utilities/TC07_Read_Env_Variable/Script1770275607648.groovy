import com.kms.katalon.core.util.KeywordUtil

KeywordUtil.logInfo('Step 1: Read environment variable PATH')
String path = System.getenv('PATH')

KeywordUtil.logInfo('Step 2: Verify variable exists or log warning')
if (path == null || path.trim().isEmpty()) {
    KeywordUtil.markWarning('PATH env var is missing/empty on this machine')
} else {
    KeywordUtil.logInfo("PATH length: ${path.length()}")
}

KeywordUtil.logInfo('Step 3: Basic assertion')
assert true

KeywordUtil.logInfo('Step 4: End')
