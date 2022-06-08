import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class demo2GetRequest {
	
	@Test
	public void getRequest() {
		
		//provide base uri
		RestAssured.baseURI="http://localhost:3000/comments";
		
		//specify request object
		RequestSpecification httpRequest=RestAssured.given();
		
		//provide request
		Response response=httpRequest.get("/1");
		
		String responseBody=response.getBody().asString();
		System.out.println(responseBody);
		System.out.println(responseBody.contains("some comment"));
		
		int statusCode=response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode,200);
		
		String statusLine=response.getStatusLine();
		System.out.println(statusLine);
		Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
	}
	

}
