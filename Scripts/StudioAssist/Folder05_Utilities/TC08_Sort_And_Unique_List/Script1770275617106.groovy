import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.model.FailureHandling

KeywordUtil.logInfo('Step 1: Define list with duplicates')
def data = [5, 2, 5, 1, 3, 2]
KeywordUtil.logInfo("Original: ${data}")

KeywordUtil.logInfo('Step 2: Sort')
def sorted = data.sort()
KeywordUtil.logInfo("Sorted: ${sorted}")

KeywordUtil.logInfo('Step 3: Unique')
def uniq = sorted.unique()
KeywordUtil.logInfo("Unique: ${uniq}")

KeywordUtil.logInfo('Step 4: Verify')
KeywordUtil.verifyEqual(uniq, [1,2,3,5], FailureHandling.STOP_ON_FAILURE)
