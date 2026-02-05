import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.RequestObject

KeywordUtil.logInfo('Step 1: Build basic-auth request (user/pass)')
RequestObject ro = new RequestObject('GET_httpbin_basic_auth')
ro.setRestUrl('https://user:pass@httpbin.org/basic-auth/user/pass')
ro.setRestRequestMethod('GET')

KeywordUtil.logInfo('Step 2: Send request')
def resp = WS.sendRequest(ro)

KeywordUtil.logInfo('Step 3: Verify status 200')
WS.verifyResponseStatusCode(resp, 200)

KeywordUtil.logInfo('Step 4: Verify authenticated true')
WS.verifyElementPropertyValue(resp, 'authenticated', true)
