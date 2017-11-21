package com.qa.clients;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class RestClient {
	
	
	//1.GET Method
	public void get(String url) throws ClientProtocolException, IOException, JSONException{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url); // Get URL
		CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet); // Execute URL
		
	//Status Code
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode(); // Get StatusLine and StatusCode
		System.out.println("Status Code...."+statusCode);
	
	//Json String
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8"); //Getting response in String
		JSONObject responseJSON = new JSONObject(responseString); // Response in JSON
		System.out.println("Response in JSON...."+responseJSON);
		
	//All Headers
		Header[] headerArray = closeableHttpResponse.getAllHeaders();
		HashMap<String , String> allHeaders = new HashMap<String , String>();
		
		for(Header header : headerArray){
			allHeaders.put(header.getName(), header.getValue());
		}
		
		System.out.println("Headers Array...."+allHeaders);
		
		
		
	}
	 

}
