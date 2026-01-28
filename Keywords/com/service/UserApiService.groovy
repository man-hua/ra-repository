package com.service

import com.common.ApiFactory
import com.common.Context

class UserApiService {

	def getUser(int id) {
		Context.get(ApiFactory)
				.get("https://reqres.in/api/users/${id}").res
	}
}
