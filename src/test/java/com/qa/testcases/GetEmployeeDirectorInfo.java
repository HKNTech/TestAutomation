package com.qa.testcases;

import java.io.IOException;
import com.qa.base.TestBase;
import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.Test;

import com.qa.client.RestClient;



public class GetEmployeeDirectorInfo extends TestBase{

	public GetEmployeeDirectorInfo() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	TestBase testbase;
	

public void setup() throws IOException
	{
	testbase=new TestBase();
	mainURL=prop.getProperty("igateURL");
	apiURL=prop.getProperty("igateUriM");
	
	
	
	bothURL=mainURL+personID+apiURL;
	
	employeeURL=prop.getProperty("igateEmployeeBaseURL");
			
	empEmail=userEmail;
	employeeBaseURL=employeeURL+empEmail;
	
		
		
	}
	
	int fileLength=reader.getRowCount("Testdata");
	
	@Test
	public void getEmployeeDirectorTest() throws ClientProtocolException, IOException
	{
		
		System.out.println("The total number of records are :" + fileLength);
		for (rowCtr=2; rowCtr<=fileLength; rowCtr++)
		{
			setup();
			getEmployeeBaseTestInfo();
			setup();
			testCase="Director";
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

	


