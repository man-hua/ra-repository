import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

// API POST request
WS.sendRequest(findTestObject('API/PostData'))
WS.verifyResponseStatusCode(response, 201)