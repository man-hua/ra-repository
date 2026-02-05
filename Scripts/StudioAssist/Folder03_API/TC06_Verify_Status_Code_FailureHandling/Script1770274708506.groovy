import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.RequestObject

KeywordUtil.logInfo('Step 1: Create request')
RequestObject ro = new RequestObject('GET_httpbin_200')
ro.setRestUrl('https://httpbin.org/status/200')
ro.setRestRequestMethod('GET')

def resp = WS.sendRequest(ro)

KeywordUtil.logInfo('Step 2: Verify 200 with STOP')
WS.verifyResponseStatusCode(resp, 200, FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Step 3: Verify 201 with CONTINUE (expected to fail but continue)')
WS.verifyResponseStatusCode(resp, 201, FailureHandling.CONTINUE_ON_FAILURE)

KeywordUtil.logInfo('Step 4: Mark passed end (test may be WARNING due to verify failure)')
KeywordUtil.logInfo('Done')
