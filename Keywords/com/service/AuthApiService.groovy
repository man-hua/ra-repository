package com.service

import com.common.ApiFactory
import com.common.Context

class AuthApiService {

	def login(String email, String password) {
		Context.get(ApiFactory).post("https://reqres.in/api/login", """
        {
          "email": "${email}",
          "password": "${password}"
        }
        """).res
	}
}
