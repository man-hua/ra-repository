package com.service

import com.common.ApiFactory
import com.common.Context

class OrderApiService {

	def createOrder(String token) {
		Context.get(ApiFactory)
				.post('https://api.example.com/orders','').res
	}
}
