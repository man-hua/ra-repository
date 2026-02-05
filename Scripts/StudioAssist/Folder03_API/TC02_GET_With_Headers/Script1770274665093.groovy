import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.ConditionType

KeywordUtil.logInfo('Step 1: Build GET request with headers')
RequestObject ro = new RequestObject('GET_httpbin_headers')
ro.setRestUrl('https://httpbin.org/headers')
ro.setRestRequestMethod('GET')
ro.setHttpHeaderProperties([
    new TestObjectProperty('X-StudioAssist', ConditionType.EQUALS, 'true'),
    new TestObjectProperty('Accept', ConditionType.EQUALS, 'application/json')
])

KeywordUtil.logInfo('Step 2: Send request')
def resp = WS.sendRequest(ro)

KeywordUtil.logInfo('Step 3: Verify status code')
WS.verifyResponseStatusCode(resp, 200)

KeywordUtil.logInfo('Step 4: Verify custom header echoed')
WS.verifyElementPropertyValue(resp, 'headers.X-Studioassist', 'true')
