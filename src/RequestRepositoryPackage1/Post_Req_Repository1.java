package RequestRepositoryPackage1;

import java.io.IOException;
import java.util.ArrayList;

import CommonFunctionsPackage1.Utility_CommonFunction;

public class Post_Req_Repository1 {
	public static String base_URI() {
		
		String base_URI="https://reqres.in/";
		return base_URI;
	}
	
	public static String Resource() {
		
		String Resource="/api/users";
		return Resource;
	}
public static String post_req_tc2() throws IOException {
	ArrayList<String> data=Utility_CommonFunction.readDataExcel("POST_Test_Data","Post_tc_2");
	String req_name=data.get(1);
	String req_job=data.get(2);
		
		String RequestBody="{\r\n"
				+ "    \"name\": \""+req_name+"\",\r\n"
				+ "    \"job\": \""+req_job+"\"\r\n"
				+ "}";
		return RequestBody;
	}
public static String post_request3() throws IOException {
ArrayList<String>data=Utility_CommonFunction.readDataExcel("POST_Test_Data","Post_TC_3");
String req_name=data.get(1);
String req_job=data.get(2);

	String RequestBody="{\r\n"
			+ " \"name\": \""+req_name+"\",\r\n"
			+ " \"job\": \""+req_job+"\"\r\n"
			+ "}";
return RequestBody;
}
public static String post_request4() throws IOException {
ArrayList<String>data=Utility_CommonFunction.readDataExcel("POST_Test_Data","Post_TC_4");
String req_name=data.get(1);
String req_job=data.get(2);

	String RequestBody="{\r\n"
			+ " \"name\": \""+req_name+"\",\r\n"
			+ " \"job\": \""+req_job+"\"\r\n"
			+ "}";
return RequestBody;
}
}


