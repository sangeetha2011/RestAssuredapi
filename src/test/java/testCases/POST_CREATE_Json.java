package testCases;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
public class POST_CREATE_Json {
@Test
	 public  void read_All_Products() {
//	{
//    "name" : "james Bond",
//    "price" : "199",
//    "description" : "The detective.",
//    "category_id" : 2,
//    "created" : "2018-06-01 00:35:07"
//}
	
	String payloadpath = ".\\src\\main\\java\\data\\Payload.json";
	
			Response response = 
			given()
			.log().all()
				  .baseUri("https://techfios.com/api-prod/api/product")
				  .header("Content-Type","application/json")
				  .body(new File(payloadpath))
			.when()
				  .post("/create.php")
			.then()
			.log().all()
	         .extract().response();
			
			int statusCode = response.getStatusCode();
			System.out.println("statusCode"+statusCode);
			Assert.assertEquals(statusCode, 200);
			
			long responseTime =  response.getTimeIn(TimeUnit.SECONDS);
			System.out.println("responsetime:"+responseTime);
		//	response.getBody().prettyPrint();
			String responseBody = response.getBody().print();
			System.out.println("Response body:"+ responseBody);
			
			JsonPath jp = new JsonPath(responseBody);
			
			String successmessage = jp.getString("message");
			System.out.println("succesmsg:"+successmessage );
			Assert.assertEquals(successmessage, "Product was created.");
				
		
			
}
	
	
	
	
}
