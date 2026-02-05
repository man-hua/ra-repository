import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.model.FailureHandling

KeywordUtil.logInfo('Step 1: Define records')
def records = [
  [id: 1, status: 'ACTIVE'],
  [id: 2, status: 'INACTIVE'],
  [id: 3, status: 'ACTIVE']
]

KeywordUtil.logInfo('Step 2: Validate rules (id positive, status allowed)')
records.each { r ->
    KeywordUtil.verifyGreaterThan(r.id as int, 0, FailureHandling.STOP_ON_FAILURE)
    KeywordUtil.verifyMatch(r.status, /(ACTIVE|INACTIVE)/, false, FailureHandling.STOP_ON_FAILURE)
}

KeywordUtil.logInfo('Step 3: Verify at least one ACTIVE')
KeywordUtil.verifyEqual(records.any { it.status == 'ACTIVE' }, true, FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Step 4: End')
