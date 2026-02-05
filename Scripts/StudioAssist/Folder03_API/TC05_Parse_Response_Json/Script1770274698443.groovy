import groovy.json.JsonSlurper
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.RequestObject

KeywordUtil.logInfo('Step 1: Send request')
RequestObject ro = new RequestObject('GET_httpbin_uuid')
ro.setRestUrl('https://httpbin.org/uuid')
ro.setRestRequestMethod('GET')

def resp = WS.sendRequest(ro)
WS.verifyResponseStatusCode(resp, 200)

KeywordUtil.logInfo('Step 2: Parse JSON')
def json = new JsonSlurper().parseText(resp.getResponseBodyContent())
KeywordUtil.logInfo("Parsed: ${json}")

KeywordUtil.logInfo('Step 3: Verify uuid exists')
assert json.uuid != null
assert json.uuid.toString().contains('-')

KeywordUtil.logInfo('Step 4: End')
