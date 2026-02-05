import com.kms.katalon.core.util.KeywordUtil

KeywordUtil.logInfo('Step 1: Define values (some null)')
String a = null
String b = 'text'

KeywordUtil.logInfo('Step 2: Apply null-safe operations')
int lenA = a?.length() ?: 0
int lenB = b?.length() ?: 0
KeywordUtil.logInfo("lenA=${lenA}, lenB=${lenB}")

KeywordUtil.logInfo('Step 3: Verify results')
assert lenA == 0
assert lenB == 4

KeywordUtil.logInfo('Step 4: End')
