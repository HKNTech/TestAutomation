package com.qa.testcases;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;

public class GetAPITest extends TestBase{

	TestBase testbase;
	
	public GetAPITest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	@BeforeMethod
	public void setup() throws IOException
	{
		testbase=new TestBase();
		mainURL=prop.getProperty("igateURL");
		apiURL=prop.getProperty("igateUri");
		
		
		
		bothURL=mainURL+personID+apiURL;
		
		employeeURL=prop.getProperty("igateEmployeeBaseURL");
		//empEmail=prop.getProperty("employeeEmail");
		
		empEmail=userEmail;
		employeeBaseURL=employeeURL+empEmail;
		
		
	}
	
			
	
	@Test(priority=1)
	public void getEmployeeBaseTest() throws ClientProtocolException, IOException
	{
		restClient=new RestClient();
		
		restClient.get(employeeBaseURL);
		
		getEmployeePersonIDFunction();
		
		
	}
	
	
	@Test (priority=2)
	public void getEmployeeManagerTest() throws ClientProtocolException, IOException
	{
		restClient=new RestClient();
		
		restClient.get(bothURL);
				
		getEmployeeMgrFunction();
		
		
	}
	
}
