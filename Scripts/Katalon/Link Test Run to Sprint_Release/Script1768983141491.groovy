import com.common.ApiFactory
import com.common.Context
import com.kms.katalon.core.util.KeywordUtil

Map<String, String> test = new HashMap<String, String>()

test.put('Authorization', 'Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJqWVpYSzBWUHROcDRpaVJzcUlfT3Q4LW56NURCRXNlM0VFd2RHSEZfUjZVIn0.eyJleHAiOjE3NzAzNzE3NDAsImlhdCI6MTc3MDE5ODk0MCwianRpIjoib25sdGFjOjYzMzg4NTM5LTI3Y2EtZmI3MS1mOTg0LTYwMzQ4ZTdmNGVjYiIsImlzcyI6Imh0dHBzOi8vbG9naW4uc3RhZ2luZy5rYXRhbG9uLmNvbS9yZWFsbXMva2F0YWxvbiIsInN1YiI6IjQyMTBhNjkxLTA1NmEtNDVhOS04MDI3LWI0ZjJlM2MzNjM5YiIsInR5cCI6IkJlYXJlciIsImF6cCI6ImthdGFsb24tdGVzdG9wcy1nZW4zIiwic2lkIjoiYTM3NGFhNzctNWEyMi03M2Q4LWFhYzktODA0ZTg0MWY2MmY5Iiwic2NvcGUiOiJvcGVuaWQiLCJhY2NvdW50X3V1aWQiOiI4ZDdjODM0MC01YmFjLTRjZmUtOTMyNi1jMDQ0NmFkZjg4MTYiLCJlbWFpbCI6Im1hbi5odWFAa2F0YWxvbi5jb20ifQ.MWeWkX4TqmbYEMi-p9b7OLmmPcwTPwDhBm02tu6ZqFaneckIUmqvliGh3srIBP__uVYFH6-SEKFv3g11os5oU_oVdkokI8mlW-gMHDzAnD7ddqvqHKzLtYLGvKtjtLcyaNjKvGyoID0MM76X3WI2fiqCRFe4D6pourI-oA-nzw5gH0_9_KgagEBOKTBPxkMnYAx_i_VJzwW_WBpI2eYs6WPQmPkEcAFNscLQb7gw0SFLkmkCMQZkRtTW0EkUI511IyyzhB6jYM7Aulr1YIhpq0i1dKkIPErq7evZYnIKM3Yg5eYxk0V6sSHFmQtCJL4ibgGDXf-H7UWAXwYz_Nuhqg')

test.put('x-organization-id', '439875')

test.put('x-project-id', '623365')

test.put('x-account-id', '8d7c8340-5bac-4cfe-9326-c0446adf8816')

def jsonRes = Context.get(ApiFactory)
.setHeaders(test)
.setApplicationJsonContentType()
.post('https://staginggen3platform.staging.katalon.com/api/v1/search', """
{
    "type": "Execution",
    "conditions": [
        { "key": "Project.id","operator": "=","value": 623365 },
		{ "key": "startTime", "operator": ">=", "value": "2026-02-05T05:53:43.852Z" }
    ],
    "pagination": {
        "page": 0,
        "size": 200,
        "sorts": [
            "id,desc"
        ]
    }
}
""").getJsonResponse().content

int count = 0
for(res in jsonRes) {
	Context.get(ApiFactory).post("https://staginggen3platform.staging.katalon.com/v2/schedules/test-runs/${res.id}/link-iteration", """
	{
	    "releaseId": null,
	    "sprintId": 93625
	}
	""").getJsonResponse().content
	
	count++
	if(count == 50)
		break
}

