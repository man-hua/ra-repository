import com.kms.katalon.core.util.KeywordUtil
import internal.GlobalVariable

KeywordUtil.logInfo('Step 1: Access GlobalVariable class')
KeywordUtil.logInfo("GlobalVariable class loaded: ${GlobalVariable != null}")

KeywordUtil.logInfo('Step 2: List declared fields (for demo)')
def fields = GlobalVariable.class.declaredFields*.name
KeywordUtil.logInfo("GlobalVariable fields: ${fields}")

KeywordUtil.logInfo('Step 3: Basic assertion')
assert fields != null

KeywordUtil.logInfo('Step 4: End')
