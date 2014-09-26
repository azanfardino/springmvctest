package mytest.spring.biz.factory;

import mytest.spring.biz.http.HttpClientInterface;
import mytest.spring.biz.json.JsonParserInterface;

public interface AbstractFactoryInterface {

	HttpClientInterface createHTTPClient(String url);
	
	HttpClientInterface createHTTPClient(String url, String proxyHost, int proxyPort);
	
	JsonParserInterface createJasonParser();
	
	//FileManagerInterface createFileManager(String path);
	
	
}
