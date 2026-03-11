import com.common.ApiFactory
import com.common.Context
import com.kms.katalon.core.util.KeywordUtil

Map<String, String> test = new HashMap<String, String>()

test.put('Authorization', 'Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJqWVpYSzBWUHROcDRpaVJzcUlfT3Q4LW56NURCRXNlM0VFd2RHSEZfUjZVIn0.eyJleHAiOjE3NzAzNzE3NDAsImlhdCI6MTc3MDE5ODk0MCwianRpIjoib25sdGFjOjYzMzg4NTM5LTI3Y2EtZmI3MS1mOTg0LTYwMzQ4ZTdmNGVjYiIsImlzcyI6Imh0dHBzOi8vbG9naW4uc3RhZ2luZy5rYXRhbG9uLmNvbS9yZWFsbXMva2F0YWxvbiIsInN1YiI6IjQyMTBhNjkxLTA1NmEtNDVhOS04MDI3LWI0ZjJlM2MzNjM5YiIsInR5cCI6IkJlYXJlciIsImF6cCI6ImthdGFsb24tdGVzdG9wcy1nZW4zIiwic2lkIjoiYTM3NGFhNzctNWEyMi03M2Q4LWFhYzktODA0ZTg0MWY2MmY5Iiwic2NvcGUiOiJvcGVuaWQiLCJhY2NvdW50X3V1aWQiOiI4ZDdjODM0MC01YmFjLTRjZmUtOTMyNi1jMDQ0NmFkZjg4MTYiLCJlbWFpbCI6Im1hbi5odWFAa2F0YWxvbi5jb20ifQ.MWeWkX4TqmbYEMi-p9b7OLmmPcwTPwDhBm02tu6ZqFaneckIUmqvliGh3srIBP__uVYFH6-SEKFv3g11os5oU_oVdkokI8mlW-gMHDzAnD7ddqvqHKzLtYLGvKtjtLcyaNjKvGyoID0MM76X3WI2fiqCRFe4D6pourI-oA-nzw5gH0_9_KgagEBOKTBPxkMnYAx_i_VJzwW_WBpI2eYs6WPQmPkEcAFNscLQb7gw0SFLkmkCMQZkRtTW0EkUI511IyyzhB6jYM7Aulr1YIhpq0i1dKkIPErq7evZYnIKM3Yg5eYxk0V6sSHFmQtCJL4ibgGDXf-H7UWAXwYz_Nuhqg')

test.put('x-organization-id', '439875')

test.put('x-project-id', '623365')

test.put('x-account-id', '8d7c8340-5bac-4cfe-9326-c0446adf8816')

def testCases = []

def testCasesInFolder1 = Context.get(ApiFactory)
.initRequestObject()
.setHeaders(test)
.get('https://staginggen3platform.staging.katalon.com/api/v1/search?q=%7B%22type%22%3A%22TestCase%22%2C%22conditions%22%3A%5B%7B%22key%22%3A%22TestProject.id%22%2C%22operator%22%3A%22is+not+null%22%2C%22value%22%3A%22%22%7D%2C%7B%22key%22%3A%22TestFolder.id%22%2C%22operator%22%3A%22%3D%22%2C%22value%22%3A2204448%7D%2C%7B%22key%22%3A%22Project.id%22%2C%22operator%22%3A%22%3D%22%2C%22value%22%3A623365%7D%5D%2C%22custom_field_conditions%22%3A%5B%5D%2C%22customizable_field_conditions%22%3A%5B%5D%2C%22pagination%22%3A%7B%22page%22%3A0%2C%22size%22%3A100%2C%22sorts%22%3A%5B%22id%2Cdesc%22%5D%7D%7D&extendedFields=featureArea%2CtestType')
.getJsonResponse().content

def testCasesInFolder2 = Context.get(ApiFactory)
.initRequestObject()
.setHeaders(test)
.get('https://staginggen3platform.staging.katalon.com/api/v1/search?q=%7B%22type%22%3A%22TestCase%22%2C%22conditions%22%3A%5B%7B%22key%22%3A%22TestProject.id%22%2C%22operator%22%3A%22is+not+null%22%2C%22value%22%3A%22%22%7D%2C%7B%22key%22%3A%22TestFolder.id%22%2C%22operator%22%3A%22%3D%22%2C%22value%22%3A2204437%7D%2C%7B%22key%22%3A%22Project.id%22%2C%22operator%22%3A%22%3D%22%2C%22value%22%3A623365%7D%5D%2C%22custom_field_conditions%22%3A%5B%5D%2C%22customizable_field_conditions%22%3A%5B%5D%2C%22pagination%22%3A%7B%22page%22%3A0%2C%22size%22%3A100%2C%22sorts%22%3A%5B%22id%2Cdesc%22%5D%7D%7D&extendedFields=featureArea%2CtestType')
.getJsonResponse().content

testCases.addAll(testCasesInFolder1)
testCases.addAll(testCasesInFolder2)

def nameListSize = testCases.size()

def r = new Random()

def requirements = Context.get(ApiFactory)
.initRequestObject()
.setHeaders(test)
.get("https://staginggen3platform.staging.katalon.com/v2/tm/requirements?sprintId=93625")
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