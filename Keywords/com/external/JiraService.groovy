package com.external

import com.common.ApiFactory
import com.common.Context

class JiraService {

    def createBug(String summary) {
		Context.get(ApiFactory).post('https://jira.example.com/rest/api/2/issue',"""
        {
          "fields": {
            "project": { "key": "QA" },
            "summary": "${summary}",
            "issuetype": { "name": "Bug" }
          }
        }
        """)
    }
}
