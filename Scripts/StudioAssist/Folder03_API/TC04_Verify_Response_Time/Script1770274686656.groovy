import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.RequestObject

KeywordUtil.logInfo('Step 1: Create request')
RequestObject ro = new RequestObject('GET_delay')
ro.setRestUrl('https://httpbin.org/delay/1')
ro.setRestRequestMethod('GET')

KeywordUtil.logInfo('Step 2: Send request and measure')
long start = System.currentTimeMillis()
def resp = WS.sendRequest(ro)
long elapsed = System.currentTimeMillis() - start
KeywordUtil.logInfo("Elapsed ms: ${elapsed}")

KeywordUtil.logInfo('Step 3: Verify status code')
WS.verifyResponseStatusCode(resp, 200)

KeywordUtil.logInfo('Step 4: Verify elapsed < 5000ms')
assert elapsed < 5000
