package testCases;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
public class GET_READ_Product {
	SoftAssert softassert = new SoftAssert();
@Test
	 public  void read_one_Product() {
		  
			Response response = 
				given()
				  .baseUri("https://techfios.com/api-prod/api/product")
				  .header("Content-Type","application/json; charset=UTF-8")
				   .queryParam("id","1806")
				.when()
				  .get("/read_one.php")
				.then().extract().response();
				
           int statuscode = response.getStatusCode();
		   System.out.println("statuscode "+ statuscode);
			//Assert.assertEquals(statuscode, 200);
			softassert.assertEquals(statuscode, 200);
		
			long responseTime =  response.getTimeIn(TimeUnit.SECONDS);
			System.out.println("Response time "+responseTime );
			if (responseTime<=200) {
				System.out.println("Response time is within range");
			}else {
				System.out.println("Response time is out of range");
			}
			//response.getBody().prettyPrint();
			String responseBody = response.getBody().asString();
			System.out.println("Response body:"+ responseBody);
			
			JsonPath jp = new JsonPath(responseBody);
			
			String productName = jp.getString("name");
			System.out.println("productName:"+productName );
			//Assert.assertEquals(productName, "James Bond");
			softassert.assertEquals(productName, "James Bond");
			
			String productDescription= jp.getString("description");
			System.out.println("productDescription:"+productDescription );
			//Assert.assertEquals(productDescription, "Dectective book");
			softassert.assertEquals(productDescription, "Dectective book");
			

			String productprice= jp.getString("price");
			System.out.println("productprice:"+productprice );
			//Assert.assertEquals(productprice, "700");
			softassert.assertEquals(productprice, "700");
			
			softassert.assertAll();
			}
			
			
	
	
	
	
	
}
