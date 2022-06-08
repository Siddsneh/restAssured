import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class demo4PostRequest1 {
	
	
	@Test
	public static void m1() {
		
RestAssured.baseURI="http://localhost:3000/profile/";
		
		RequestSpecification httpRequest=RestAssured.given();
		
		httpRequest.header("Content-Type","application/json");
		JSONObject object=new JSONObject();
		object.put("FirstName", "sidd");
		object.put("LastName", "bhoi");
		object.put("Username", "sidd@123");
		object.put("Password", "sidd@1234");
		object.put("Email", "sidd@12345");
		
		
		httpRequest.body(object.toString());
		
		Response response=httpRequest.post();
		String responseBody=response.body().toString();
		System.out.println(responseBody);
		
		
		int statusCode=response.getStatusCode();
		
		System.out.println(statusCode);
		
		String contentType=response.header("Content-type");
		System.out.println(contentType);
		
		Headers allHeaders=response.headers();
		
		for(Header header:allHeaders) {
			
			System.out.println(header.getName()+" "+header.getValue());
		}
		
	}
	

}
