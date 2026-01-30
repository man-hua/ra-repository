import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

WS.sendRequest(findTestObject('API/GetUser'))
WS.verifyResponseStatusCode(response, 200)