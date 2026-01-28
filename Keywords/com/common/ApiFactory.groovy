package com.common

import org.openqa.selenium.remote.http.HttpMethod

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import groovy.json.JsonSlurper

public class ApiFactory {
	RequestObject req = new RequestObject()
	ResponseObject res = null
	ArrayList<TestObjectProperty> headers = new ArrayList<TestObjectProperty>()

	public ApiFactory initRequestObject() {
		req = new RequestObject()
		headers.clear()
		return this
	}

	public ApiFactory initRequestObjectWithoutHeader() {
		req = new RequestObject()
		this.setHeaders(this.headers)
		return this
	}
	
	private ApiFactory setHeaderProperties() {
		req.setHttpHeaderProperties(this.headers)
		return this
	}

	public <T> ApiFactory setHeaders(T headers) {
		if(!headers)
			return this

		if(headers instanceof ArrayList) {
			this.headers.addAll(headers)
		}
		else if (headers instanceof HashMap) {
			this.headers.addAll(headers.collect{k, v -> new TestObjectProperty(k, ConditionType.EQUALS, v)})
		}
		this.setHeaderProperties()
		return this
	}

	private ApiFactory addHeader(TestObjectProperty header) {
		if(!header)
			return this
		this.headers.add(header)
		this.setHeaderProperties()
		return this
	}

	public ApiFactory setContentTypeHeader(String contentType) {
		this.addHeader(new TestObjectProperty("Content-Type", ConditionType.EXPRESSION.EQUALS, contentType))
		return this
	}

	public ApiFactory setApplicationJsonContentType() {
		this.setContentTypeHeader("application/json")
		return this
	}

	public ApiFactory setPayload(String body) {
		if(!body)
			return this
		req.setBodyContent(new HttpTextBodyContent(body))
		return this
	}

	public ApiFactory setUrl(String url) {
		req.setRestUrl(url)
		return this
	}

	private ApiFactory sendRequest() {
		res = WS.sendRequest(req)
		return this
	}

	private ApiFactory setRestRequestMethod(HttpMethod method) {
		req.setRestRequestMethod(method.toString())
		return this
	}

	public ApiFactory get(String url, ArrayList<TestObjectProperty> headers = null) {
		this.setUrl(url).setHeaders(headers).setRestRequestMethod(HttpMethod.GET).sendRequest()
		return this
	}

	public ApiFactory post(String url, String body = null, ArrayList<TestObjectProperty> headers = null) {
		this.setUrl(url).setHeaders(headers).setPayload(body).setRestRequestMethod(HttpMethod.POST).sendRequest()
		return this
	}

	public ApiFactory put(String url, String body, ArrayList<TestObjectProperty> headers = null) {
		this.setUrl(url).setHeaders(headers).setPayload(body).setRestRequestMethod(HttpMethod.PUT).sendRequest()
		return this
	}

	public ApiFactory delete(String url, ArrayList<TestObjectProperty> headers = null) {
		this.setUrl(url).setHeaders(headers).setRestRequestMethod(HttpMethod.DELETE).sendRequest()
		return this
	}

	public Object getJsonResponse() {
		return new JsonSlurper().parseText(this.res.getResponseBodyContent())
	}

	public ApiFactory verifyJsonResponseValue(String path, String expected) {
		def jsonBody = this.getJsonResponse()

		if(!jsonBody)
			return this

		def currentNode = jsonBody
		path.split(".").each { it ->
			if(it.contains("[") == 0) {
			}
			currentNode = currentNode[it]
		}
	}
}