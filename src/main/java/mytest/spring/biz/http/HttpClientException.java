package mytest.spring.biz.http;

import mytest.spring.biz.exception.BusinessException;


public class HttpClientException extends BusinessException{

	private static final long serialVersionUID = -2210534714310163702L;


	public HttpClientException(String message){
		super(message);
	}
	
	
	public HttpClientException(Throwable t){
		super(t);
	}
	
	
	public HttpClientException(String message, Throwable t){
		super(message, t);
	}
}
