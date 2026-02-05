import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.RequestObject

KeywordUtil.logInfo('Step 1: Call redirects endpoint')
RequestObject ro = new RequestObject('GET_httpbin_redirects')
ro.setRestUrl('https://httpbin.org/redirect/1')
ro.setRestRequestMethod('GET')

def resp = WS.sendRequest(ro)

KeywordUtil.logInfo('Step 2: Verify status code')
WS.verifyResponseStatusCode(resp, 200)

KeywordUtil.logInfo('Step 3: Verify response contains url field')
WS.verifyElementPropertyValue(resp, 'url', 'https://httpbin.org/get')

KeywordUtil.logInfo('Step 4: End')
