import com.kms.katalon.core.util.KeywordUtil
import java.text.SimpleDateFormat
import com.kms.katalon.core.model.FailureHandling

KeywordUtil.logInfo('Step 1: Create date')
Date now = new Date()

KeywordUtil.logInfo('Step 2: Format date')
def fmt = new SimpleDateFormat('yyyy-MM-dd')
String s = fmt.format(now)
KeywordUtil.logInfo("Formatted: ${s}")

KeywordUtil.logInfo('Step 3: Verify pattern')
KeywordUtil.verifyMatch(s, /\d{4}-\d{2}-\d{2}/, false, FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Step 4: End')
