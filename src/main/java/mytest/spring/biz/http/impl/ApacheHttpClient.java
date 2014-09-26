package mytest.spring.biz.http.impl;

import java.io.IOException;

import mytest.spring.biz.http.HttpClientException;
import mytest.spring.biz.http.HttpClientInterface;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.log4j.Logger;


public class ApacheHttpClient implements HttpClientInterface{

	private static final Logger logger = Logger.getLogger(ApacheHttpClient.class);
	
	private String url;
	
	private boolean useProxy;
	
	private String host;
	
	private int port;
	
	
	
	public ApacheHttpClient(String url){
		this.url = url;
	}
	
	public ApacheHttpClient(String url, String host, int port){
		this(url);
		this.host = host;
		this.port = port;
		this.useProxy = true;
	}
	
	
    
	public String get() throws HttpClientException {
		HttpClient client = new HttpClient();
		
		if (useProxy){
			logger.debug("Using http proxy. Host: " + host + " port: " + port);
			client.getHostConfiguration().setProxy(host, port);
		}
		
	    GetMethod method = new GetMethod(this.url);
	    

	    method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, 
	    		new DefaultHttpMethodRetryHandler(3, false));
	
	    try {
	    	
	      logger.debug("connectiong to url: " + url);
	      
	      int statusCode = client.executeMethod(method);
	
	      if (statusCode != HttpStatus.SC_OK) {
	    	  throw new HttpClientException("Method failed - " + method.getStatusLine());
	      }
	
	      
	      byte[] responseBody = method.getResponseBody();	
	      
	      String bodyString = new String(responseBody, "UTF-8");
	      
	      
	      logger.debug("HTTP Response body : " + bodyString);
	      
	      return bodyString;
	
	    } catch (HttpException e) {
	      throw new HttpClientException("Protocol violation " , e);
	    } catch (IOException e) {
	    	throw new HttpClientException("Transport error " , e);
	    } finally {
	      method.releaseConnection();
	    }  
	}
	
	
}
