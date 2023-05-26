package TestClassPackage1;

import java.io.IOException;
import java.time.LocalDate;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

import CommonFunctionsPackage1.CommonFunctionPackage;
import CommonFunctionsPackage1.Utility_CommonFunction;
import RequestRepositoryPackage1.Post_Req_Repository1;

public class Post_TC_4 {
	@Test
	public static void execute() throws IOException {
		for(int i=0;i<5;i++)
		{
		String baseURI=Post_Req_Repository1.base_URI();
		String requestBody=Post_Req_Repository1.post_request4();
		String resource=Post_Req_Repository1.Resource();
		int statusCode=CommonFunctionPackage.response_statusCode(baseURI, resource, requestBody);
		if(statusCode==201)
		{
		String responseBody=CommonFunctionPackage.response_Body(baseURI, resource, requestBody);
		System.out.println(responseBody);
		Post_TC_4.validator(responseBody, statusCode,requestBody );
		Utility_CommonFunction.EvidenceFileCreator("Post_TC_4", requestBody, responseBody);
		break;
		}
		else
		{
		System.out.println("correct status code not found hence retrying");
		}
		}
		}
		public static void validator(String responseBody,int statusCode, String requestBody) throws IOException {
		//Parse response body and its parameters
		JsonPath jspres=new JsonPath(responseBody);
		String res_name=jspres.getString("name");
		String res_job=jspres.getString("job");
		String res_id=jspres.getString("id");
		String res_createdAt=jspres.getString("createdAt");
		String currentdate=LocalDate.now().toString();
		//parse request body and its parameters
		JsonPath jspreq=new JsonPath ( Post_Req_Repository1.post_request4());
		String req_name=jspreq.getString("name");
		String req_job=jspreq.getString("job");
		//Validate the response
		Assert.assertEquals(statusCode,201);
		Assert.assertEquals(req_name, res_name);
		Assert.assertEquals(req_job, res_job);
		Assert.assertNotNull(res_id);
		Assert.assertEquals(res_createdAt.substring(0,10), currentdate);
		}
	}

