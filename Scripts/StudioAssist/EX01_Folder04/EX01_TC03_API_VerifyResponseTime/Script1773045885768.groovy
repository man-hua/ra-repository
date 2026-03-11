import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject

RequestObject req = new RequestObject()
req.setRestUrl('https://httpbin.org/delay/1')
req.setRestRequestMethod('GET')

long start = System.currentTimeMillis()
ResponseObject resp = WS.sendRequest(req)
long elapsed = System.currentTimeMillis() - start

WS.verifyResponseStatusCode(resp, 200)
// sample threshold: 5000ms
assert elapsed < 5000 : "Response time too slow: ${elapsed} ms"