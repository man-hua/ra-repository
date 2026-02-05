import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.model.FailureHandling

KeywordUtil.logInfo('Step 1: Build GET request object')
RequestObject ro = new RequestObject('GET_httpbin')
ro.setRestUrl('https://httpbin.org/get')
ro.setRestRequestMethod('GET')

KeywordUtil.logInfo('Step 2: Send request')
def resp = WS.sendRequest(ro)

KeywordUtil.logInfo('Step 3: Verify status code = 200')
WS.verifyResponseStatusCode(resp, 200)

KeywordUtil.logInfo('Step 4: Verify response contains url')
WS.verifyElementPropertyValue(resp, 'url', 'https://httpbin.org/get', FailureHandling.CONTINUE_ON_FAILURE)
