import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

// Simple API test
WS.sendRequest(findTestObject('API/GetUser'))
WS.verifyResponseStatusCode(response, 200)