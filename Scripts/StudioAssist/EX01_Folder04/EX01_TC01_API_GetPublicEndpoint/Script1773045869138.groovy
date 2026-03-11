import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.ResponseObject

// Build a simple GET request to a public endpoint
RequestObject req = new RequestObject()
req.setRestUrl('https://httpbin.org/get')
req.setRestRequestMethod('GET')

ResponseObject resp = WS.sendRequest(req)
WS.verifyResponseStatusCode(resp, 200)
WS.verifyElementPropertyValue(resp, 'url', 'https://httpbin.org/get')