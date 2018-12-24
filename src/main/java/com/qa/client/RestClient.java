package com.qa.client;

import java.io.IOException;
import java.util.HashMap;
import com.qa.base.TestBase;
import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class RestClient extends TestBase{

	
	
	
	public RestClient() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void get(String url) throws ClientProtocolException, IOException
	{
		CloseableHttpClient httpclient=HttpClients.createDefault();
		HttpGet httpget=new HttpGet(url);
		
		//hit the GET url
		CloseableHttpResponse closeablehttpresponse=httpclient.execute(httpget);
		
		//Status Code
		int statuscode=closeablehttpresponse.getStatusLine().getStatusCode();
		System.out.println("Status code is :"+ statuscode);
		
				
		//JSON String
		
		responseString=EntityUtils.toString(closeablehttpresponse.getEntity(),"UTF-8");
		System.out.println("Response JSON from API is :"+ responseString);
		
				
		//Get All Headers
		
		Header[] headersArray=closeablehttpresponse.getAllHeaders();
		HashMap<String, String> allHeaders=new HashMap<String,String>();
		
		for(Header header:headersArray)
		{
			allHeaders.put(header.getName(),header.getValue());
		}
		
		System.out.println("Headers Array is :"+ allHeaders);
		
			
		
	}
	
}
