package com.qa.testcases;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;

public class GetEmployeePresidentInfo extends TestBase{

	public GetEmployeePresidentInfo() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	TestBase testbase;
	

	
	
	public void setup() throws IOException
		{
			testbase=new TestBase();
			mainURL=prop.getProperty("igateURL");
			apiURL=prop.getProperty("igateUriP");
			
			
			
			bothURL=mainURL+personID+apiURL;
			
			employeeURL=prop.getProperty("igateEmployeeBaseURL");
					
			empEmail=userEmail;
			employeeBaseURL=employeeURL+empEmail;
			
			
		}
		
		int fileLength=reader.getRowCount("Testdata");
		
		@Test
		public void getEmployeePresidentTest() throws ClientProtocolException, IOException
		{
			
			System.out.println("The total number of records are :" + fileLength);
			for (rowCtr=2; rowCtr<=fileLength; rowCtr++)
			{
				setup();
				getEmployeeBaseTestInfo();
				setup();
				testCase="President";
				getEmployeeManagerInfo() ;
			}
			
		}
		
		
		
		public void getEmployeeBaseTestInfo() throws ClientProtocolException, IOException
		{
			restClient=new RestClient();
			
			restClient.get(employeeBaseURL);
			
			getEmployeePersonIDFunction();
			
			
		}
		
		
	   public void getEmployeeManagerInfo() throws ClientProtocolException, IOException
		{
			restClient=new RestClient();
			
			restClient.get(bothURL);
					
			getEmployeeMgrFunction();
			
			
		}
		

		
	
}
