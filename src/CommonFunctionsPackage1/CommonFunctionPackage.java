package CommonFunctionsPackage1;

import static io.restassured.RestAssured.given;

//import RequestRepositoryPackage1.Post_Req_Repository1;
import io.restassured.RestAssured;

public class CommonFunctionPackage {
 public static int response_statusCode(String base_URI,String Resource,String RequestBody) {
	 
	// String baseurl=Post_Req_Repository1.base_URI();
		RestAssured.baseURI= base_URI;
		
		//configure request body
		int statusCode=given().header("Content-Type","application/json").body(RequestBody).when().post(Resource)
		.then().extract().statusCode();
		return statusCode;
		
		
 }
 public static String response_Body(String base_URI,String Resource,String RequestBody) {
	 
	// String baseurl=Post_Req_Repository1.base_URI();
		RestAssured.baseURI= base_URI;
		
		
		String res_Body=given().header("Content-Type","application/json").body(RequestBody).when().post(Resource)
		        .then().extract().response().asString();	
		return res_Body;
 } 

}
