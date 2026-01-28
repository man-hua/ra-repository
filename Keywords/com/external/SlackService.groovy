package com.external

import com.common.ApiFactory
import com.common.Context

class SlackService {

	def notify(String message) {
		Context.get(ApiFactory)
				.post('https://hooks.slack.com/services/XXX').res
	}
}
