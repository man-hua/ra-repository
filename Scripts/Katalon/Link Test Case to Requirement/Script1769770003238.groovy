import com.common.ApiFactory
import com.common.Context
import com.kms.katalon.core.util.KeywordUtil

Map<String, String> test = new HashMap<String, String>()

test.put('Authorization', 'Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJqWVpYSzBWUHROcDRpaVJzcUlfT3Q4LW56NURCRXNlM0VFd2RHSEZfUjZVIn0.eyJleHAiOjE3Njk5NDM1MjksImlhdCI6MTc2OTc3MDcyOSwianRpIjoib25sdGFjOjBkNTU3MjE4LTI2N2YtZDQ0Ni0yZDU1LWEyMDRmMWU4ZDA4YSIsImlzcyI6Imh0dHBzOi8vbG9naW4uc3RhZ2luZy5rYXRhbG9uLmNvbS9yZWFsbXMva2F0YWxvbiIsInN1YiI6IjQyMTBhNjkxLTA1NmEtNDVhOS04MDI3LWI0ZjJlM2MzNjM5YiIsInR5cCI6IkJlYXJlciIsImF6cCI6ImthdGFsb24tdGVzdG9wcy1nZW4zIiwic2lkIjoiN2NlMzU4ZmItNjY4Yy0yODAyLWY1ZjgtN2UwM2MzNmVlZDg1Iiwic2NvcGUiOiJvcGVuaWQiLCJhY2NvdW50X3V1aWQiOiI4ZDdjODM0MC01YmFjLTRjZmUtOTMyNi1jMDQ0NmFkZjg4MTYiLCJlbWFpbCI6Im1hbi5odWFAa2F0YWxvbi5jb20ifQ.Vbt6cTbUEaVXWWQmoIjnwgnMLWlhJaPmbiUBU8weaBdGpnZUidFC4wJZTUYJIcuOl6oGnyLmxM88f-93JuOiNSUTQ6Ly4Av8na15lrPggpyd3GlK21ozygyST8_UdqJVtERNBhf69VanjiAC78-LJJYX7bK33E8SqyQar3H8y9F-8XaRg0OGC4Kqq78Clo1Lt2htX3ZSSuGyMphhYlOOTo0-s2kgsFedgQgFLsUFnnEuBKx1XaVvx2WuzZkeD9PsLtz4El11bXup-vCoSSlenJSsuC-8WVD7Zq1jWSN9JVn6WDI1uqCrVk29zm0rqWJeoLwFQq5s1ZRXOIDc6patDQ')

test.put('x-organization-id', '426801')

test.put('x-project-id', '484430')

test.put('x-account-id', '8d7c8340-5bac-4cfe-9326-c0446adf8816')

def testCases = []

def testCasesInFolder1 = Context.get(ApiFactory)
.initRequestObject()
.setHeaders(test)
.get('https://staginggen3platform.staging.katalon.com/api/v1/search?q=%7B%22type%22%3A%22TestCase%22%2C%22conditions%22%3A%5B%7B%22key%22%3A%22TestProject.id%22%2C%22operator%22%3A%22is+not+null%22%2C%22value%22%3A%22%22%7D%2C%7B%22key%22%3A%22TestFolder.id%22%2C%22operator%22%3A%22%3D%22%2C%22value%22%3A2201667%7D%2C%7B%22key%22%3A%22Project.id%22%2C%22operator%22%3A%22%3D%22%2C%22value%22%3A484430%7D%5D%2C%22custom_field_conditions%22%3A%5B%5D%2C%22customizable_field_conditions%22%3A%5B%5D%2C%22pagination%22%3A%7B%22page%22%3A0%2C%22size%22%3A100%2C%22sorts%22%3A%5B%22id%2Cdesc%22%5D%7D%7D&extendedFields=featureArea%2CtestType')
.getJsonResponse().content

def testCasesInFolder2 = Context.get(ApiFactory)
.initRequestObject()
.setHeaders(test)
.get('https://staginggen3platform.staging.katalon.com/api/v1/search?q=%7B%22type%22%3A%22TestCase%22%2C%22conditions%22%3A%5B%7B%22key%22%3A%22TestProject.id%22%2C%22operator%22%3A%22is+not+null%22%2C%22value%22%3A%22%22%7D%2C%7B%22key%22%3A%22TestFolder.id%22%2C%22operator%22%3A%22%3D%22%2C%22value%22%3A2201664%7D%2C%7B%22key%22%3A%22Project.id%22%2C%22operator%22%3A%22%3D%22%2C%22value%22%3A484430%7D%5D%2C%22custom_field_conditions%22%3A%5B%5D%2C%22customizable_field_conditions%22%3A%5B%5D%2C%22pagination%22%3A%7B%22page%22%3A0%2C%22size%22%3A100%2C%22sorts%22%3A%5B%22id%2Cdesc%22%5D%7D%7D&extendedFields=featureArea%2CtestType')
.getJsonResponse().content

testCases.addAll(testCasesInFolder1)
testCases.addAll(testCasesInFolder2)

def nameListSize = testCases.size()

def r = new Random()

def requirements = Context.get(ApiFactory)
.initRequestObject()
.setHeaders(test)
.get("https://staginggen3platform.staging.katalon.com/v2/tm/requirements?sprintId=93042")
.getJsonResponse()


for (req in requirements) {
	Collections.shuffle(testCases)
	
	Context.get(ApiFactory)
	.initRequestObject()
	.setHeaders(test)
	.setApplicationJsonContentType()
	.post("https://staginggen3platform.staging.katalon.com/v2/tm/requirements/${req.id}/link-test-cases",
"""{"testCaseIds":${testCases.take(r.nextInt(nameListSize)).collect{it.id}.toString()}}""")
}