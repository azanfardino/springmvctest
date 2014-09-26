package mytest.spring.biz.json;



public interface JsonParserInterface{
	
	<T> Object fromJson(String json, Class<T> clazz) throws JsonParserException;
	
	

}
