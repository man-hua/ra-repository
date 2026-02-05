import groovy.json.JsonSlurper
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.RequestObject

KeywordUtil.logInfo('Step 1: Send request')
RequestObject ro = new RequestObject('GET_httpbin_headers_check')
ro.setRestUrl('https://httpbin.org/get')
ro.setRestRequestMethod('GET')

def resp = WS.sendRequest(ro)
WS.verifyResponseStatusCode(resp, 200)

KeywordUtil.logInfo('Step 2: Parse response')
def json = new JsonSlurper().parseText(resp.getResponseBodyContent())

KeywordUtil.logInfo('Step 3: Verify headers present')
assert json.headers != null
assert json.headers instanceof Map

KeywordUtil.logInfo('Step 4: End')
