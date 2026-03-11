import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.testobject.ResponseObject

RequestObject req = new RequestObject()
req.setRestUrl('https://httpbin.org/post')
req.setRestRequestMethod('POST')
req.setHttpHeaderProperties([
	new com.kms.katalon.core.testobject.TestObjectProperty('Content-Type', com.kms.katalon.core.testobject.ConditionType.EQUALS, 'application/json')
])
req.setBodyContent(new HttpTextBodyContent('{"hello":"world"}', 'UTF-8', 'application/json'))

ResponseObject resp = WS.sendRequest(req)
WS.verifyResponseStatusCode(resp, 200)
WS.verifyElementPropertyValue(resp, 'json.hello', 'world')