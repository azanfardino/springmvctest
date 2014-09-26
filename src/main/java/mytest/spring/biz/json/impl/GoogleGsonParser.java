package mytest.spring.biz.json.impl;

import mytest.spring.biz.json.JsonParserException;
import mytest.spring.biz.json.JsonParserInterface;

import com.google.gson.Gson;

public class GoogleGsonParser implements JsonParserInterface {
	
	

	public <T> Object fromJson(String json, Class<T> clazz)
			throws JsonParserException {

		Gson gson = new Gson();

		return gson.fromJson(json, clazz);
	}


}
