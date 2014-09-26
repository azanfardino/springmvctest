package mytest.spring.biz.factory.impl;

import mytest.spring.biz.factory.AbstractFactoryInterface;
import mytest.spring.biz.http.HttpClientInterface;
import mytest.spring.biz.http.impl.ApacheHttpClient;
import mytest.spring.biz.json.JsonParserInterface;
import mytest.spring.biz.json.impl.GoogleGsonParser;

public class AbstractFactoryImpl implements AbstractFactoryInterface{

	
	public HttpClientInterface createHTTPClient(String url) {
		return new ApacheHttpClient(url);
	}

	
	public HttpClientInterface createHTTPClient(String url, String proxyHost, int proxyPort) {
		return new ApacheHttpClient(url, proxyHost, proxyPort);
	}

	
	public JsonParserInterface createJasonParser() {
		return new GoogleGsonParser();
	}

	
}
