package com.service

import static com.kms.katalon.core.testobject.ConditionType.EXPRESSION

import com.common.ApiFactory
import com.common.Context
import com.kms.katalon.core.testobject.TestObjectProperty

class GuruApiService{

	def listAPI(String user, String pass) {
		Context.get(ApiFactory)
				.setApplicationJsonContentType()
				.get("http://api.apis.guru/v2/list.json").res
	}
}
