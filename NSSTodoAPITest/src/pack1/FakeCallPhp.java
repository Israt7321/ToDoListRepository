package pack1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import JsonPathBookPack.Data;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FakeCallPhp {
	 @BeforeTest
	 public void BasURISetup() {
		 RestAssured.baseURI="http://localhost/fake-API-call.php";		 
	 } 
	 @Test
	 public void GetRequestTest() {
		 RequestSpecification rs=RestAssured
				 .given()
				 .body("")
				 .when()
				 .contentType(ContentType.JSON);getClass();
				 Response resp =rs.request(Method.GET,"/Catagory");
		 JsonPath jp=resp.jsonPath();
				 
		 //Test service status of the API endpoint (only one in this case)
			int gtStatus = resp.getStatusCode();
			System.out.println("Test service status of the API endpoint: "+gtStatus);
	
		// 2.Find how many tasks do not have "category" assigned
			 Response resp2=rs.request(Method.GET, "/catagory");
	     //5. Count and validate the number of tasks
			 	
	}/* Note:There can be more than below suggested test cases.
	 4. Read API response and print tasks in descending "due date" order
	
		// 3.Aggregate and print only "task names"
			List<Data>AllTask=jp.getList("",Data.class);
			for(Data data:allData) {
			int totaltask =AllTask.size();
			File f=new File("C:\\BookList\\Books.xls");
			FileWriter fw=new FileWriter(f);
			BufferedWriter bw=new BufferedWriter(fw);
			for(Data data:allData) {
					bw.write("Title is :"+data.title);
					bw.newLine();
			
	}
	
			
	*/ }			 


