import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.ConditionType

KeywordUtil.logInfo('Step 1: Build POST request')
RequestObject ro = new RequestObject('POST_httpbin')
ro.setRestUrl('https://httpbin.org/post')
ro.setRestRequestMethod('POST')
ro.setHttpHeaderProperties([
  new TestObjectProperty('Content-Type', ConditionType.EQUALS, 'application/json')
])

String body = '{"name":"StudioAssist","type":"sample"}'
ro.setBodyContent(new com.kms.katalon.core.testobject.impl.HttpTextBodyContent(body, 'UTF-8', 'application/json'))

KeywordUtil.logInfo('Step 2: Send request')
def resp = WS.sendRequest(ro)

KeywordUtil.logInfo('Step 3: Verify status code')
WS.verifyResponseStatusCode(resp, 200)

KeywordUtil.logInfo('Step 4: Verify JSON echoed')
WS.verifyElementPropertyValue(resp, 'json.name', 'StudioAssist')
WS.verifyElementPropertyValue(resp, 'json.type', 'sample')
