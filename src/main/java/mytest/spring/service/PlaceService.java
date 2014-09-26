package mytest.spring.service;

import mytest.spring.biz.exception.BusinessException;
import mytest.spring.biz.factory.AbstractFactoryInterface;
import mytest.spring.biz.http.HttpClientInterface;
import mytest.spring.biz.json.JsonParserInterface;
import mytest.spring.model.Place;

import org.apache.commons.lang3.StringUtils;

public class PlaceService {

	AbstractFactoryInterface abstractFactory;

	private String baseURL;

	private String proxy;

	private Integer port;

	

	public PlaceService(AbstractFactoryInterface abstractFactory, String baseURL) {
		this.abstractFactory = abstractFactory;
		
		this.baseURL = baseURL;
	}

	public PlaceService(AbstractFactoryInterface abstractFactory, String baseURL, String proxy, Integer port) {
		this(abstractFactory, baseURL);

		this.proxy = proxy;

		this.port = port;
	}


	
	
	public Place[] findPlace(String text) throws BusinessException {

		String res = getResource(text);

		return parseResource(res);
	}
	
	

	private String getResource(String text) throws BusinessException {

		HttpClientInterface httpClient;
		
		String url = baseURL + text;

		if (isValidProxy()) {
			httpClient = abstractFactory.createHTTPClient(url, proxy, port);
		} else {
			httpClient = abstractFactory.createHTTPClient(url);
		}

		return httpClient.get();

	}
	
	

	private Place[] parseResource(String json) throws BusinessException {
		
		JsonParserInterface jsonParser = abstractFactory.createJasonParser();

		return (Place[]) jsonParser.fromJson(json, Place[].class);
	}

	
	private boolean isValidProxy() {
	
		return StringUtils.isNotEmpty(proxy) && port != null;
		
	}
}
