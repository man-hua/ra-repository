import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject

RequestObject req = new RequestObject()
req.setRestUrl('https://httpbin.org/response-headers?foo=bar')
req.setRestRequestMethod('GET')

ResponseObject resp = WS.sendRequest(req)
WS.verifyResponseStatusCode(resp, 200)
WS.verifyElementPropertyValue(resp, 'foo', 'bar')