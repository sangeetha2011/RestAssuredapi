package testCases;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DELETE_product {
@Test	
	public void Delete_product() {
		String payloadpath = ".\\src\\main\\java\\data\\payload3.json";
		Response response = 
				given()
				.log().all()
					  .baseUri("https://techfios.com/api-prod/api/product")
					  .header("Content-Type","application/json")
					  //.body(payload)
					  .body(new File(payloadpath))
				.when()
					  .delete("/delete.php")
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
		Assert.assertEquals(successmessage, "Product was deleted.");
	
		
	}
	
	
	
	
	

}
