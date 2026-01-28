import com.common.ApiFactory
import com.common.Context
import com.kms.katalon.core.util.KeywordUtil

Map<String, String> test = new HashMap<String, String>()

test.put('Authorization', 'Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJqWVpYSzBWUHROcDRpaVJzcUlfT3Q4LW56NURCRXNlM0VFd2RHSEZfUjZVIn0.eyJleHAiOjE3NjkwNjg2MTYsImlhdCI6MTc2OTA2MzIxNiwianRpIjoib25sdGFjOjAxNmMxNGQyLWU2MTMtMzA1NC0xYTVhLTJmODA5Zjg0NDM4YSIsImlzcyI6Imh0dHBzOi8vbG9naW4ucWEua2F0YWxvbi5jb20vcmVhbG1zL2thdGFsb24iLCJzdWIiOiJmM2ZiNzMxNy1hM2RhLTQzYWQtOGRlNy05Mjc0NGUxOTIxYTgiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJrYXRhbG9uLXRlc3RvcHMtZ2VuMyIsInNpZCI6IjEwOGZjNDAzLTRhYTQtZTdkOC0zYjM0LTI5NzBiYWY2ZWM2ZiIsInNjb3BlIjoib3BlbmlkIHByb2ZpbGUgZW1haWwgYmFzaWMgcm9sZXMiLCJhY2NvdW50X3V1aWQiOiIyMTZjZTk5OS0wOWE0LTRiYzItYmYyMC0wNDdlZjBkMmI5ODciLCJlbWFpbCI6Im1hbi5odWFAa2F0YWxvbi5jb20ifQ.GVYSLG-eKypqowZefskYkL7IY6xzzyJMtG6jvsToeVKDSm5rn1yt_yH6bXLbNTd50mSMeWWHfn-Ec8OBRuXSAp_99y811ex7RnMM1mAJMx6ZcFXEea3uhzZmaNRrL_HBSVfJY5ZJh1yNa2qRLHrbhQIHPUhBviqfQiRbYglxUrabQL0R8GT68mYG_GIt0BTKshm-FI_JEUQD4paIuuAOWB_6RHIrUXMqqNuMRbAHJ0xcZs9AB059tu0Os5Mc4QRa33eolaPpzLEu0Te3-8Kr3xcyE3lCNSBkuCbGv9yfX_d08TEuk6OJarJvCv6m0KY77jYg1YtpogqacHEPGBrWvw')

test.put('x-organization-id', '14475')

test.put('x-project-id', '28459')

test.put('x-account-id', '216ce999-09a4-4bc2-bf20-047ef0d2b987')

def jsonRes = Context.get(ApiFactory)
.setHeaders(test)
.setApplicationJsonContentType()
.post('https://qagen3platform.qa.katalon.com/api/v1/search', """
{
    "type": "Execution",
    "conditions": [
        { "key": "Project.id","operator": "=","value": 28459 },
		{ "key": "startTime", "operator": ">=", "value": "2026-01-01T05:53:43.852Z" }
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
	Context.get(ApiFactory).post("https://qagen3platform.qa.katalon.com/v2/schedules/test-runs/${res.id}/link-iteration", """
	{
	    "releaseId": 27148,
	    "sprintId": null
	}
	""").getJsonResponse().content
	
	count++
	if(count == 50)
		break
}

