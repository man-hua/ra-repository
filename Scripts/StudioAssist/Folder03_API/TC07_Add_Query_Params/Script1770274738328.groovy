import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.RequestObject

KeywordUtil.logInfo('Step 1: Build URL with query params')
String url = 'https://httpbin.org/get?env=qa&feature=studioassist'
RequestObject ro = new RequestObject('GET_httpbin_params')
ro.setRestUrl(url)
ro.setRestRequestMethod('GET')

KeywordUtil.logInfo('Step 2: Send request')
def resp = WS.sendRequest(ro)

KeywordUtil.logInfo('Step 3: Verify status')
WS.verifyResponseStatusCode(resp, 200)

KeywordUtil.logInfo('Step 4: Verify echoed args')
WS.verifyElementPropertyValue(resp, 'args.env', 'qa')
WS.verifyElementPropertyValue(resp, 'args.feature', 'studioassist')
