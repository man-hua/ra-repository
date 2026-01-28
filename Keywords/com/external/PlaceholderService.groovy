package com.external

import com.common.ApiFactory
import com.common.Context

class PlaceholderService {

	def createPost(String title) {
		Context.get(ApiFactory).post("https://jsonplaceholder.typicode.com/posts","""
        {
          "title": "${title}",
          "body": "test body",
          "userId": 1
        }
        """).res
	}
}
