import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

KeywordUtil.logInfo('Step 1: Capture start time')
long start = System.currentTimeMillis()
KeywordUtil.logInfo("Start ms: ${start}")

KeywordUtil.logInfo('Step 2: Delay 1 second')
WebUI.delay(1)

KeywordUtil.logInfo('Step 3: Capture end time')
long end = System.currentTimeMillis()
KeywordUtil.logInfo("End ms: ${end}")

KeywordUtil.logInfo('Step 4: Verify elapsed >= 1000ms')
assert (end - start) >= 900
