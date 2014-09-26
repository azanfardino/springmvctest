package mytest.spring.biz.exception;


public class BusinessException extends RuntimeException{

	
	private static final long serialVersionUID = 7984261499344796604L;


	public BusinessException(String message){
		super(message);
	}
	
	
	public BusinessException(Throwable t){
		super(t);
	}
	
	
	public BusinessException(String message, Throwable t){
		super(message, t);
	}
	
	
}
