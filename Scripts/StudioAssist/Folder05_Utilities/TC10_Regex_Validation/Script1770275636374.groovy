import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.model.FailureHandling

KeywordUtil.logInfo('Step 1: Define values')
String phone = '+1-202-555-0101'
String zip = '12345'

KeywordUtil.logInfo('Step 2: Validate phone')
KeywordUtil.verifyMatch(phone, /\+\d-\d{3}-\d{3}-\d{4}/, false, FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Step 3: Validate zip')
KeywordUtil.verifyMatch(zip, /\d{5}/, false, FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Step 4: End')
