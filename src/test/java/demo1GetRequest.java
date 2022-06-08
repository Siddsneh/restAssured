import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class demo1GetRequest {

	
	@Test
	public void getDetails() {
		RestAssured.baseURI="http://localhost:3000/posts";
		
		RequestSpecification httprequest=RestAssured.given();
		
		//Response response=httprequest.request(Method.GET,"/posts");
		Response response=httprequest.get("/1");
		
		String responseBody=response.getBody().asString();
		System.out.print(responseBody);
		System.out.println(responseBody.contains("typicode"));
		
		
		int statuscode=response.getStatusCode();
		System.out.println(statuscode);
		Assert.assertEquals(statuscode, 200);
		
		
		String statusline=response.getStatusLine();
		System.out.println(statusline);
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
		
		
		JsonPath jsonpath=response.jsonPath();
		System.out.println(jsonpath.get("title"));
		System.out.println(jsonpath.get("author"));
		
		
	}
	
}
