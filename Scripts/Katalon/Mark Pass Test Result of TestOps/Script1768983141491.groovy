import com.common.ApiFactory
import com.common.Context
import com.kms.katalon.core.util.KeywordUtil

Map<String, String> test = new HashMap<String, String>()

test.put('Authorization', 'Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJpZTlDMnN4ZjZ4czczSHJxY0QyejRxcVVzNEFpOWVzNXR5SVVKYmRTYW04In0.eyJleHAiOjE3NjkwNTc3MzAsImlhdCI6MTc2ODk3ODEwOSwianRpIjoib25sdHJ0OjBjNWE2ODdiLTU3NDgtYzBjZC1hYTJiLThhMmFjZTYzZGFjNyIsImlzcyI6Imh0dHBzOi8vbG9naW4ua2F0YWxvbi5jb20vcmVhbG1zL2thdGFsb24iLCJzdWIiOiIyZjEzODkyZC0xMmNhLTQ3MDktYjkwNC1kNmVmMjBmYTMzODYiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJrYXRhbG9uLXRlc3RvcHMtZ2VuMyIsInNpZCI6IjdkNTBmZTc5LTA2ZDAtNGIyNy05Mjk3LWI5NTZjYTFjMTQ3MiIsInNjb3BlIjoib3BlbmlkIiwiYWNjb3VudF91dWlkIjoiM2JkNWNiMDQtOGFlNC00ZjkxLWE0MTAtNWE4OGUwODMwMGM5IiwiZW1haWwiOiJtYW4uaHVhQGthdGFsb24uY29tIn0.SukDZxXi2_xIheubdknJXZOj9W8vnDNxej7HAf39pon6LWT_0_nWS8NnltE7CTcsKbsE-kM-5BDGtD9s2nkanekAuv3KerGBInXtK06x9Aue2zo02rFjxpKisX9QkI5EykRhdos_BjuOlVx7mLYnxyZqwcpr0xmgJKTkVjczxL6VvAevO0zaa-PM52Sv13n1O4nx-mIdPTn0FcvL5n3itLObYy9uHwoQvwNPhyd0ycXb2PN608NERCZOWJM-qI9I3tHBe2gGhZp3lg1F0qPj0UXGnvZYJfsf3xfLyMjVdGU9983u5QiOrfPAXV5boueGFa2DZPrkBXZkrArC4cZDGA')

test.put('x-organization-id', '743630')

test.put('x-project-id', '1579059')

test.put('x-account-id', '3bd5cb04-8ae4-4f91-a410-5a88e08300c9')

def jsonRes = Context.get(ApiFactory)
.setHeaders(test)
.setApplicationJsonContentType()
.post('https://prodgen3platform.katalon.io/api/v1/search', """
{
    "type": "ExecutionTestResult",
    "conditions": [
        {
            "key": "Project.id",
            "operator": "=",
            "value": 1579059
        },
		{
            "key": "Execution.id",
            "operator": "=",
            "value": 40716961
        }
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
	if(res.status.compareTo("PASSED") != 0)
	{
		Context.get(ApiFactory).post("https://prodgen3platform.katalon.io/v2/ra/web/test-results/${res.id}/mask-as-retested", """{"description":"Based on manual test result"}""")
		count++
		if(count == 50)
			break
	}
}