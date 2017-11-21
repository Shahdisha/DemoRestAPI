package com.qa.tests;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.clients.RestClient;

public class GetAPITest extends TestBase{
	TestBase testBase;
	String apiURL;
	String serviceURL;
	String url;
	RestClient restClient;
	
	@BeforeClass
	public void setUp(){
		testBase = new TestBase();
		String apiURL = prop.getProperty("URL");
		String serviceURL = prop.getProperty("serviceURL");
		
		url = apiURL +serviceURL;	
	}	
	
	@Test
	public void getAPITest() throws ClientProtocolException, IOException, JSONException{
		restClient = new RestClient();
		restClient.get(url);
	}

}
