package testCases;

import static io.restassured.RestAssured.given;

import java.io.File;

import io.restassured.response.Response;

public class PUT_Update_Product {
	
	public void put_update_prodct() {
		String payloadpath = ".\\src\\main\\java\\data\\Payload2.json_1924";
		Response response = 
				given()
				.log().all()
					  .baseUri("https://techfios.com/api-prod/api/product")
					  .header("Content-Type","application/json")
					  //.body(payload)
					  .body(new File(payloadpath))
				.when()
					  .put("/update.php")
				.then()
				.log().all()
		         .extract().response();
		
		
	}
	
	
	
	
	

}
