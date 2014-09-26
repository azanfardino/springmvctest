package mytest.spring.biz.json;

import mytest.spring.biz.exception.BusinessException;


public class JsonParserException extends BusinessException{

	private static final long serialVersionUID = 8489548574536858885L;


	public JsonParserException(String message){
		super(message);
	}
	
	
	public JsonParserException(Throwable t){
		super(t);
	}
	
	
	public JsonParserException(String message, Throwable t){
		super(message, t);
	}
}
