package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

import com.qa.client.RestClient;
import com.qa.util.Xls_Reader;


public class TestBase {
	public Properties prop;
	public static WebDriver driver;
	public static String responseString;
	public static int rowCtr;
	public static String userEmail;
	public static String personID;
	
	public static String mainURL;
	public static String apiURL;
	public static String bothURL;
	public static RestClient restClient;
	
	public static String employeeURL;
	public static String empEmail;
	public static String employeeBaseURL;
	public static String testCase;
	
	  public static Xls_Reader reader= new Xls_Reader("F:/TestData/UserList.xlsx");
		
		
	
	public TestBase() throws IOException
	{
		prop=new Properties();
		FileInputStream ip;
		try {
			ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		userEmail=reader.getCellData("Testdata", "UserEmail", rowCtr);
	}

	
	public void getEmployeePersonIDFunction()
	{
		//reading PersonId
				JSONObject obj1 = new JSONObject(responseString);
				personID=obj1.getString("P_PERSON_ID");
				System.out.println(" The valus of Person ID is: "+ personID);
	}
	
	public void getEmployeeMgrFunction()
	{
		//reading the hierarchy		
		
				JSONObject obj = new JSONObject(responseString);
				JSONArray jarray=obj.getJSONArray("managers");
				JSONObject gmobj=jarray.getJSONObject(0);
				String mgr=gmobj.getString("actualManager");
				
				if (testCase.equals("SectionManager") )
				{
				System.out.println("Section Manager is  : "+mgr);
				reader.setCellData("Testdata", "SectionManager", rowCtr, mgr);
				}
				else if (testCase.equals("Director") )
				{
					System.out.println("Director is  : "+mgr);
					reader.setCellData("Testdata", "Director", rowCtr, mgr);
				}
				else if (testCase.equals("GM") )
				{
					System.out.println("GM is  : "+mgr);
					reader.setCellData("Testdata", "GM", rowCtr, mgr);
				}
				else if (testCase.equals("VP") )
				{
					System.out.println("VP is  : "+mgr);
					reader.setCellData("Testdata", "VP", rowCtr, mgr);
				}
				else if (testCase.equals("CEO") )
				{
					System.out.println("CEO is  : "+mgr);
					reader.setCellData("Testdata", "CEO", rowCtr, mgr);
				}
				else if (testCase.equals("President") )
				{
					System.out.println("President is  : "+mgr);
					reader.setCellData("Testdata", "President", rowCtr, mgr);
				}
				
	}
	
	
}
