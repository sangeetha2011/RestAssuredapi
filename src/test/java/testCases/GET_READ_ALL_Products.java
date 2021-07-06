package testCases;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;
public class GET_READ_ALL_Products {
@Test
	 public  void read_All_Products() throws InterruptedException {
		  
			Response response = 
				given()
				 .baseUri("https://techfios.com/api-prod/api/product")
				 
				   .header("Content-Type","application/json; charset=UTF-8")
				.when()
				  .get("/read.php")
				.then()
				  .extract().response();
		
			int statuscode = response.getStatusCode();
			
			System.out.println("statuscode "+ statuscode);
			Assert.assertEquals(statuscode, 200);
			//System.out.println("Response:"+ response.asString());
			//response.getBody().prettyPrint();
			String responseBody = response.getBody().asString();
			//System.out.println("Response body:"+ response.getBody().print());
			System.out.println("Response body:"+ responseBody);
			
				
			}
			
			
	
	
	
	
	
}
